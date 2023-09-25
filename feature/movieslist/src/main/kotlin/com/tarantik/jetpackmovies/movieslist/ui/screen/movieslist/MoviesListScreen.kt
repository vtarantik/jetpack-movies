@file:OptIn(ExperimentalFoundationApi::class)

package com.tarantik.jetpackmovies.movieslist.ui.screen.movieslist

import CoreConfig
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tarantik.core.base.arch.LocalActivity
import com.tarantik.core.network.composable.RemoteImage
import com.tarantik.jetpackmovies.ui.movies.model.MovieUiModel
import com.tarantik.jetpackmovies.ui.movies.model.MoviesListUiModel
import kotlinx.coroutines.launch
import timber.log.Timber

interface MoviesListListener {
    fun onMovieClick(movie: MovieUiModel)
}

data class WatchableMovie(
    val id: Int,
    val seen: Boolean,
)

@Composable
fun MoviesListScreen(viewModel: MoviesListViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    val activity = LocalActivity.current


//    val currentOnAction by rememberUpdatedState(onAction)

//    MoviesListContent(state = state)
//
//    LaunchedEffect(Unit) {
//        delay(5000)
//        viewModel.loadMovies()
//        currentOnAction()
//    }

    val seenMovieIds = remember(state) {
        mutableStateListOf<Int>()
    }

    val unseenMovieIds = remember(state) {
        mutableStateListOf<Int>().apply {
            addAll(
                state.movies.map { it.id }
            )
        }
    }

    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val listener = remember(viewModel, activity, seenMovieIds, unseenMovieIds) {
        object : MoviesListListener {
            override fun onMovieClick(movie: MovieUiModel) {
                seenMovieIds.add(movie.id)
                unseenMovieIds.remove(movie.id)
            }
        }
    }

    val seenMovies by remember(seenMovieIds) {
        derivedStateOf {
            state.movies.filter { seenMovieIds.contains(it.id) }
        }
    }

    val unseenMovies by remember(unseenMovieIds) {
        derivedStateOf {
            state.movies.filter { unseenMovieIds.contains(it.id) }
        }
    }

    Column(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        LazyRow {
            items(seenMovies) {
                MovieItem(
                    movie = it,
                    onClick = {

                    },
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow {
            items(unseenMovies) {
                MovieItem(
                    movie = it,
                    onClick = {

                    },
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Column {
                        Image(
                            painter = painterResource(id = com.tarantik.core.base.R.drawable.img_poster),
                            contentDescription = null,
                        )

                        LazyColumn {
                            items(3) {
                                Text("Drawer item $it")
                            }
                        }
                    }
                }
            }
        ) {
            MoviesScaffold(
                state = state,
                listener = listener,
            )
        }
    }
}

@Composable
fun MoviesScaffold(
    state: MoviesListUiModel,
    listener: MoviesListListener,
) {
    val gridState = rememberLazyGridState()

    val showButton by remember {
        derivedStateOf {
            gridState.firstVisibleItemIndex > 0
        }
    }

    Scaffold(
        floatingActionButton = {
            if (showButton) {
                FloatingActionButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(id = com.tarantik.core.base.R.drawable.ic_cancel),
                        contentDescription = null
                    )
                }
            }
        },
        contentWindowInsets = WindowInsets(0.dp, 0.dp, 0.dp, 0.dp)
    ) { padding ->
        MoviesListContent(
            state = state,
            gridState = gridState,
            listener = listener,
            modifier = Modifier
                .padding(padding)
        )
    }
}

@Composable
fun MoviesListContent(
    state: MoviesListUiModel,
    gridState: LazyGridState,
    listener: MoviesListListener,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(2),
        state = gridState,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        // TODO move LazyRows here

        items(
            items = state.movies,
            key = { it.id }
        ) { movie ->
            MovieItem(
                movie = movie,
                onClick = { listener.onMovieClick(movie) },
            )
        }

        item {
            Spacer(modifier = Modifier.navigationBarsPadding())
        }
    }
}

@Composable
fun MovieItem(
    movie: MovieUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    RemoteImage(
        url = CoreConfig.Api.Assets.BASE_URL.replace(
            CoreConfig.Api.MOVIE_POSTER_PATH,
            movie.posterPath
        ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
    )
}
