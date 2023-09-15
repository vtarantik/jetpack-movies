package com.tarantik.core.network.retrofit.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataDTO<out T : Any>(
    val data: T,
    val total: Int?,
)

@JsonClass(generateAdapter = true)
data class NullableDataDTO<out T : Any?>(
    val data: T?,
    val total: Int?,
)
