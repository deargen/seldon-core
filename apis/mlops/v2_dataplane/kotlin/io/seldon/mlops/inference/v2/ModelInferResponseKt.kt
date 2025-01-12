/*
Copyright (c) 2024 Seldon Technologies Ltd.

Use of this software is governed BY
(1) the license included in the LICENSE file or
(2) if the license included in the LICENSE file is the Business Source License 1.1,
the Change License after the Change Date as each is defined in accordance with the LICENSE file.
*/

//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: v2_dataplane.proto

package io.seldon.mlops.inference.v2;

@kotlin.jvm.JvmSynthetic
public inline fun modelInferResponse(block: io.seldon.mlops.inference.v2.ModelInferResponseKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse =
  io.seldon.mlops.inference.v2.ModelInferResponseKt.Dsl._create(io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.newBuilder()).apply { block() }._build()
public object ModelInferResponseKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse = _builder.build()

    /**
     * <pre>
     * The name of the model used for inference.
     * </pre>
     *
     * <code>string model_name = 1;</code>
     */
    public var modelName: kotlin.String
      @JvmName("getModelName")
      get() = _builder.getModelName()
      @JvmName("setModelName")
      set(value) {
        _builder.setModelName(value)
      }
    /**
     * <pre>
     * The name of the model used for inference.
     * </pre>
     *
     * <code>string model_name = 1;</code>
     */
    public fun clearModelName() {
      _builder.clearModelName()
    }

    /**
     * <pre>
     * The version of the model used for inference.
     * </pre>
     *
     * <code>string model_version = 2;</code>
     */
    public var modelVersion: kotlin.String
      @JvmName("getModelVersion")
      get() = _builder.getModelVersion()
      @JvmName("setModelVersion")
      set(value) {
        _builder.setModelVersion(value)
      }
    /**
     * <pre>
     * The version of the model used for inference.
     * </pre>
     *
     * <code>string model_version = 2;</code>
     */
    public fun clearModelVersion() {
      _builder.clearModelVersion()
    }

    /**
     * <pre>
     * The id of the inference request if one was specified.
     * </pre>
     *
     * <code>string id = 3;</code>
     */
    public var id: kotlin.String
      @JvmName("getId")
      get() = _builder.getId()
      @JvmName("setId")
      set(value) {
        _builder.setId(value)
      }
    /**
     * <pre>
     * The id of the inference request if one was specified.
     * </pre>
     *
     * <code>string id = 3;</code>
     */
    public fun clearId() {
      _builder.clearId()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class ParametersProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * Optional inference response parameters.
     * </pre>
     *
     * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
     */
     public val parameters: com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
      @kotlin.jvm.JvmSynthetic
      @JvmName("getParametersMap")
      get() = com.google.protobuf.kotlin.DslMap(
        _builder.getParametersMap()
      )
    /**
     * <pre>
     * Optional inference response parameters.
     * </pre>
     *
     * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
     */
    @JvmName("putParameters")
    public fun com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
      .put(key: kotlin.String, value: io.seldon.mlops.inference.v2.V2Dataplane.InferParameter) {
         _builder.putParameters(key, value)
       }
    /**
     * <pre>
     * Optional inference response parameters.
     * </pre>
     *
     * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("setParameters")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
      .set(key: kotlin.String, value: io.seldon.mlops.inference.v2.V2Dataplane.InferParameter) {
         put(key, value)
       }
    /**
     * <pre>
     * Optional inference response parameters.
     * </pre>
     *
     * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("removeParameters")
    public fun com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
      .remove(key: kotlin.String) {
         _builder.removeParameters(key)
       }
    /**
     * <pre>
     * Optional inference response parameters.
     * </pre>
     *
     * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("putAllParameters")
    public fun com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
      .putAll(map: kotlin.collections.Map<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter>) {
         _builder.putAllParameters(map)
       }
    /**
     * <pre>
     * Optional inference response parameters.
     * </pre>
     *
     * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @JvmName("clearParameters")
    public fun com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
      .clear() {
         _builder.clearParameters()
       }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class OutputsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * The output tensors holding inference results.
     * </pre>
     *
     * <code>repeated .inference.ModelInferResponse.InferOutputTensor outputs = 5;</code>
     */
     public val outputs: com.google.protobuf.kotlin.DslList<io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor, OutputsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getOutputsList()
      )
    /**
     * <pre>
     * The output tensors holding inference results.
     * </pre>
     *
     * <code>repeated .inference.ModelInferResponse.InferOutputTensor outputs = 5;</code>
     * @param value The outputs to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addOutputs")
    public fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor, OutputsProxy>.add(value: io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor) {
      _builder.addOutputs(value)
    }/**
     * <pre>
     * The output tensors holding inference results.
     * </pre>
     *
     * <code>repeated .inference.ModelInferResponse.InferOutputTensor outputs = 5;</code>
     * @param value The outputs to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignOutputs")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor, OutputsProxy>.plusAssign(value: io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor) {
      add(value)
    }/**
     * <pre>
     * The output tensors holding inference results.
     * </pre>
     *
     * <code>repeated .inference.ModelInferResponse.InferOutputTensor outputs = 5;</code>
     * @param values The outputs to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllOutputs")
    public fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor, OutputsProxy>.addAll(values: kotlin.collections.Iterable<io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor>) {
      _builder.addAllOutputs(values)
    }/**
     * <pre>
     * The output tensors holding inference results.
     * </pre>
     *
     * <code>repeated .inference.ModelInferResponse.InferOutputTensor outputs = 5;</code>
     * @param values The outputs to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllOutputs")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor, OutputsProxy>.plusAssign(values: kotlin.collections.Iterable<io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor>) {
      addAll(values)
    }/**
     * <pre>
     * The output tensors holding inference results.
     * </pre>
     *
     * <code>repeated .inference.ModelInferResponse.InferOutputTensor outputs = 5;</code>
     * @param index The index to set the value at.
     * @param value The outputs to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setOutputs")
    public operator fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor, OutputsProxy>.set(index: kotlin.Int, value: io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor) {
      _builder.setOutputs(index, value)
    }/**
     * <pre>
     * The output tensors holding inference results.
     * </pre>
     *
     * <code>repeated .inference.ModelInferResponse.InferOutputTensor outputs = 5;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearOutputs")
    public fun com.google.protobuf.kotlin.DslList<io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor, OutputsProxy>.clear() {
      _builder.clearOutputs()
    }
    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class RawOutputContentsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * The data contained in an output tensor can be represented in
     * "raw" bytes form or in the repeated type that matches the
     * tensor's data type. To use the raw representation 'raw_output_contents'
     * must be initialized with data for each tensor in the same order as
     * 'outputs'. For each tensor, the size of this content must match
     * what is expected by the tensor's shape and data type. The raw
     * data must be the flattened, one-dimensional, row-major order of
     * the tensor elements without any stride or padding between the
     * elements. Note that the FP16 data type must be represented as raw
     * content as there is no specific data type for a 16-bit float
     * type.
     * If this field is specified then InferOutputTensor::contents must
     * not be specified for any output tensor.
     * </pre>
     *
     * <code>repeated bytes raw_output_contents = 6;</code>
     */
     public val rawOutputContents: com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, RawOutputContentsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getRawOutputContentsList()
      )
    /**
     * <pre>
     * The data contained in an output tensor can be represented in
     * "raw" bytes form or in the repeated type that matches the
     * tensor's data type. To use the raw representation 'raw_output_contents'
     * must be initialized with data for each tensor in the same order as
     * 'outputs'. For each tensor, the size of this content must match
     * what is expected by the tensor's shape and data type. The raw
     * data must be the flattened, one-dimensional, row-major order of
     * the tensor elements without any stride or padding between the
     * elements. Note that the FP16 data type must be represented as raw
     * content as there is no specific data type for a 16-bit float
     * type.
     * If this field is specified then InferOutputTensor::contents must
     * not be specified for any output tensor.
     * </pre>
     *
     * <code>repeated bytes raw_output_contents = 6;</code>
     * @param value The rawOutputContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addRawOutputContents")
    public fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, RawOutputContentsProxy>.add(value: com.google.protobuf.ByteString) {
      _builder.addRawOutputContents(value)
    }/**
     * <pre>
     * The data contained in an output tensor can be represented in
     * "raw" bytes form or in the repeated type that matches the
     * tensor's data type. To use the raw representation 'raw_output_contents'
     * must be initialized with data for each tensor in the same order as
     * 'outputs'. For each tensor, the size of this content must match
     * what is expected by the tensor's shape and data type. The raw
     * data must be the flattened, one-dimensional, row-major order of
     * the tensor elements without any stride or padding between the
     * elements. Note that the FP16 data type must be represented as raw
     * content as there is no specific data type for a 16-bit float
     * type.
     * If this field is specified then InferOutputTensor::contents must
     * not be specified for any output tensor.
     * </pre>
     *
     * <code>repeated bytes raw_output_contents = 6;</code>
     * @param value The rawOutputContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignRawOutputContents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, RawOutputContentsProxy>.plusAssign(value: com.google.protobuf.ByteString) {
      add(value)
    }/**
     * <pre>
     * The data contained in an output tensor can be represented in
     * "raw" bytes form or in the repeated type that matches the
     * tensor's data type. To use the raw representation 'raw_output_contents'
     * must be initialized with data for each tensor in the same order as
     * 'outputs'. For each tensor, the size of this content must match
     * what is expected by the tensor's shape and data type. The raw
     * data must be the flattened, one-dimensional, row-major order of
     * the tensor elements without any stride or padding between the
     * elements. Note that the FP16 data type must be represented as raw
     * content as there is no specific data type for a 16-bit float
     * type.
     * If this field is specified then InferOutputTensor::contents must
     * not be specified for any output tensor.
     * </pre>
     *
     * <code>repeated bytes raw_output_contents = 6;</code>
     * @param values The rawOutputContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllRawOutputContents")
    public fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, RawOutputContentsProxy>.addAll(values: kotlin.collections.Iterable<com.google.protobuf.ByteString>) {
      _builder.addAllRawOutputContents(values)
    }/**
     * <pre>
     * The data contained in an output tensor can be represented in
     * "raw" bytes form or in the repeated type that matches the
     * tensor's data type. To use the raw representation 'raw_output_contents'
     * must be initialized with data for each tensor in the same order as
     * 'outputs'. For each tensor, the size of this content must match
     * what is expected by the tensor's shape and data type. The raw
     * data must be the flattened, one-dimensional, row-major order of
     * the tensor elements without any stride or padding between the
     * elements. Note that the FP16 data type must be represented as raw
     * content as there is no specific data type for a 16-bit float
     * type.
     * If this field is specified then InferOutputTensor::contents must
     * not be specified for any output tensor.
     * </pre>
     *
     * <code>repeated bytes raw_output_contents = 6;</code>
     * @param values The rawOutputContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllRawOutputContents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, RawOutputContentsProxy>.plusAssign(values: kotlin.collections.Iterable<com.google.protobuf.ByteString>) {
      addAll(values)
    }/**
     * <pre>
     * The data contained in an output tensor can be represented in
     * "raw" bytes form or in the repeated type that matches the
     * tensor's data type. To use the raw representation 'raw_output_contents'
     * must be initialized with data for each tensor in the same order as
     * 'outputs'. For each tensor, the size of this content must match
     * what is expected by the tensor's shape and data type. The raw
     * data must be the flattened, one-dimensional, row-major order of
     * the tensor elements without any stride or padding between the
     * elements. Note that the FP16 data type must be represented as raw
     * content as there is no specific data type for a 16-bit float
     * type.
     * If this field is specified then InferOutputTensor::contents must
     * not be specified for any output tensor.
     * </pre>
     *
     * <code>repeated bytes raw_output_contents = 6;</code>
     * @param index The index to set the value at.
     * @param value The rawOutputContents to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setRawOutputContents")
    public operator fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, RawOutputContentsProxy>.set(index: kotlin.Int, value: com.google.protobuf.ByteString) {
      _builder.setRawOutputContents(index, value)
    }/**
     * <pre>
     * The data contained in an output tensor can be represented in
     * "raw" bytes form or in the repeated type that matches the
     * tensor's data type. To use the raw representation 'raw_output_contents'
     * must be initialized with data for each tensor in the same order as
     * 'outputs'. For each tensor, the size of this content must match
     * what is expected by the tensor's shape and data type. The raw
     * data must be the flattened, one-dimensional, row-major order of
     * the tensor elements without any stride or padding between the
     * elements. Note that the FP16 data type must be represented as raw
     * content as there is no specific data type for a 16-bit float
     * type.
     * If this field is specified then InferOutputTensor::contents must
     * not be specified for any output tensor.
     * </pre>
     *
     * <code>repeated bytes raw_output_contents = 6;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearRawOutputContents")
    public fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, RawOutputContentsProxy>.clear() {
      _builder.clearRawOutputContents()
    }}
  @kotlin.jvm.JvmSynthetic
  public inline fun inferOutputTensor(block: io.seldon.mlops.inference.v2.ModelInferResponseKt.InferOutputTensorKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor =
    io.seldon.mlops.inference.v2.ModelInferResponseKt.InferOutputTensorKt.Dsl._create(io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor.newBuilder()).apply { block() }._build()
  public object InferOutputTensorKt {
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    @com.google.protobuf.kotlin.ProtoDslMarker
    public class Dsl private constructor(
      private val _builder: io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor.Builder
    ) {
      public companion object {
        @kotlin.jvm.JvmSynthetic
        @kotlin.PublishedApi
        internal fun _create(builder: io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor.Builder): Dsl = Dsl(builder)
      }

      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _build(): io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor = _builder.build()

      /**
       * <pre>
       * The tensor name.
       * </pre>
       *
       * <code>string name = 1;</code>
       */
      public var name: kotlin.String
        @JvmName("getName")
        get() = _builder.getName()
        @JvmName("setName")
        set(value) {
          _builder.setName(value)
        }
      /**
       * <pre>
       * The tensor name.
       * </pre>
       *
       * <code>string name = 1;</code>
       */
      public fun clearName() {
        _builder.clearName()
      }

      /**
       * <pre>
       * The tensor data type.
       * </pre>
       *
       * <code>string datatype = 2;</code>
       */
      public var datatype: kotlin.String
        @JvmName("getDatatype")
        get() = _builder.getDatatype()
        @JvmName("setDatatype")
        set(value) {
          _builder.setDatatype(value)
        }
      /**
       * <pre>
       * The tensor data type.
       * </pre>
       *
       * <code>string datatype = 2;</code>
       */
      public fun clearDatatype() {
        _builder.clearDatatype()
      }

      /**
       * An uninstantiable, behaviorless type to represent the field in
       * generics.
       */
      @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
      public class ShapeProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
      /**
       * <pre>
       * The tensor shape.
       * </pre>
       *
       * <code>repeated int64 shape = 3;</code>
       */
       public val shape: com.google.protobuf.kotlin.DslList<kotlin.Long, ShapeProxy>
        @kotlin.jvm.JvmSynthetic
        get() = com.google.protobuf.kotlin.DslList(
          _builder.getShapeList()
        )
      /**
       * <pre>
       * The tensor shape.
       * </pre>
       *
       * <code>repeated int64 shape = 3;</code>
       * @param value The shape to add.
       */
      @kotlin.jvm.JvmSynthetic
      @kotlin.jvm.JvmName("addShape")
      public fun com.google.protobuf.kotlin.DslList<kotlin.Long, ShapeProxy>.add(value: kotlin.Long) {
        _builder.addShape(value)
      }/**
       * <pre>
       * The tensor shape.
       * </pre>
       *
       * <code>repeated int64 shape = 3;</code>
       * @param value The shape to add.
       */
      @kotlin.jvm.JvmSynthetic
      @kotlin.jvm.JvmName("plusAssignShape")
      @Suppress("NOTHING_TO_INLINE")
      public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Long, ShapeProxy>.plusAssign(value: kotlin.Long) {
        add(value)
      }/**
       * <pre>
       * The tensor shape.
       * </pre>
       *
       * <code>repeated int64 shape = 3;</code>
       * @param values The shape to add.
       */
      @kotlin.jvm.JvmSynthetic
      @kotlin.jvm.JvmName("addAllShape")
      public fun com.google.protobuf.kotlin.DslList<kotlin.Long, ShapeProxy>.addAll(values: kotlin.collections.Iterable<kotlin.Long>) {
        _builder.addAllShape(values)
      }/**
       * <pre>
       * The tensor shape.
       * </pre>
       *
       * <code>repeated int64 shape = 3;</code>
       * @param values The shape to add.
       */
      @kotlin.jvm.JvmSynthetic
      @kotlin.jvm.JvmName("plusAssignAllShape")
      @Suppress("NOTHING_TO_INLINE")
      public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Long, ShapeProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.Long>) {
        addAll(values)
      }/**
       * <pre>
       * The tensor shape.
       * </pre>
       *
       * <code>repeated int64 shape = 3;</code>
       * @param index The index to set the value at.
       * @param value The shape to set.
       */
      @kotlin.jvm.JvmSynthetic
      @kotlin.jvm.JvmName("setShape")
      public operator fun com.google.protobuf.kotlin.DslList<kotlin.Long, ShapeProxy>.set(index: kotlin.Int, value: kotlin.Long) {
        _builder.setShape(index, value)
      }/**
       * <pre>
       * The tensor shape.
       * </pre>
       *
       * <code>repeated int64 shape = 3;</code>
       */
      @kotlin.jvm.JvmSynthetic
      @kotlin.jvm.JvmName("clearShape")
      public fun com.google.protobuf.kotlin.DslList<kotlin.Long, ShapeProxy>.clear() {
        _builder.clearShape()
      }
      /**
       * An uninstantiable, behaviorless type to represent the field in
       * generics.
       */
      @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
      public class ParametersProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
      /**
       * <pre>
       * Optional output tensor parameters.
       * </pre>
       *
       * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
       */
       public val parameters: com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
        @kotlin.jvm.JvmSynthetic
        @JvmName("getParametersMap")
        get() = com.google.protobuf.kotlin.DslMap(
          _builder.getParametersMap()
        )
      /**
       * <pre>
       * Optional output tensor parameters.
       * </pre>
       *
       * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
       */
      @JvmName("putParameters")
      public fun com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
        .put(key: kotlin.String, value: io.seldon.mlops.inference.v2.V2Dataplane.InferParameter) {
           _builder.putParameters(key, value)
         }
      /**
       * <pre>
       * Optional output tensor parameters.
       * </pre>
       *
       * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
       */
      @kotlin.jvm.JvmSynthetic
      @JvmName("setParameters")
      @Suppress("NOTHING_TO_INLINE")
      public inline operator fun com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
        .set(key: kotlin.String, value: io.seldon.mlops.inference.v2.V2Dataplane.InferParameter) {
           put(key, value)
         }
      /**
       * <pre>
       * Optional output tensor parameters.
       * </pre>
       *
       * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
       */
      @kotlin.jvm.JvmSynthetic
      @JvmName("removeParameters")
      public fun com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
        .remove(key: kotlin.String) {
           _builder.removeParameters(key)
         }
      /**
       * <pre>
       * Optional output tensor parameters.
       * </pre>
       *
       * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
       */
      @kotlin.jvm.JvmSynthetic
      @JvmName("putAllParameters")
      public fun com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
        .putAll(map: kotlin.collections.Map<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter>) {
           _builder.putAllParameters(map)
         }
      /**
       * <pre>
       * Optional output tensor parameters.
       * </pre>
       *
       * <code>map&lt;string, .inference.InferParameter&gt; parameters = 4;</code>
       */
      @kotlin.jvm.JvmSynthetic
      @JvmName("clearParameters")
      public fun com.google.protobuf.kotlin.DslMap<kotlin.String, io.seldon.mlops.inference.v2.V2Dataplane.InferParameter, ParametersProxy>
        .clear() {
           _builder.clearParameters()
         }

      /**
       * <pre>
       * The tensor contents using a data-type format. This field must
       * not be specified if "raw" tensor contents are being used for
       * the inference response.
       * </pre>
       *
       * <code>.inference.InferTensorContents contents = 5;</code>
       */
      public var contents: io.seldon.mlops.inference.v2.V2Dataplane.InferTensorContents
        @JvmName("getContents")
        get() = _builder.getContents()
        @JvmName("setContents")
        set(value) {
          _builder.setContents(value)
        }
      /**
       * <pre>
       * The tensor contents using a data-type format. This field must
       * not be specified if "raw" tensor contents are being used for
       * the inference response.
       * </pre>
       *
       * <code>.inference.InferTensorContents contents = 5;</code>
       */
      public fun clearContents() {
        _builder.clearContents()
      }
      /**
       * <pre>
       * The tensor contents using a data-type format. This field must
       * not be specified if "raw" tensor contents are being used for
       * the inference response.
       * </pre>
       *
       * <code>.inference.InferTensorContents contents = 5;</code>
       * @return Whether the contents field is set.
       */
      public fun hasContents(): kotlin.Boolean {
        return _builder.hasContents()
      }
    }
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.copy(block: io.seldon.mlops.inference.v2.ModelInferResponseKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse =
  io.seldon.mlops.inference.v2.ModelInferResponseKt.Dsl._create(this.toBuilder()).apply { block() }._build()
@kotlin.jvm.JvmSynthetic
public inline fun io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor.copy(block: io.seldon.mlops.inference.v2.ModelInferResponseKt.InferOutputTensorKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.inference.v2.V2Dataplane.ModelInferResponse.InferOutputTensor =
  io.seldon.mlops.inference.v2.ModelInferResponseKt.InferOutputTensorKt.Dsl._create(this.toBuilder()).apply { block() }._build()
