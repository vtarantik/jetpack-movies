package com.tarantik.core.network.moshi

import com.squareup.moshi.JsonAdapter

data class JsonAdapterFactory(
    val factory: JsonAdapter.Factory,
)