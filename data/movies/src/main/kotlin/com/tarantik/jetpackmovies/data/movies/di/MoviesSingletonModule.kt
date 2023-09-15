package com.tarantik.jetpackmovies.data.movies.di

import com.tarantik.core.network.di.NetworkModule.MoviesService
import com.tarantik.jetpackmovies.data.movies.api.MoviesApi
import com.tarantik.jetpackmovies.data.movies.repository.MoviesRepositoryImpl
import com.tarantik.jetpackmovies.domain.movies.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.create

@SuppressWarnings("TooManyFunctions")
@Module
@InstallIn(SingletonComponent::class)
object MoviesSingletonModule {

    @Provides
    fun provideMoviesApi(contestsService: MoviesService): MoviesApi = contestsService.client.create()
}

@Module
@InstallIn(SingletonComponent::class)
interface ContestBindSingletonModule {

    @Binds
    fun bindMoviesRepository(repository: MoviesRepositoryImpl): MoviesRepository
}
