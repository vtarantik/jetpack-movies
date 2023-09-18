package com.tarantik.jetpackmovies.domain.movies.usecase

import com.tarantik.core.base.arch.Result
import com.tarantik.core.base.util.UseCaseInputLess
import com.tarantik.jetpackmovies.domain.movies.model.MovieModel
import com.tarantik.jetpackmovies.domain.movies.repository.MoviesRepository
import javax.inject.Inject

class ListMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) : UseCaseInputLess<List<MovieModel>> {
    override suspend fun execute(): Result<List<MovieModel>> = moviesRepository.listPopularMovies()
}