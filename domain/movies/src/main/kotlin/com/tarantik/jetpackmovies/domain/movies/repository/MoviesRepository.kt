package com.tarantik.jetpackmovies.domain.movies.repository

import com.tarantik.core.base.arch.Result
import com.tarantik.jetpackmovies.domain.movies.model.MovieDetailModel
import com.tarantik.jetpackmovies.domain.movies.model.MovieModel

interface MoviesRepository {
    suspend fun listPopularMovies(): Result<List<MovieModel>>
    suspend fun getMovieDetail(id: Int): Result<MovieDetailModel>
}