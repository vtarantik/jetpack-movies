package com.tarantik.jetpackmovies.nav

import com.tarantik.core.base.arch.BaseViewModel
import com.tarantik.jetpackmovies.model.MainUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): BaseViewModel() {
    private val _state = MutableStateFlow(MainUiModel())
    val state = _state.asStateFlow()

    fun isUserAuthenticated() = state.value.userAuthenticated

}
