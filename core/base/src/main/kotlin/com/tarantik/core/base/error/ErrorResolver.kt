package com.tarantik.core.base.error

import android.content.Context
import com.tarantik.core.base.R
import com.tarantik.core.base.util.TextRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

open class ErrorResolver @Inject constructor() {

    @Inject
    @ApplicationContext
    protected lateinit var context: Context

    open fun getErrorMessageRes(error: AppError): Int? =
        when (error) {
            // Mapping
            is AppError.MappingError -> R.string.error_general

            // Network
            is AppError.NetworkError.ResponseError -> R.string.error_general
            is AppError.NetworkError.InvalidResponse -> R.string.error_general
            is AppError.NetworkError.NoConnectivityError -> R.string.error_no_internet
            is AppError.NetworkError.Unauthenticated -> R.string.error_general

            is AppError.Error -> R.string.error_general

            is AppError.Canceled -> null

            // Unknown
            is AppError.UnknownError -> R.string.error_general
        }

    fun getErrorMessage(error: AppError): TextRes? = getErrorMessageRes(error)?.let { TextRes.Regular(it) }
}
