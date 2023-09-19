package com.tarantik.core.base.arch

import CoreConfig
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.tarantik.core.base.R
import com.tarantik.core.base.composable.ActivityScreen
import com.tarantik.core.base.composable.noLocalProviderFor
import com.tarantik.core.base.theme.JetpackMoviesTheme
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity() {
    abstract val content: @Composable () -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        Timber.d(this.javaClass.name)
        super.onCreate(savedInstanceState)

        handleOrientation()

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setupScreen()
    }

    private fun setupScreen() {
            setContent {
                CompositionLocalProvider(
                    LocalActivity provides this,
                ) {
                JetpackMoviesTheme {
                    ActivityScreen(
                        backgroundColor = JetpackMoviesTheme.colors.surface.primary,
                        contentColor = JetpackMoviesTheme.colors.onSurface.primary,
                    ) {
                        Box {
                            content()
                        }
                    }
                }
            }
        }
    }

    private fun handleOrientation() {
        val isTablet = resources.getBoolean(R.bool.is_tablet)
        requestedOrientation = if (isTablet || CoreConfig.DEVELOP_FLAVOR) {
            ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        } else {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }
}

val LocalActivity: ProvidableCompositionLocal<BaseActivity> = staticCompositionLocalOf {
    noLocalProviderFor("LocalActivity")
}