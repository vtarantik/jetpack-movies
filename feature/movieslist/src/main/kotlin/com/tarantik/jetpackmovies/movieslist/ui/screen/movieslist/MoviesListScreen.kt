package com.tarantik.jetpackmovies.movieslist.ui.screen.movieslist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.tarantik.core.base.BuildConfig
import com.tarantik.jetpackmovies.ui.movies.model.MovieUiModel

@Composable
fun MoviesListScreen() {
    MoviesList(
        movies = emptyList(),
        onMovieClick = {}
    )
}

@Composable
fun MoviesList(
    movies: List<MovieUiModel>,
    onMovieClick: (movieId: Int) -> Unit,
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(8.dp),
        columns = GridCells.Fixed(2)
    ) {
        items(movies) { movie ->
            Text("Hello")
        }
        BuildConfig.FLAVOR
    }
}