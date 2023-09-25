package com.tarantik.jetpackmovies.movieslist.ui.screen.movieslist

import com.tarantik.core.base.arch.BaseViewModel
import com.tarantik.jetpackmovies.domain.movies.usecase.ListMoviesUseCase
import com.tarantik.jetpackmovies.ui.movies.model.MoviesListUiModel
import com.tarantik.jetpackmovies.ui.movies.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val listMoviesUseCase: ListMoviesUseCase,
): BaseViewModel() {
    private val  _state = MutableStateFlow(MoviesListUiModel())
    val state = _state.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        launch {
            listMoviesUseCase.execute()
                .onData {data ->
                    _state.update {
                        it.copy(movies = data.map { it.toUiModel() })
                    }
                }
                .onError {
                    // TODO add error handling
                }
        }
    }
}