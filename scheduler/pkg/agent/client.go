package agent

import (
	"context"
	"fmt"
	"io"
	"math"
	"time"

	seldontls "github.com/seldonio/seldon-core-v2/components/tls/pkg/tls"
	"google.golang.org/grpc/credentials"
	"google.golang.org/grpc/credentials/insecure"

	grpc_middleware "github.com/grpc-ecosystem/go-grpc-middleware"
	"go.opentelemetry.io/contrib/instrumentation/google.golang.org/grpc/otelgrpc"
	"google.golang.org/protobuf/proto"

	"github.com/seldonio/seldon-core/scheduler/pkg/agent/config"
	"github.com/seldonio/seldon-core/scheduler/pkg/agent/interfaces"
	"github.com/seldonio/seldon-core/scheduler/pkg/agent/modelscaling"
	"github.com/seldonio/seldon-core/scheduler/pkg/metrics"
	"github.com/seldonio/seldon-core/scheduler/pkg/util"

	backoff "github.com/cenkalti/backoff/v4"
	grpc_retry "github.com/grpc-ecosystem/go-grpc-middleware/retry"
	"github.com/seldonio/seldon-core/scheduler/apis/mlops/agent"
	pbs "github.com/seldonio/seldon-core/scheduler/apis/mlops/scheduler"
	k8s "github.com/seldonio/seldon-core/scheduler/pkg/agent/k8s"
	"github.com/seldonio/seldon-core/scheduler/pkg/agent/repository"
	log "github.com/sirupsen/logrus"
	"google.golang.org/grpc"
	"google.golang.org/protobuf/encoding/protojson"
)

type Client struct {
	logger                   log.FieldLogger
	configChan               chan config.AgentConfiguration
	replicaConfig            *agent.ReplicaConfig
	stateManager             *LocalStateManager
	rpHTTP                   interfaces.DependencyServiceInterface
	rpGRPC                   interfaces.DependencyServiceInterface
	agentDebugService        interfaces.DependencyServiceInterface
	modelScalingService      interfaces.DependencyServiceInterface
	metrics                  metrics.AgentMetricsHandler
	modelScalingClientStream agent.AgentService_ModelScalingTriggerClient
	ClientServices
	SchedulerGrpcClientOptions
	KubernetesOptions
}

type SchedulerGrpcClientOptions struct {
	schedulerHost         string
	schedulerPlaintxtPort int
	schedulerTlsPort      int
	serverName            string
	replicaIdx            uint32
	conn                  *grpc.ClientConn
	callOptions           []grpc.CallOption
	certificateStore      *seldontls.CertificateStore
}

type KubernetesOptions struct {
	secretsHandler *k8s.SecretHandler
	namespace      string
}

type ClientServices struct {
	ModelRepository repository.ModelRepository
}

func ParseReplicaConfig(json string) (*agent.ReplicaConfig, error) {
	config := agent.ReplicaConfig{}
	err := protojson.Unmarshal([]byte(json), &config)
	if err != nil {
		return nil, err
	}
	return &config, nil
}

func NewClient(serverName string,
	replicaIdx uint32,
	schedulerHost string,
	schedulerPlaintxtPort int,
	schedulerTlsPort int,
	logger log.FieldLogger,
	modelRepository repository.ModelRepository,
	v2Client *V2Client,
	replicaConfig *agent.ReplicaConfig,
	namespace string,
	reverseProxyHTTP interfaces.DependencyServiceInterface,
	reverseProxyGRPC interfaces.DependencyServiceInterface,
	agentDebugService interfaces.DependencyServiceInterface,
	modelScalingService interfaces.DependencyServiceInterface,
	metrics metrics.AgentMetricsHandler,
) *Client {

	opts := []grpc.CallOption{
		grpc.MaxCallSendMsgSize(math.MaxInt32),
		grpc.MaxCallRecvMsgSize(math.MaxInt32),
	}
	modelState := NewModelState()

	stateManager := NewLocalStateManager(
		modelState, logger, v2Client, replicaConfig.GetMemoryBytes(), replicaConfig.GetOverCommitPercentage(), metrics)

	agentDebugService.SetState(stateManager)
	reverseProxyHTTP.SetState(stateManager)
	reverseProxyGRPC.SetState(stateManager)

	return &Client{
		logger:              logger.WithField("Name", "Client"),
		configChan:          make(chan config.AgentConfiguration),
		stateManager:        stateManager,
		replicaConfig:       replicaConfig,
		rpHTTP:              reverseProxyHTTP,
		rpGRPC:              reverseProxyGRPC,
		agentDebugService:   agentDebugService,
		modelScalingService: modelScalingService,
		metrics:             metrics,
		ClientServices: ClientServices{
			ModelRepository: modelRepository,
		},
		SchedulerGrpcClientOptions: SchedulerGrpcClientOptions{
			schedulerHost:         schedulerHost,
			schedulerPlaintxtPort: schedulerPlaintxtPort,
			schedulerTlsPort:      schedulerTlsPort,
			serverName:            serverName,
			replicaIdx:            replicaIdx,
			callOptions:           opts,
			certificateStore:      nil, // Needed to stop 1.48.0 lint failing
		},
		KubernetesOptions: KubernetesOptions{
			namespace: namespace,
		},
	}
}

