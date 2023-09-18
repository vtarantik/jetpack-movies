package com.tarantik.core.network.retrofit.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultsDTO<out T : Any>(
    val results: T,
    val total: Int?,
)

@JsonClass(generateAdapter = true)
data class NullableResultsDTO<out T : Any?>(
    val data: T?,
    val total: Int?,
)
