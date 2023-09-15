package com.tarantik.core.base.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@SuppressWarnings("UnusedPrivateMember")
@Composable
fun JetpackMoviesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    typography: JetpackMoviesTypography = Typography,
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkThemeColors
    } else {
        LightThemeColors
    }

    MaterialTheme(
        colorScheme = colors.toMaterialColors(),
        typography = typography.toMaterialTypography(),
    ) {
        CompositionLocalProvider(
            LocalColorScheme provides colors,
            LocalRippleTheme provides RippleTheme,
            LocalTypography provides typography,
        ) {
            content()
        }
    }
}

object JetpackMoviesTheme {

    val colors: JetpackMoviesColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColorScheme.current

    val typography: JetpackMoviesTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
