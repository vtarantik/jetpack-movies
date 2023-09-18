package com.tarantik.jetpackmovies.data.movies.repository

import com.tarantik.core.base.arch.Result
import com.tarantik.core.base.arch.map
import com.tarantik.jetpackmovies.data.movies.api.MoviesApi
import com.tarantik.jetpackmovies.data.movies.model.toModel
import com.tarantik.jetpackmovies.domain.movies.model.MovieDetailModel
import com.tarantik.jetpackmovies.domain.movies.model.MovieModel
import com.tarantik.jetpackmovies.domain.movies.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi,
) : MoviesRepository {
    override suspend fun listPopularMovies(): Result<List<MovieModel>> = moviesApi.listPopularMovies().map { it.results.map { it.toModel() } }
    override suspend fun getMovieDetail(id: Int): Result<MovieDetailModel> = moviesApi.getMovieDetail(id).map { it.toModel() }
}