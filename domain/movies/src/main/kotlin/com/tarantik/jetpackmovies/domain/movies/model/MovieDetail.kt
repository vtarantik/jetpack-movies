package com.tarantik.jetpackmovies.domain.movies.model

data class MovieDetailModel(
    val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val belongsToCollection: CollectionModel?,
    val budget: Int,
    val genres: List<GenreModel>,
    val homepage: String,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String?,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyModel>,
    val productionCountries: List<ProductionCountryModel>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageModel>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)

data class CollectionModel(
    val id: Int,
    val name: String,
    val overview: String?,
    val posterPath: String,
    val backdropPath: String,
)

data class GenreModel(
    val id: Int,
    val name: String,
)

data class ProductionCompanyModel(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String,
)

data class ProductionCountryModel(
    val iso_3166_1: String,
    val name: String,
)

data class SpokenLanguageModel(
    val iso_639_1: String,
    val name: String,
)
