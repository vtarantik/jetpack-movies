package com.tarantik.jetpackmovies.data.movies.api

import com.tarantik.core.base.arch.Result
import com.tarantik.core.network.retrofit.data.model.ResultsDTO
import com.tarantik.jetpackmovies.data.movies.model.MovieDTO
import com.tarantik.jetpackmovies.data.movies.model.MovieDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/{movieId}")
    suspend fun getMovieDetail(@Path("movieId") movieId: Int): Result<MovieDetailDTO>

    @GET("movie/popular")
    suspend fun listPopularMovies(@Query("page") page: Int = 1): Result<ResultsDTO<List<MovieDTO>>>
}