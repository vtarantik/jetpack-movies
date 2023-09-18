package com.tarantik.jetpackmovies.di

import com.tarantik.core.base.logging.base.LogTag
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun logTag(): LogTag = LogTag(value = "JetpackMovies")
}
