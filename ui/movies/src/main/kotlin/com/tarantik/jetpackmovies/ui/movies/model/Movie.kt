package com.tarantik.jetpackmovies.ui.movies.model

import androidx.compose.runtime.Immutable
import com.tarantik.jetpackmovies.domain.movies.model.MovieModel

@Immutable
data class MoviesListUiModel(
    val movies: List<MovieUiModel> = emptyList(),
)

@Immutable
data class MovieUiModel(
    val id: Int,
    val title: String,
    val posterPath: String,
)

fun MovieModel.toUiModel() = MovieUiModel(
    id = id,
    title = title,
    posterPath = posterPath,
)