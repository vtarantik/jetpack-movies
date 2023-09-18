@file:OptIn(ExperimentalFoundationApi::class)

package com.tarantik.jetpackmovies.movieslist.ui.screen.movieslist

import CoreConfig
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tarantik.core.network.composable.RemoteImage
import com.tarantik.jetpackmovies.feature.movieslist.R
import com.tarantik.jetpackmovies.ui.movies.model.MovieUiModel
import com.tarantik.jetpackmovies.ui.movies.model.MoviesListUiModel
import kotlinx.coroutines.delay

@Composable
fun MoviesListScreen(viewModel: MoviesListViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    MoviesListContent(state = state)
}

@Composable
fun MoviesListContent(state: MoviesListUiModel) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(
            items = state.movies,
            key = {it.id}
        ) { movie ->
            MovieItem(
                movie = movie,
            )
        }
    }
}

@Composable
fun MovieItem(
    movie: MovieUiModel,
) {
    RemoteImage(
        url = CoreConfig.Api.Assets.BASE_URL.replace(CoreConfig.Api.MOVIE_POSTER_PATH, movie.posterPath),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = {

            })
    )
}