func (c *Client) Start() error {
	logger := c.logger.WithField("func", "Start")

	if c.conn == nil {
		err := c.createConnection()
		if err != nil {
			logger.WithError(err).Errorf("Failed to create connection to scheduler")
			return err
		}
	}

	logFailure := func(err error, delay time.Duration) {
		c.logger.WithError(err).Errorf("Scheduler not ready")
	}
	backOffExp := backoff.NewExponentialBackOff()
	backOffExp.MaxElapsedTime = 0 // Never stop due to large time between calls
	err := backoff.RetryNotify(c.StartService, backOffExp, logFailure)
	if err != nil {
		c.logger.WithError(err).Fatal("Failed to start client")
		return err
	}

	return nil
}

func (c *Client) createConnection() error {
	conn, err := c.getConnection(c.schedulerHost, c.schedulerPlaintxtPort, c.schedulerTlsPort)
	if err != nil {
		return err
	}
	c.SchedulerGrpcClientOptions.conn = conn
	return nil
}

func (c *Client) WaitReady() error {
	logger := c.logger.WithField("func", "waitReady")

	// Wait for model repo to be ready
	logFailure := func(err error, delay time.Duration) {
		logger.WithError(err).Errorf("Rclone not ready")
	}
	logger.Infof("Waiting for Model Repository to be ready")
	//TODO make retry configurable
	err := backoff.RetryNotify(c.ModelRepository.Ready, backoff.NewExponentialBackOff(), logFailure)
	if err != nil {
		return err
	}

	// Wait for V2 Server to be ready
	logFailure = func(err error, delay time.Duration) {
		logger.WithError(err).Errorf("Server not ready")
	}
	logger.Infof("Waiting for inference server to be ready")
	err = backoff.RetryNotify(c.stateManager.v2Client.Ready, backoff.NewExponentialBackOff(), logFailure)
	if err != nil {
		return err
	}

	// Unload any existing models on server to ensure we start in a clean state
	err = c.UnloadAllModels()
	if err != nil {
		return err
	}

	// http reverse proxy
	if err := startSubService(c.rpHTTP, logger); err != nil {
		return err
	}

	// grpc reverse proxy
	if err := startSubService(c.rpGRPC, logger); err != nil {
		return err
	}

	// agent debug service
	if err := startSubService(c.agentDebugService, logger); err != nil {
		return err
	}

	// model scaling service
	if err := startSubService(c.modelScalingService, logger); err != nil {
		return err
	}

	return nil
}

func (c *Client) UnloadAllModels() error {
	logger := c.logger.WithField("func", "UnloadAllModels")
	models, err := c.stateManager.v2Client.GetModels()
	if err != nil {
		return err
	}
	for _, model := range models {
		if model.State == MLServerModelState_READY || model.State == MLServerModelState_LOADING {
			logger.Infof("Unloading existing model %s", model)
			v2Err := c.stateManager.v2Client.UnloadModel(model.Name)
			if v2Err != nil {
				if !v2Err.IsNotFound() {
					return v2Err.err
				} else {
					c.logger.Warnf("Model %s not found on server", model)
				}
			}
		}
		err := c.ModelRepository.RemoveModelVersion(model.Name)
		if err != nil {
			c.logger.WithError(err).Errorf("Model %s could not be removed from repository", model)
		}
	}
	return nil
}

func startSubService(service interfaces.DependencyServiceInterface, logger *log.Entry) error {
	logger.Infof("Starting and waiting for %s", service.Name())
	err := service.Start()
	if err != nil {
		return err
	}

	logFailure := func(err error, delay time.Duration) {
		logger.WithError(err).Errorf("%s service not ready", service.Name())
	}

	readyToError := func() error {
		if service.Ready() {
			return nil
		} else {
			return fmt.Errorf("Service %s not ready", service.Name())
		}
	}
	err = backoff.RetryNotify(readyToError, backoff.NewExponentialBackOff(), logFailure)
	return err
}

