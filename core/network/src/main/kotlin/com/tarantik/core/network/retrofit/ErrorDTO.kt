package com.tarantik.core.network.retrofit

import com.tarantik.core.base.error.AppError
import com.tarantik.core.base.error.ResponseErrorModel
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import retrofit2.Response

@JsonClass(generateAdapter = true)
data class ErrorDTO(
    val error: String,
    val message: String,
)

@SuppressWarnings("TooGenericExceptionCaught", "SwallowedException")
fun Response<*>.toAppError(moshi: Moshi): AppError {
    val errorBody = try {
        errorBody()?.string()
    } catch (e: Exception) {
        null
    }

    return try {
        val error = if (errorBody != null) {
            val parser = moshi.adapter(ErrorDTO::class.java)
            parser?.fromJson(errorBody)
        } else {
            null
        }

        if (error != null) {
            AppError.NetworkError.ResponseError(Throwable("API error."), error.toModel())
        } else {
            AppError.NetworkError.InvalidResponse(Throwable("Unable to parse error."), errorBody)
        }
    } catch (e: Exception) {
        AppError.NetworkError.InvalidResponse(e, errorBody)
    }
}

fun ErrorDTO.toModel() = ResponseErrorModel(
    type = error,
    message = message,
)
