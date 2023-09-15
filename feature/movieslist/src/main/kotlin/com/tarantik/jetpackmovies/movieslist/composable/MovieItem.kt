package com.tarantik.jetpackmovies.movieslist.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.tarantik.core.network.composable.RemoteImage
import com.tarantik.jetpackmovies.ui.movies.model.MovieUiModel

@Composable
fun MovieItem(
    movie: MovieUiModel,
    onMovieClick: (movieId: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable(onClick = {onMovieClick(movie.id)})
            .padding(8.dp)
    ) {
        RemoteImage(
            url = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}