package com.tarantik.jetpackmovies.data.movies.model

import com.squareup.moshi.Json
import com.tarantik.jetpackmovies.domain.movies.model.CollectionModel
import com.tarantik.jetpackmovies.domain.movies.model.GenreModel
import com.tarantik.jetpackmovies.domain.movies.model.MovieDetailModel
import com.tarantik.jetpackmovies.domain.movies.model.MovieModel
import com.tarantik.jetpackmovies.domain.movies.model.ProductionCompanyModel
import com.tarantik.jetpackmovies.domain.movies.model.ProductionCountryModel
import com.tarantik.jetpackmovies.domain.movies.model.SpokenLanguageModel

data class MovieDTO(
    val id: Int,
    @Json(name = "poster_path")
    val posterPath: String,
    val adult: Boolean,
    val overview: String,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "genre_ids")
    val genreIds: List<Int>,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "original_language")
    val originalLanguage: String,
    val title: String,
    @Json(name = "backdrop_path")
    val backdropPath: String?,
    val popularity: Double,
    @Json(name = "vote_count")
    val voteCount: Int,
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double,
)

fun MovieDTO.toModel() = MovieModel(
    id = id,
    posterPath = posterPath,
    adult = adult,
    overview = overview,
    releaseDate = releaseDate,
    genreIds = genreIds,
    originalTitle = originalTitle,
    originalLanguage = originalLanguage,
    title = title,
    backdropPath = backdropPath,
    popularity = popularity,
    voteCount = voteCount,
    video = video,
    voteAverage = voteAverage
)

fun MovieDetailDTO.toModel() = MovieDetailModel(
    id = id,
    adult = adult,
    backdropPath = backdropPath,
    belongsToCollection = belongsToCollection?.toModel(),
    budget = budget,
    genres = genres.map { it.toModel() },
    homepage = homepage,
    imdbId = imdbId,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    overview = overview,
    popularity = popularity,
    posterPath = posterPath,
    productionCompanies = productionCompanies.map { it.toModel() },
    productionCountries = productionCountries.map { it.toModel() },
    releaseDate = releaseDate,
    revenue = revenue,
    runtime = runtime,
    spokenLanguages = spokenLanguages.map { it.toModel() },
    status = status,
    tagline = tagline,
    title = title,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount,
)

data class TrailerModel(
    val iso_639_1: String,
    val iso_3166_1: String,
    val name: String,
    val key: String,
    val site: String,
    val size: Int,
    val type: String,
    val official: Boolean,
    val publishedAt: String,
    val id: String
)

fun CollectionDTO.toModel() = CollectionModel(
    id = id,
    name = name,
    overview = overview,
    posterPath = posterPath,
    backdropPath = backdropPath,
)

fun GenreDTO.toModel() = GenreModel(
    id = id,
    name = name,
)

fun ProductionCompanyDTO.toModel() = ProductionCompanyModel(
    id = id,
    logoPath = logoPath,
    name = name,
    originCountry = originCountry,
)

fun ProductionCountryDTO.toModel() = ProductionCountryModel(
    iso_3166_1 = iso_3166_1,
    name = name,
)

fun SpokenLanguageDTO.toModel() = SpokenLanguageModel(
    iso_639_1 = iso_639_1,
    name = name,
)