func (c *Client) getConnection(host string, plainTxtPort int, tlsPort int) (*grpc.ClientConn, error) {
	logger := c.logger.WithField("func", "getConnection")
	var err error
	protocol := seldontls.GetSecurityProtocolFromEnv(seldontls.EnvSecurityPrefixControlPlane)
	if protocol == seldontls.SecurityProtocolSSL {
		c.certificateStore, err = seldontls.NewCertificateStore(seldontls.Prefix(seldontls.EnvSecurityPrefixControlPlaneClient),
			seldontls.ValidationPrefix(seldontls.EnvSecurityPrefixControlPlaneServer))
		if err != nil {
			return nil, err
		}
	}
	retryOpts := []grpc_retry.CallOption{
		grpc_retry.WithBackoff(grpc_retry.BackoffExponential(util.GrpcRetryBackoffMillisecs * time.Millisecond)),
	}
	var transCreds credentials.TransportCredentials
	var port int
	if c.certificateStore == nil {
		logger.Info("Starting plaintxt client to agent server")
		transCreds = insecure.NewCredentials()
		port = plainTxtPort
	} else {
		logger.Info("Starting TLS client to agent server")
		transCreds = c.certificateStore.CreateClientTransportCredentials()
		port = tlsPort
	}
	opts := []grpc.DialOption{
		grpc.WithTransportCredentials(transCreds),
		grpc.WithStreamInterceptor(grpc_retry.StreamClientInterceptor(retryOpts...)),
		grpc.WithUnaryInterceptor(grpc_middleware.ChainUnaryClient(grpc_retry.UnaryClientInterceptor(retryOpts...), otelgrpc.UnaryClientInterceptor())),
	}
	logger.Infof("Connecting to scheduler at %s:%d", host, port)
	conn, err := grpc.Dial(fmt.Sprintf("%s:%d", host, port), opts...)
	if err != nil {
		return nil, err
	}
	logger.Infof("Connected to scheduler at %s:%d", host, port)
	return conn, nil
}

func (c *Client) StartService() error {
	logger := c.logger.WithField("func", "StartService")
	logger.Info("Call subscribe to scheduler")
	grpcClient := agent.NewAgentServiceClient(c.conn)

	stream, err := grpcClient.Subscribe(context.Background(), &agent.AgentSubscribeRequest{
		ServerName:           c.serverName,
		ReplicaIdx:           c.replicaIdx,
		ReplicaConfig:        c.replicaConfig,
		LoadedModels:         c.stateManager.modelVersions.getVersionsForAllModels(),
		Shared:               true,
		AvailableMemoryBytes: c.stateManager.GetAvailableMemoryBytesWithOverCommit(),
	}, grpc_retry.WithMax(1)) //TODO make configurable
	if err != nil {
		return err
	}
	logger.Info("Subscribed to scheduler")

	go c.metrics.AddServerReplicaMetrics(
		c.stateManager.totalMainMemoryBytes,
		float32(c.stateManager.totalMainMemoryBytes)+c.stateManager.GetOverCommitMemoryBytes())

	// start stream to server
	clientStream, err := grpcClient.ModelScalingTrigger(context.Background())
	if err != nil {
		return err
	}
	c.modelScalingClientStream = clientStream
	defer func() {
		_, _ = clientStream.CloseAndRecv()
	}()
	go c.consumeModelScalingEvents()

	for {
		operation, err := stream.Recv()
		if err == io.EOF {
			break
		}
		if err != nil {
			return err
		}
		c.logger.Infof("Received operation")
		switch operation.Operation {
		case agent.ModelOperationMessage_LOAD_MODEL:
			c.logger.Infof("calling load model")
			go func() {
				err := c.LoadModel(operation)
				if err != nil {
					c.logger.WithError(err).Errorf("Failed to handle load model %s:%d", operation.GetModelVersion().GetModel().GetMeta().GetName(), operation.GetModelVersion().GetVersion())
				}
			}()

		case agent.ModelOperationMessage_UNLOAD_MODEL:
			c.logger.Infof("calling unload model")
			go func() {
				err := c.UnloadModel(operation)
				if err != nil {
					c.logger.WithError(err).Errorf("Failed to handle unload model %s:%d", operation.GetModelVersion().GetModel().GetMeta().GetName(), operation.GetModelVersion().GetVersion())
				}
			}()
		}
	}
	return nil
}

