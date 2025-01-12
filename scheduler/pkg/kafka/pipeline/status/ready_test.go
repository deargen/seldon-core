/*
Copyright (c) 2024 Seldon Technologies Ltd.

Use of this software is governed by
(1) the license included in the LICENSE file or
(2) if the license included in the LICENSE file is the Business Source License 1.1,
the Change License after the Change Date as each is defined in accordance with the LICENSE file.
*/

package status

import (
	"context"
	"errors"
	"testing"

	. "github.com/onsi/gomega"

	"github.com/seldonio/seldon-core/scheduler/v2/pkg/store/pipeline"
)

type fakePipelineStatusProvider struct {
	pipelines map[string]*pipeline.PipelineVersion
}

func (f fakePipelineStatusProvider) Get(name string) *pipeline.PipelineVersion {
	return f.pipelines[name]
}

type fakeModelReadyCaller struct {
	errs  map[string]error
	ready map[string]bool
}

func (f fakeModelReadyCaller) CheckModelReady(ctx context.Context, modelName string, requestId string) (bool, error) {
	if err, ok := f.errs[modelName]; ok {
		return false, err
	}
	return f.ready[modelName], nil
}

func TestCheckPipelineReady(t *testing.T) {
	g := NewGomegaWithT(t)

	type test struct {
		name                 string
		pipelineName         string
		pipelineStatusGetter PipelineStatusProvider
		modelReadyCaller     ModelReadyCaller
		expectedReady        bool
		expectedError        error
	}

	randomErr := errors.New("some error")
	tests := []test{
		{
			name:                 "No pipeline",
			pipelineName:         "test",
			pipelineStatusGetter: fakePipelineStatusProvider{pipelines: map[string]*pipeline.PipelineVersion{}},
			expectedReady:        false,
			expectedError:        PipelineNotFoundErr,
		},
		{
			name:         "Model not ready",
			pipelineName: "test",
			pipelineStatusGetter: fakePipelineStatusProvider{pipelines: map[string]*pipeline.PipelineVersion{
				"test": {Name: "test", Steps: map[string]*pipeline.PipelineStep{
					"step1": {},
				}},
			}},
			modelReadyCaller: fakeModelReadyCaller{ready: map[string]bool{"step1": false}},
			expectedReady:    false,
			expectedError:    nil,
		},
		{
			name:         "Model err",
			pipelineName: "test",
			pipelineStatusGetter: fakePipelineStatusProvider{pipelines: map[string]*pipeline.PipelineVersion{
				"test": {Name: "test", Steps: map[string]*pipeline.PipelineStep{
					"step1": {},
				}},
			}},
			modelReadyCaller: fakeModelReadyCaller{
				ready: map[string]bool{"step1": false},
				errs:  map[string]error{"step1": randomErr},
			},
			expectedReady: false,
			expectedError: randomErr,
		},
		{
			name:         "Model ready",
			pipelineName: "test",
			pipelineStatusGetter: fakePipelineStatusProvider{pipelines: map[string]*pipeline.PipelineVersion{
				"test": {Name: "test", Steps: map[string]*pipeline.PipelineStep{
					"step1": {},
				}},
			}},
			modelReadyCaller: fakeModelReadyCaller{ready: map[string]bool{"step1": true}},
			expectedReady:    true,
			expectedError:    nil,
		},
		{
			name:         "Only some models ready so pipeline not ready",
			pipelineName: "test",
			pipelineStatusGetter: fakePipelineStatusProvider{pipelines: map[string]*pipeline.PipelineVersion{
				"test": {Name: "test", Steps: map[string]*pipeline.PipelineStep{
					"step1": {},
					"step2": {},
				}},
			}},
			modelReadyCaller: fakeModelReadyCaller{
				ready: map[string]bool{"step1": true, "step2": false},
			},
			expectedReady: false,
			expectedError: nil,
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			rc := NewSimpleReadyChecker(test.pipelineStatusGetter, test.modelReadyCaller)
			ready, err := rc.CheckPipelineReady(context.TODO(), test.pipelineName, "1")
			g.Expect(ready).To(Equal(test.expectedReady))
			if test.expectedError == nil {
				g.Expect(err).To(BeNil())
			} else {
				g.Expect(err).To(Equal(test.expectedError))
			}
		})
	}
}
