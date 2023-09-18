package com.tarantik.jetpackmovies.ui.movies.model

import androidx.compose.runtime.Immutable
import com.tarantik.jetpackmovies.domain.movies.model.MovieModel

@Immutable
data class MovieUiModel(
    val id: Int,
    val title: String,
    val posterPath: String,
)