package com.tarantik.core.base.moshi

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.adapters.EnumJsonAdapter
import com.squareup.moshi.internal.Util

data class JsonAdapterFactory(
    val factory: JsonAdapter.Factory,
)

fun <T : Enum<T>> enumAdapter(clazz: Class<T>, defaultValue: T): JsonAdapterFactory =
    JsonAdapterFactory { targetType, annotations, _ ->
        if (annotations.isEmpty() && Util.typesMatch(clazz, targetType)) {
            EnumJsonAdapter.create(clazz).withUnknownFallback(defaultValue)
        } else {
            null
        }
    }
