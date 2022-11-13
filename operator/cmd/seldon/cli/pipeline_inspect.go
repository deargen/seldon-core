package cli

import (
	"fmt"

	"k8s.io/utils/env"

	"github.com/seldonio/seldon-core/operatorv2/pkg/cli"
	"github.com/spf13/cobra"
)

const (
	flagOffset       = "offset"
	flagRequestId    = "request-id"
	flagOutputFormat = "format"
	flagVerbose      = "verbose"
	flagNamespace    = "namespace"
	defaultNamespace = "default"
)

func createPipelineInspect() *cobra.Command {
	cmd := &cobra.Command{
		Use:   "inspect <expression>",
		Short: "inspect data in a pipeline",
		Long:  `inspect data in a pipeline. Specify as pipelineName or pipelineName.(inputs|outputs) or pipeineName.stepName or pipelineName.stepName.(inputs|outputs) or pipelineName.stepName.(inputs|outputs).tensorName`,
		Args:  cobra.ExactArgs(1),
		RunE: func(cmd *cobra.Command, args []string) error {
			flags := cmd.Flags()

			schedulerHostIsSet := flags.Changed(flagSchedulerHost)
			schedulerHost, err := flags.GetString(flagSchedulerHost)
			if err != nil {
				return err
			}
			kafkaBrokerIsSet := flags.Changed(flagKafkaBroker)
			kafkaBroker, err := flags.GetString(flagKafkaBroker)
			if err != nil {
				return err
			}
			offset, err := flags.GetInt64(flagOffset)
			if err != nil {
				return err
			}
			requestId, err := flags.GetString(flagRequestId)
			if err != nil {
				return err
			}
			format, err := flags.GetString(flagOutputFormat)
			if err != nil {
				return err
			}
			verbose, err := flags.GetBool(flagVerbose)
			if err != nil {
				return err
			}
			namespace, err := flags.GetString(flagNamespace)
			if err != nil {
				return err
			}
			data := []byte(args[0])
			kc, err := cli.NewKafkaClient(kafkaBroker, kafkaBrokerIsSet, schedulerHost, schedulerHostIsSet)
			if err != nil {
				return err
			}
			err = kc.InspectStep(string(data), offset, requestId, format, verbose, namespace)
			return err
		},
	}

	flags := cmd.Flags()
	flags.String(flagKafkaBroker, env.GetString(envKafka, defaultKafkaHost), "kafka broker")
	flags.Int64(flagOffset, 1, "message offset to start reading from, i.e. default 1 is the last message only")
	flags.String(flagRequestId, "", "request id to show, if not specified will be all messages in offset range")
	flags.String(flagSchedulerHost, env.GetString(envScheduler, defaultSchedulerHost), helpSchedulerHost)
	flags.String(flagOutputFormat, cli.InspectFormatRaw, fmt.Sprintf("inspect output format: raw or json. Default %s", cli.InspectFormatRaw))
	flags.String(flagNamespace, defaultNamespace, fmt.Sprintf("namespace. Default %s", defaultNamespace))
	flags.Bool(flagVerbose, false, "display more details, such as headers")
	return cmd
}