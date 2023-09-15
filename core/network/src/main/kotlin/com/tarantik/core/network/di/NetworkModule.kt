package com.tarantik.core.network.di

import com.tarantik.core.network.retrofit.adapter.ResultCallAdapterFactory
import com.tarantik.core.network.retrofit.interceptor.LoggingInterceptor
import com.squareup.moshi.Moshi
import com.tarantik.core.base.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = LoggingInterceptor.provide()

    @Provides
    @Singleton
    fun provideHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): HttpClient = HttpClient(
        OkHttpClient.Builder()
            .connectTimeout(CoreConfig.Api.REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS)
            .readTimeout(CoreConfig.Api.REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS)
            .writeTimeout(CoreConfig.Api.REQUEST_TIMEOUT_SEC, TimeUnit.SECONDS)
            .dispatcher(
                Dispatcher().apply {
                    maxRequests = CoreConfig.Api.MAX_PARALLEL_REQUESTS
                    maxRequestsPerHost = CoreConfig.Api.MAX_PARALLEL_REQUESTS
                },
            )
            .retryOnConnectionFailure(false)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(getQueryInterceptor())
            .build(),
    )

    @Provides
    @Singleton
    fun provideMoviesService(
        httpClient: HttpClient,
        moshi: Moshi,
        resultCallAdapterFactory: ResultCallAdapterFactory,
    ): MoviesService = MoviesService(
        Retrofit.Builder()
            .baseUrl(CoreConfig.Api.MoviesService.BASE_URL)
            .client(httpClient.client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(resultCallAdapterFactory)
            .build(),
    )

    private fun getQueryInterceptor(): Interceptor = Interceptor { chain ->
        val original = chain.request()
        val originalHttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY) // TODO
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder().url(url)

        val request = requestBuilder.build()
        chain.proceed(request)
    }

    data class HttpClient(
        val client: OkHttpClient,
    )

    data class MoviesService(
        val client: Retrofit,
    )
}
