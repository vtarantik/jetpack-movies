import com.tarantik.core.base.BuildConfig

// ktlint-disable max-line-length

private const val FLAVOR_PRODUCTION = "production"
private const val FLAVOR_STAGING = "staging"
private const val FLAVOR_DEVELOP = "develop"

private const val BUILD_TYPE_DEBUG = "debug"
private const val BUILD_TYPE_RELEASE = "release"


object CoreConfig {
    const val PRODUCTION_FLAVOR = BuildConfig.FLAVOR == FLAVOR_PRODUCTION
    const val STAGING_FLAVOR = BuildConfig.FLAVOR == FLAVOR_STAGING
    const val DEVELOP_FLAVOR = BuildConfig.FLAVOR == FLAVOR_DEVELOP

    const val DEBUG_BUILD_TYPE = BuildConfig.BUILD_TYPE == BUILD_TYPE_DEBUG
    const val RELEASE_BUILD_TYPE = BuildConfig.BUILD_TYPE == BUILD_TYPE_RELEASE

    const val FLAVOR = BuildConfig.FLAVOR

    object Api {
        object MoviesService {
            private const val PRODUCTION_URL: String = "https://api.themoviedb.org/3/"
            private const val STAGING_URL: String = "https://api.themoviedb.org/3/"
            private const val DEVELOP_URL: String = "https://api.themoviedb.org/3/"

            val BASE_URL = when {
                PRODUCTION_FLAVOR -> PRODUCTION_URL
                STAGING_FLAVOR -> STAGING_URL
                DEVELOP_FLAVOR -> DEVELOP_URL
                else -> throw UnknownError("Unknown flavor")
            }
        }

        const val REQUEST_TIMEOUT_SEC = 30L
        const val MAX_PARALLEL_REQUESTS = 20
        const val MOVIE_POSTER_PATH = "MOVIE_POSTER_PATH"

        object Assets {
            private const val PRODUCTION_URL: String = "https://image.tmdb.org/t/p/w500$MOVIE_POSTER_PATH"
            private const val STAGING_URL: String = "https://image.tmdb.org/t/p/w500$MOVIE_POSTER_PATH"
            private const val DEVELOP_URL: String = "https://image.tmdb.org/t/p/w500$MOVIE_POSTER_PATH"

            val BASE_URL = when {
                PRODUCTION_FLAVOR -> PRODUCTION_URL
                STAGING_FLAVOR -> STAGING_URL
                DEVELOP_FLAVOR -> DEVELOP_URL
                else -> throw UnknownError("Unknown flavor")
            }
        }
    }
}
