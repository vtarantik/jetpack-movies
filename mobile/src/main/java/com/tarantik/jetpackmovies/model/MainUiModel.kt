package com.tarantik.jetpackmovies.model

import androidx.compose.runtime.Immutable


@Immutable
data class MainUiModel(
    val userAuthenticated: Boolean = false,
    val dialogVisible: Boolean = false,
    val authenticationFinished:Boolean = false,
)