func (c *Client) getArtifactConfig(request *agent.ModelOperationMessage) ([]byte, error) {
	if request.GetModelVersion().GetModel().GetModelSpec().StorageConfig == nil {
		return nil, nil
	}
	logger := c.logger.WithField("func", "getArtifactConfig")
	logger.Infof("Getting Rclone configuration")
	switch x := request.GetModelVersion().GetModel().GetModelSpec().StorageConfig.Config.(type) {
	case *pbs.StorageConfig_StorageRcloneConfig:
		return []byte(x.StorageRcloneConfig), nil
	case *pbs.StorageConfig_StorageSecretName:
		if c.secretsHandler == nil {
			secretClientSet, err := k8s.CreateClientset()
			if err != nil {
				return nil, err
			}
			if request.GetModelVersion().GetModel().GetMeta().GetKubernetesMeta() != nil {
				c.KubernetesOptions.secretsHandler = k8s.NewSecretsHandler(secretClientSet, request.GetModelVersion().GetModel().GetMeta().GetKubernetesMeta().GetNamespace())
			} else {
				return nil, fmt.Errorf("Can't load model %s:%dwith k8s secret %s when namespace not set", request.GetModelVersion().GetModel().GetMeta().GetName(), request.GetModelVersion().GetVersion(), x.StorageSecretName)
			}

		}
		config, err := c.secretsHandler.GetSecretConfig(x.StorageSecretName)
		if err != nil {
			return nil, err
		}
		return config, nil
	}
	return nil, nil
}

func (c *Client) LoadModel(request *agent.ModelOperationMessage) error {
	logger := c.logger.WithField("func", "LoadModel")
	if request == nil || request.ModelVersion == nil {
		return fmt.Errorf("Empty request received for load model")
	}
	modelName := request.GetModelVersion().GetModel().GetMeta().GetName()
	modelVersion := request.GetModelVersion().GetVersion()
	modelWithVersion := util.GetVersionedModelName(modelName, modelVersion)
	pinnedModelVersion := util.GetPinnedModelVersion()

	c.stateManager.cache.Lock(modelWithVersion)
	defer c.stateManager.cache.Unlock(modelWithVersion)

	logger.Infof("Load model %s:%d", modelName, modelVersion)

	// Get Rclone configuration
	config, err := c.getArtifactConfig(request)
	if err != nil {
		c.sendModelEventError(modelName, modelVersion, agent.ModelEventMessage_LOAD_FAILED, err)
		return err
	}
	// Copy model artifact
	chosenVersionPath, err := c.ModelRepository.DownloadModelVersion(
		modelWithVersion, pinnedModelVersion, request.GetModelVersion().GetModel().GetModelSpec().ArtifactVersion,
		request.GetModelVersion().GetModel().GetModelSpec().Uri, config,
		request.GetModelVersion().GetModel().GetModelSpec().GetExplainer(),
		request.GetModelVersion().GetModel().GetModelSpec().GetParameters())
	if err != nil {
		c.sendModelEventError(modelName, modelVersion, agent.ModelEventMessage_LOAD_FAILED, err)
		return err
	}
	logger.Infof("Chose path %s for model %s:%d", *chosenVersionPath, modelName, modelVersion)

	// TODO: do we need the actual protos being sent
	modifiedModelVersionRequest := getModifiedModelVersion(modelWithVersion, pinnedModelVersion, request.GetModelVersion())
	err = c.stateManager.LoadModelVersion(modifiedModelVersionRequest)
	if err != nil {
		c.sendModelEventError(modelName, modelVersion, agent.ModelEventMessage_LOAD_FAILED, err)
		return err
	}

	// add pointers in model scaling stats
	// we have done it via the scaling service as not to expose here all the model scaling stats that we have and then call Add on
	// each one of them
	if err := c.modelScalingService.(*modelscaling.StatsAnalyserService).AddModel(modelWithVersion); err != nil {
		logger.WithError(err).Warnf("Cannot add model %s to scaling service", modelWithVersion)
	}

	logger.Infof("Load model %s:%d success", modelName, modelVersion)
	return c.sendAgentEvent(modelName, modelVersion, agent.ModelEventMessage_LOADED)
}

