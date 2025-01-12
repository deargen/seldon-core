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
public inline fun inferTensorContents(block: io.seldon.mlops.inference.v2.InferTensorContentsKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.inference.v2.V2Dataplane.InferTensorContents =
  io.seldon.mlops.inference.v2.InferTensorContentsKt.Dsl._create(io.seldon.mlops.inference.v2.V2Dataplane.InferTensorContents.newBuilder()).apply { block() }._build()
public object InferTensorContentsKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: io.seldon.mlops.inference.v2.V2Dataplane.InferTensorContents.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: io.seldon.mlops.inference.v2.V2Dataplane.InferTensorContents.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): io.seldon.mlops.inference.v2.V2Dataplane.InferTensorContents = _builder.build()

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class BoolContentsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * Representation for BOOL data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bool bool_contents = 1;</code>
     */
     public val boolContents: com.google.protobuf.kotlin.DslList<kotlin.Boolean, BoolContentsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getBoolContentsList()
      )
    /**
     * <pre>
     * Representation for BOOL data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bool bool_contents = 1;</code>
     * @param value The boolContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addBoolContents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Boolean, BoolContentsProxy>.add(value: kotlin.Boolean) {
      _builder.addBoolContents(value)
    }/**
     * <pre>
     * Representation for BOOL data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bool bool_contents = 1;</code>
     * @param value The boolContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignBoolContents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Boolean, BoolContentsProxy>.plusAssign(value: kotlin.Boolean) {
      add(value)
    }/**
     * <pre>
     * Representation for BOOL data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bool bool_contents = 1;</code>
     * @param values The boolContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllBoolContents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Boolean, BoolContentsProxy>.addAll(values: kotlin.collections.Iterable<kotlin.Boolean>) {
      _builder.addAllBoolContents(values)
    }/**
     * <pre>
     * Representation for BOOL data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bool bool_contents = 1;</code>
     * @param values The boolContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllBoolContents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Boolean, BoolContentsProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.Boolean>) {
      addAll(values)
    }/**
     * <pre>
     * Representation for BOOL data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bool bool_contents = 1;</code>
     * @param index The index to set the value at.
     * @param value The boolContents to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setBoolContents")
    public operator fun com.google.protobuf.kotlin.DslList<kotlin.Boolean, BoolContentsProxy>.set(index: kotlin.Int, value: kotlin.Boolean) {
      _builder.setBoolContents(index, value)
    }/**
     * <pre>
     * Representation for BOOL data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bool bool_contents = 1;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearBoolContents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Boolean, BoolContentsProxy>.clear() {
      _builder.clearBoolContents()
    }
    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class IntContentsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * Representation for INT8, INT16, and INT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated int32 int_contents = 2;</code>
     */
     public val intContents: com.google.protobuf.kotlin.DslList<kotlin.Int, IntContentsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getIntContentsList()
      )
    /**
     * <pre>
     * Representation for INT8, INT16, and INT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated int32 int_contents = 2;</code>
     * @param value The intContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addIntContents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Int, IntContentsProxy>.add(value: kotlin.Int) {
      _builder.addIntContents(value)
    }/**
     * <pre>
     * Representation for INT8, INT16, and INT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated int32 int_contents = 2;</code>
     * @param value The intContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignIntContents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Int, IntContentsProxy>.plusAssign(value: kotlin.Int) {
      add(value)
    }/**
     * <pre>
     * Representation for INT8, INT16, and INT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated int32 int_contents = 2;</code>
     * @param values The intContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllIntContents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Int, IntContentsProxy>.addAll(values: kotlin.collections.Iterable<kotlin.Int>) {
      _builder.addAllIntContents(values)
    }/**
     * <pre>
     * Representation for INT8, INT16, and INT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated int32 int_contents = 2;</code>
     * @param values The intContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllIntContents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Int, IntContentsProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.Int>) {
      addAll(values)
    }/**
     * <pre>
     * Representation for INT8, INT16, and INT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated int32 int_contents = 2;</code>
     * @param index The index to set the value at.
     * @param value The intContents to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setIntContents")
    public operator fun com.google.protobuf.kotlin.DslList<kotlin.Int, IntContentsProxy>.set(index: kotlin.Int, value: kotlin.Int) {
      _builder.setIntContents(index, value)
    }/**
     * <pre>
     * Representation for INT8, INT16, and INT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated int32 int_contents = 2;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearIntContents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Int, IntContentsProxy>.clear() {
      _builder.clearIntContents()
    }
    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class Int64ContentsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * Representation for INT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated int64 int64_contents = 3;</code>
     */
     public val int64Contents: com.google.protobuf.kotlin.DslList<kotlin.Long, Int64ContentsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getInt64ContentsList()
      )
    /**
     * <pre>
     * Representation for INT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated int64 int64_contents = 3;</code>
     * @param value The int64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addInt64Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Long, Int64ContentsProxy>.add(value: kotlin.Long) {
      _builder.addInt64Contents(value)
    }/**
     * <pre>
     * Representation for INT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated int64 int64_contents = 3;</code>
     * @param value The int64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignInt64Contents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Long, Int64ContentsProxy>.plusAssign(value: kotlin.Long) {
      add(value)
    }/**
     * <pre>
     * Representation for INT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated int64 int64_contents = 3;</code>
     * @param values The int64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllInt64Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Long, Int64ContentsProxy>.addAll(values: kotlin.collections.Iterable<kotlin.Long>) {
      _builder.addAllInt64Contents(values)
    }/**
     * <pre>
     * Representation for INT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated int64 int64_contents = 3;</code>
     * @param values The int64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllInt64Contents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Long, Int64ContentsProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.Long>) {
      addAll(values)
    }/**
     * <pre>
     * Representation for INT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated int64 int64_contents = 3;</code>
     * @param index The index to set the value at.
     * @param value The int64Contents to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setInt64Contents")
    public operator fun com.google.protobuf.kotlin.DslList<kotlin.Long, Int64ContentsProxy>.set(index: kotlin.Int, value: kotlin.Long) {
      _builder.setInt64Contents(index, value)
    }/**
     * <pre>
     * Representation for INT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated int64 int64_contents = 3;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearInt64Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Long, Int64ContentsProxy>.clear() {
      _builder.clearInt64Contents()
    }
    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class UintContentsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * Representation for UINT8, UINT16, and UINT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated uint32 uint_contents = 4;</code>
     */
     public val uintContents: com.google.protobuf.kotlin.DslList<kotlin.Int, UintContentsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getUintContentsList()
      )
    /**
     * <pre>
     * Representation for UINT8, UINT16, and UINT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated uint32 uint_contents = 4;</code>
     * @param value The uintContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addUintContents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Int, UintContentsProxy>.add(value: kotlin.Int) {
      _builder.addUintContents(value)
    }/**
     * <pre>
     * Representation for UINT8, UINT16, and UINT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated uint32 uint_contents = 4;</code>
     * @param value The uintContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignUintContents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Int, UintContentsProxy>.plusAssign(value: kotlin.Int) {
      add(value)
    }/**
     * <pre>
     * Representation for UINT8, UINT16, and UINT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated uint32 uint_contents = 4;</code>
     * @param values The uintContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllUintContents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Int, UintContentsProxy>.addAll(values: kotlin.collections.Iterable<kotlin.Int>) {
      _builder.addAllUintContents(values)
    }/**
     * <pre>
     * Representation for UINT8, UINT16, and UINT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated uint32 uint_contents = 4;</code>
     * @param values The uintContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllUintContents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Int, UintContentsProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.Int>) {
      addAll(values)
    }/**
     * <pre>
     * Representation for UINT8, UINT16, and UINT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated uint32 uint_contents = 4;</code>
     * @param index The index to set the value at.
     * @param value The uintContents to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setUintContents")
    public operator fun com.google.protobuf.kotlin.DslList<kotlin.Int, UintContentsProxy>.set(index: kotlin.Int, value: kotlin.Int) {
      _builder.setUintContents(index, value)
    }/**
     * <pre>
     * Representation for UINT8, UINT16, and UINT32 data types. The size
     * must match what is expected by the tensor's shape. The contents
     * must be the flattened, one-dimensional, row-major order of the
     * tensor elements.
     * </pre>
     *
     * <code>repeated uint32 uint_contents = 4;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearUintContents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Int, UintContentsProxy>.clear() {
      _builder.clearUintContents()
    }
    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class Uint64ContentsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * Representation for UINT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated uint64 uint64_contents = 5;</code>
     */
     public val uint64Contents: com.google.protobuf.kotlin.DslList<kotlin.Long, Uint64ContentsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getUint64ContentsList()
      )
    /**
     * <pre>
     * Representation for UINT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated uint64 uint64_contents = 5;</code>
     * @param value The uint64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addUint64Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Long, Uint64ContentsProxy>.add(value: kotlin.Long) {
      _builder.addUint64Contents(value)
    }/**
     * <pre>
     * Representation for UINT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated uint64 uint64_contents = 5;</code>
     * @param value The uint64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignUint64Contents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Long, Uint64ContentsProxy>.plusAssign(value: kotlin.Long) {
      add(value)
    }/**
     * <pre>
     * Representation for UINT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated uint64 uint64_contents = 5;</code>
     * @param values The uint64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllUint64Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Long, Uint64ContentsProxy>.addAll(values: kotlin.collections.Iterable<kotlin.Long>) {
      _builder.addAllUint64Contents(values)
    }/**
     * <pre>
     * Representation for UINT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated uint64 uint64_contents = 5;</code>
     * @param values The uint64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllUint64Contents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Long, Uint64ContentsProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.Long>) {
      addAll(values)
    }/**
     * <pre>
     * Representation for UINT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated uint64 uint64_contents = 5;</code>
     * @param index The index to set the value at.
     * @param value The uint64Contents to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setUint64Contents")
    public operator fun com.google.protobuf.kotlin.DslList<kotlin.Long, Uint64ContentsProxy>.set(index: kotlin.Int, value: kotlin.Long) {
      _builder.setUint64Contents(index, value)
    }/**
     * <pre>
     * Representation for UINT64 data types. The size must match what
     * is expected by the tensor's shape. The contents must be the
     * flattened, one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated uint64 uint64_contents = 5;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearUint64Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Long, Uint64ContentsProxy>.clear() {
      _builder.clearUint64Contents()
    }
    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class Fp32ContentsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * Representation for FP32 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated float fp32_contents = 6;</code>
     */
     public val fp32Contents: com.google.protobuf.kotlin.DslList<kotlin.Float, Fp32ContentsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getFp32ContentsList()
      )
    /**
     * <pre>
     * Representation for FP32 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated float fp32_contents = 6;</code>
     * @param value The fp32Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addFp32Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Float, Fp32ContentsProxy>.add(value: kotlin.Float) {
      _builder.addFp32Contents(value)
    }/**
     * <pre>
     * Representation for FP32 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated float fp32_contents = 6;</code>
     * @param value The fp32Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignFp32Contents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Float, Fp32ContentsProxy>.plusAssign(value: kotlin.Float) {
      add(value)
    }/**
     * <pre>
     * Representation for FP32 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated float fp32_contents = 6;</code>
     * @param values The fp32Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllFp32Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Float, Fp32ContentsProxy>.addAll(values: kotlin.collections.Iterable<kotlin.Float>) {
      _builder.addAllFp32Contents(values)
    }/**
     * <pre>
     * Representation for FP32 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated float fp32_contents = 6;</code>
     * @param values The fp32Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllFp32Contents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Float, Fp32ContentsProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.Float>) {
      addAll(values)
    }/**
     * <pre>
     * Representation for FP32 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated float fp32_contents = 6;</code>
     * @param index The index to set the value at.
     * @param value The fp32Contents to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setFp32Contents")
    public operator fun com.google.protobuf.kotlin.DslList<kotlin.Float, Fp32ContentsProxy>.set(index: kotlin.Int, value: kotlin.Float) {
      _builder.setFp32Contents(index, value)
    }/**
     * <pre>
     * Representation for FP32 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated float fp32_contents = 6;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearFp32Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Float, Fp32ContentsProxy>.clear() {
      _builder.clearFp32Contents()
    }
    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class Fp64ContentsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * Representation for FP64 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated double fp64_contents = 7;</code>
     */
     public val fp64Contents: com.google.protobuf.kotlin.DslList<kotlin.Double, Fp64ContentsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getFp64ContentsList()
      )
    /**
     * <pre>
     * Representation for FP64 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated double fp64_contents = 7;</code>
     * @param value The fp64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addFp64Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Double, Fp64ContentsProxy>.add(value: kotlin.Double) {
      _builder.addFp64Contents(value)
    }/**
     * <pre>
     * Representation for FP64 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated double fp64_contents = 7;</code>
     * @param value The fp64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignFp64Contents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Double, Fp64ContentsProxy>.plusAssign(value: kotlin.Double) {
      add(value)
    }/**
     * <pre>
     * Representation for FP64 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated double fp64_contents = 7;</code>
     * @param values The fp64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllFp64Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Double, Fp64ContentsProxy>.addAll(values: kotlin.collections.Iterable<kotlin.Double>) {
      _builder.addAllFp64Contents(values)
    }/**
     * <pre>
     * Representation for FP64 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated double fp64_contents = 7;</code>
     * @param values The fp64Contents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllFp64Contents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<kotlin.Double, Fp64ContentsProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.Double>) {
      addAll(values)
    }/**
     * <pre>
     * Representation for FP64 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated double fp64_contents = 7;</code>
     * @param index The index to set the value at.
     * @param value The fp64Contents to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setFp64Contents")
    public operator fun com.google.protobuf.kotlin.DslList<kotlin.Double, Fp64ContentsProxy>.set(index: kotlin.Int, value: kotlin.Double) {
      _builder.setFp64Contents(index, value)
    }/**
     * <pre>
     * Representation for FP64 data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated double fp64_contents = 7;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearFp64Contents")
    public fun com.google.protobuf.kotlin.DslList<kotlin.Double, Fp64ContentsProxy>.clear() {
      _builder.clearFp64Contents()
    }
    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    public class BytesContentsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * Representation for BYTES data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bytes bytes_contents = 8;</code>
     */
     public val bytesContents: com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, BytesContentsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getBytesContentsList()
      )
    /**
     * <pre>
     * Representation for BYTES data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bytes bytes_contents = 8;</code>
     * @param value The bytesContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addBytesContents")
    public fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, BytesContentsProxy>.add(value: com.google.protobuf.ByteString) {
      _builder.addBytesContents(value)
    }/**
     * <pre>
     * Representation for BYTES data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bytes bytes_contents = 8;</code>
     * @param value The bytesContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignBytesContents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, BytesContentsProxy>.plusAssign(value: com.google.protobuf.ByteString) {
      add(value)
    }/**
     * <pre>
     * Representation for BYTES data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bytes bytes_contents = 8;</code>
     * @param values The bytesContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllBytesContents")
    public fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, BytesContentsProxy>.addAll(values: kotlin.collections.Iterable<com.google.protobuf.ByteString>) {
      _builder.addAllBytesContents(values)
    }/**
     * <pre>
     * Representation for BYTES data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bytes bytes_contents = 8;</code>
     * @param values The bytesContents to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllBytesContents")
    @Suppress("NOTHING_TO_INLINE")
    public inline operator fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, BytesContentsProxy>.plusAssign(values: kotlin.collections.Iterable<com.google.protobuf.ByteString>) {
      addAll(values)
    }/**
     * <pre>
     * Representation for BYTES data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bytes bytes_contents = 8;</code>
     * @param index The index to set the value at.
     * @param value The bytesContents to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setBytesContents")
    public operator fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, BytesContentsProxy>.set(index: kotlin.Int, value: com.google.protobuf.ByteString) {
      _builder.setBytesContents(index, value)
    }/**
     * <pre>
     * Representation for BYTES data type. The size must match what is
     * expected by the tensor's shape. The contents must be the flattened,
     * one-dimensional, row-major order of the tensor elements.
     * </pre>
     *
     * <code>repeated bytes bytes_contents = 8;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearBytesContents")
    public fun com.google.protobuf.kotlin.DslList<com.google.protobuf.ByteString, BytesContentsProxy>.clear() {
      _builder.clearBytesContents()
    }}
}
@kotlin.jvm.JvmSynthetic
public inline fun io.seldon.mlops.inference.v2.V2Dataplane.InferTensorContents.copy(block: io.seldon.mlops.inference.v2.InferTensorContentsKt.Dsl.() -> kotlin.Unit): io.seldon.mlops.inference.v2.V2Dataplane.InferTensorContents =
  io.seldon.mlops.inference.v2.InferTensorContentsKt.Dsl._create(this.toBuilder()).apply { block() }._build()
