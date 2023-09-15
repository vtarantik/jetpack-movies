package com.tarantik.jetpackmovies.data.movies.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieDetailDTO(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "overview")
    val overview: String?,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "poster_path")
    val posterPath: String,
    @Json(name = "revenue")
    val revenue: Int,
    @Json(name = "runtime")
    val runtime: Int,
    @Json(name = "genres")
    val genres: List<GenreDTO>,
    @Json(name = "adult")
    val adult: Boolean,
    @Json(name = "backdrop_path")
    val backdropPath: String,
    @Json(name = "belongs_to_collection")
    val belongsToCollection: CollectionDTO?,
    @Json(name = "budget")
    val budget: Int,
    @Json(name = "homepage")
    val homepage: String,
    @Json(name = "imdb_id")
    val imdbId: String,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "popularity")
    val popularity: Double,
    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompanyDTO>,
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountryDTO>,
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguageDTO>,
    @Json(name = "status")
    val status: String,
    @Json(name = "tagline")
    val tagline: String,
    @Json(name = "video")
    val video: Boolean,
    @Json(name = "vote_average")
    val voteAverage: Double,
    @Json(name = "vote_count")
    val voteCount: Int
)

@JsonClass(generateAdapter = true)
data class GenreDTO(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String
)

@JsonClass(generateAdapter = true)
data class CollectionDTO(
    val id: Int,
    val name: String,
    val overview: String?,
    val posterPath: String,
    val backdropPath: String,
)

@JsonClass(generateAdapter = true)
data class ProductionCompanyDTO(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String,
)

@JsonClass(generateAdapter = true)
data class ProductionCountryDTO(
    val iso_3166_1: String,
    val name: String,
)

@JsonClass(generateAdapter = true)
data class SpokenLanguageDTO(
    val iso_639_1: String,
    val name: String,
)