func (c *Client) UnloadModel(request *agent.ModelOperationMessage) error {
	logger := c.logger.WithField("func", "UnloadModel")
	if request == nil || request.GetModelVersion() == nil {
		return fmt.Errorf("Empty request received for unload model")
	}
	modelName := request.GetModelVersion().GetModel().GetMeta().GetName()
	modelVersion := request.GetModelVersion().GetVersion()
	modelWithVersion := util.GetVersionedModelName(modelName, modelVersion)
	pinnedModelVersion := util.GetPinnedModelVersion()

	c.stateManager.cache.Lock(modelWithVersion)
	defer c.stateManager.cache.Unlock(modelWithVersion)

	logger.Infof("Unload model %s:%d", modelName, modelVersion)

	err := c.ModelRepository.RemoveModelVersion(modelWithVersion)
	if err != nil {
		c.sendModelEventError(modelName, modelVersion, agent.ModelEventMessage_UNLOAD_FAILED, err)
		return err
	}

	// we do not care about model versions here
	modifiedModelVersionRequest := getModifiedModelVersion(modelWithVersion, pinnedModelVersion, request.GetModelVersion())
	if err := c.stateManager.UnloadModelVersion(modifiedModelVersionRequest); err != nil {
		c.sendModelEventError(modelName, modelVersion, agent.ModelEventMessage_UNLOAD_FAILED, err)
		return err
	}

	// remove pointers in model scaling stats
	// we have done it via the scaling service as not to expose here all the model scaling stats that we have and then call Delete on
	// each one of them
	if err := c.modelScalingService.(*modelscaling.StatsAnalyserService).DeleteModel(modelWithVersion); err != nil {
		logger.WithError(err).Warnf("Cannot delete model %s from scaling service", modelWithVersion)
	}

	logger.Infof("Unload model %s:%d success", modelName, modelVersion)
	return c.sendAgentEvent(modelName, modelVersion, agent.ModelEventMessage_UNLOADED)
}

func (c *Client) sendModelEventError(modelName string, modelVersion uint32, event agent.ModelEventMessage_Event, err error) {
	grpcClient := agent.NewAgentServiceClient(c.conn)
	_, err = grpcClient.AgentEvent(context.Background(), &agent.ModelEventMessage{
		ServerName:           c.serverName,
		ReplicaIdx:           c.replicaIdx,
		ModelName:            modelName,
		ModelVersion:         modelVersion,
		Event:                event,
		Message:              err.Error(),
		AvailableMemoryBytes: c.stateManager.GetAvailableMemoryBytesWithOverCommit(),
	})
	if err != nil {
		c.logger.WithError(err).Errorf("Failed to send error back on load model")
	}
}

func (c *Client) sendAgentEvent(modelName string, modelVersion uint32, event agent.ModelEventMessage_Event) error {
	grpcClient := agent.NewAgentServiceClient(c.conn)
	_, err := grpcClient.AgentEvent(context.Background(), &agent.ModelEventMessage{
		ServerName:           c.serverName,
		ReplicaIdx:           c.replicaIdx,
		ModelName:            modelName,
		ModelVersion:         modelVersion,
		Event:                event,
		AvailableMemoryBytes: c.stateManager.GetAvailableMemoryBytesWithOverCommit(),
	})
	return err
}

func (c *Client) sendModelScalingTriggerEvent(
	modelName string, modelVersion uint32, scalingType modelscaling.ModelScalingEventType, amount uint32, data map[string]uint32) error {
	triggerType := agent.ModelScalingTriggerMessage_SCALE_UP
	if scalingType == modelscaling.ScaleDownEvent {
		triggerType = agent.ModelScalingTriggerMessage_SCALE_DOWN
	}
	err := c.modelScalingClientStream.Send(&agent.ModelScalingTriggerMessage{
		ServerName:   c.serverName,
		ReplicaIdx:   c.replicaIdx,
		ModelName:    modelName,
		ModelVersion: modelVersion,
		Trigger:      triggerType,
		Amount:       amount,
		Metrics:      data,
	})
	return err
}

func (c *Client) consumeModelScalingEvents() {
	ch := c.modelScalingService.(*modelscaling.StatsAnalyserService).GetEventChannel()
	for c.modelScalingService.Ready() {
		e := <-ch
		modelName, modelVersion, err := util.GetOrignalModelNameAndVersion(e.StatsData.ModelName)
		if err != nil {
			c.logger.WithError(err).Warnf("Trigger model scaling event model %s failed", e.StatsData.ModelName)
			continue
		} else {
			c.logger.Debugf("Trigger model scaling event %d for model %s:%d with value %d",
				e.EventType, modelName, modelVersion, e.StatsData.Value)
		}
		err = c.sendModelScalingTriggerEvent(
			modelName, modelVersion, e.EventType, e.StatsData.Value, nil,
		)
		if err != nil {
			c.logger.WithError(err).Warnf("Trigger model scaling event model %s failed", e.StatsData.ModelName)
			continue
		}
	}
}

func getModifiedModelVersion(modelId string, version uint32, originalModelVersion *agent.ModelVersion) *agent.ModelVersion {
	mv := proto.Clone(originalModelVersion)
	mv.(*agent.ModelVersion).Model.Meta.Name = modelId
	mv.(*agent.ModelVersion).Version = version
	return mv.(*agent.ModelVersion)
}