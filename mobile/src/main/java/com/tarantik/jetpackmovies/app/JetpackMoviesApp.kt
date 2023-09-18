package com.tarantik.jetpackmovies.app

import android.app.Application
import com.tarantik.core.base.logging.TimberDebugTree
import com.tarantik.core.network.NetworkContract
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider

@HiltAndroidApp
class JetpackMoviesApp : Application(), NetworkContract {
    @Inject
    lateinit var timberDebugTreeProvider: Provider<TimberDebugTree>

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    override fun onNetworkParseError(path: String, method: String, reason: String) {
        Timber.e("Network parse error: $reason")
    }

    private fun initTimber() {
        if (CoreConfig.RELEASE_BUILD_TYPE) {
            // Report crashes for release builds
            Timber.plant(timberDebugTreeProvider.get())

            if (!CoreConfig.PRODUCTION_FLAVOR) {
                // Log to console for all the flavors except Production
                Timber.plant(timberDebugTreeProvider.get())
            }
        } else {
            // Log to console for debug builds
            Timber.plant(timberDebugTreeProvider.get())
        }
    }
}