package com.tarantik.core.base.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.airbnb.android.showkase.annotation.ShowkaseColor

// Base
@ShowkaseColor(group = "Base")
val Unspecified = Color.Unspecified

@ShowkaseColor(group = "Base")
val Transparent = Color(0x00000000)

@ShowkaseColor(group = "Base")
val LightError = Color(0xffba1a1a)

@ShowkaseColor(group = "Brand")
val LightPrimary = Color(0xFF99461e)

@ShowkaseColor(group = "Brand")
val LightSecondary = Color(0xFF6251a6)

@ShowkaseColor(group = "Brand")
val LightTertiary = Color(0xFF00639c)

@ShowkaseColor(group = "Brand")
val LightInversePrimary = Color(0xFFFFB597)

@ShowkaseColor(group = "Brand")
val LightBackground = Color(0xFFfffbff)

@ShowkaseColor(group = "Base")
val LightOnError = Color(0xffffffff)

@ShowkaseColor(group = "Brand")
val LightOnPrimary = Color(0xFF99461e)

@ShowkaseColor(group = "Brand")
val LightOnSecondary = Color(0xFF6251a6)

@ShowkaseColor(group = "Brand")
val LightOnTertiary = Color(0xFF00639c)

@ShowkaseColor(group = "Brand")
val LightOnBackground = Color(0xFF201a18)

@ShowkaseColor(group = "Brand")
val LightOutline = Color(0xFF85736D)

@ShowkaseColor(group = "Brand")
val LightOutlineVariant = Color(0xFFD8C2BA)

@ShowkaseColor(group = "Brand")
val LightScrim = Color(0xFF000000)


@ShowkaseColor(group = "Base")
val LightErrorContainer = Color(0xffffdbcd)

@ShowkaseColor(group = "Brand")
val LightPrimaryContainer = Color(0xFFffdbcd)

@ShowkaseColor(group = "Brand")
val LightSecondaryContainer = Color(0xFFe6deff)

@ShowkaseColor(group = "Brand")
val LightTertiaryContainer = Color(0xFFcee5ff)

@ShowkaseColor(group = "Brand")
val LightSurface = Color(0xFFfffbff)

@ShowkaseColor(group = "Brand")
val LightSurfaceVariant = Color(0xFFf5ded6)

@ShowkaseColor(group = "Base")
val LightOnErrorContainer = Color(0xff410002)

@ShowkaseColor(group = "Base")
val LightInverseSurface = Color(0xFF362F2C)

@ShowkaseColor(group = "Brand")
val LightOnPrimaryContainer = Color(0xFF360f00)

@ShowkaseColor(group = "Brand")
val LightOnSecondaryContainer = Color(0xFF1d0160)

@ShowkaseColor(group = "Brand")
val LightOnTertiaryContainer = Color(0xFF001d33)

@ShowkaseColor(group = "Brand")
val LightOnSurface = Color(0xFF201a18)

@ShowkaseColor(group = "Brand")
val LightOnSurfaceVariant = Color(0xFF53433e)

@ShowkaseColor(group = "Brand")
val LightInverseOnSurface = Color(0xFFFBEEEA)

// Dark Theme
@ShowkaseColor(group = "Base")
val DarkError = Color(0xffba1a1a)

@ShowkaseColor(group = "Brand")
val DarkPrimary = Color(0xFF99461e)

@ShowkaseColor(group = "Brand")
val DarkSecondary = Color(0xFF6251a6)

@ShowkaseColor(group = "Brand")
val DarkTertiary = Color(0xFF00639c)

@ShowkaseColor(group = "Brand")
val DarkInversePrimary = Color(0xFF99461E)

@ShowkaseColor(group = "Brand")
val DarkBackground = Color(0xFFfffbff)

@ShowkaseColor(group = "Base")
val DarkOnError = Color(0xffffffff)

@ShowkaseColor(group = "Brand")
val DarkOnPrimary = Color(0xFF99461e)

@ShowkaseColor(group = "Brand")
val DarkOnSecondary = Color(0xFF6251a6)

@ShowkaseColor(group = "Brand")
val DarkOnTertiary = Color(0xFF00639c)

@ShowkaseColor(group = "Brand")
val DarkOnBackground = Color(0xFF201a18)

@ShowkaseColor(group = "Brand")
val DarkOutline = Color(0xFFA08D86)

@ShowkaseColor(group = "Brand")
val DarkOutlineVariant = Color(0xFF53433E)

@ShowkaseColor(group = "Brand")
val DarkScrim = Color(0xFF000000)

@ShowkaseColor(group = "Base")
val DarkErrorContainer = Color(0xffffdbcd)

@ShowkaseColor(group = "Brand")
val DarkPrimaryContainer = Color(0xFFffdbcd)

@ShowkaseColor(group = "Brand")
val DarkSecondaryContainer = Color(0xFFe6deff)

@ShowkaseColor(group = "Brand")
val DarkTertiaryContainer = Color(0xFFcee5ff)

@ShowkaseColor(group = "Brand")
val DarkSurface = Color(0xFFfffbff)

@ShowkaseColor(group = "Brand")
val DarkSurfaceVariant = Color(0xFFf5ded6)

@ShowkaseColor(group = "Base")
val DarkOnErrorContainer = Color(0xff410002)

@ShowkaseColor(group = "Base")
val DarkInverseSurface = Color(0xFFEDE0DC)

@ShowkaseColor(group = "Brand")
val DarkOnPrimaryContainer = Color(0xFF360f00)

@ShowkaseColor(group = "Brand")
val DarkOnSecondaryContainer = Color(0xFF1d0160)

@ShowkaseColor(group = "Brand")
val DarkOnTertiaryContainer = Color(0xFF001d33)

@ShowkaseColor(group = "Brand")
val DarkOnSurface = Color(0xFF201a18)

@ShowkaseColor(group = "Brand")
val DarkOnSurfaceVariant = Color(0xFF53433e)

@ShowkaseColor(group = "Brand")
val DarkInverseOnSurface = Color(0xFF201A18)

@Immutable
data class JetpackMoviesColors(
    val light: Boolean,
    val base: BaseColors = if (light) BaseColors.Light() else BaseColors.Dark(),
    val brand: BrandColors = if(light) BrandColors.Light() else BrandColors.Dark(),
    val surface: SurfaceColors = if (light) SurfaceColors.Light() else SurfaceColors.Dark(),
    val onSurface: OnSurfaceColors = if (light) OnSurfaceColors.Light() else OnSurfaceColors.Dark(),
)

@Immutable
sealed interface BaseColors {
    val unspecified: Color
    val transparent: Color
    val error: Color
    val onError: Color

    data class Light(
        override val unspecified: Color = Unspecified,
        override val transparent: Color = Transparent,
        override val error: Color = LightError,
        override val onError: Color = LightOnError,
    ) : BaseColors

    data class Dark(
        override val unspecified: Color = Unspecified,
        override val transparent: Color = Transparent,
        override val error: Color = DarkError,
        override val onError: Color = DarkOnError,
    ) : BaseColors
}

@Immutable
sealed interface BrandColors {
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val onPrimary: Color
    val onSecondary: Color
    val onTertiary: Color
    val inversePrimary: Color
    val background: Color
    val onBackground: Color
    val outline: Color
    val outlineVariant: Color
    val scrim: Color

    data class Light(
        override val primary: Color = LightPrimary,
        override val secondary: Color = LightSecondary,
        override val tertiary: Color = LightTertiary,
        override val onPrimary: Color = LightOnPrimary,
        override val onSecondary: Color = LightOnSecondary,
        override val onTertiary: Color = LightOnTertiary,
        override val inversePrimary: Color = LightInversePrimary,
        override val background: Color = LightBackground,
        override val onBackground: Color = LightOnBackground,
        override val outline: Color = LightOutline,
        override val outlineVariant: Color = LightOutlineVariant,
        override val scrim: Color = LightScrim,
    ) : BrandColors

    data class Dark(
        override val primary: Color = DarkPrimary,
        override val secondary: Color = DarkSecondary,
        override val tertiary: Color = DarkTertiary,
        override val onPrimary: Color = DarkOnPrimary,
        override val onSecondary: Color = DarkOnSecondary,
        override val onTertiary: Color = DarkOnTertiary,
        override val inversePrimary: Color = DarkInversePrimary,
        override val background: Color = DarkBackground,
        override val onBackground: Color = DarkOnBackground,
        override val outline: Color = DarkOutline,
        override val outlineVariant: Color = DarkOutlineVariant,
        override val scrim: Color = DarkScrim,
    ) : BrandColors
}

@Immutable
sealed interface SurfaceColors {
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val error: Color
    val surface: Color
    val surfaceVariant: Color
    val inverseSurface: Color

    data class Light(
        override val primary: Color = LightPrimaryContainer,
        override val secondary: Color = LightSecondaryContainer,
        override val tertiary: Color = LightTertiaryContainer,
        override val error: Color = LightErrorContainer,
        override val surface: Color = LightSurface,
        override val surfaceVariant: Color = LightSurfaceVariant,
        override val inverseSurface: Color = LightInverseSurface,
    ) : SurfaceColors

    data class Dark(
        override val primary: Color = DarkPrimaryContainer,
        override val secondary: Color = DarkSecondaryContainer,
        override val tertiary: Color = DarkTertiaryContainer,
        override val error: Color = DarkErrorContainer,
        override val surface: Color = DarkSurface,
        override val surfaceVariant: Color = DarkSurfaceVariant,
        override val inverseSurface: Color = DarkInverseSurface,
    ) : SurfaceColors
}

@Immutable
sealed interface OnSurfaceColors {
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val error: Color
    val onSurface: Color
    val onSurfaceVariant: Color
    val inverseOnSurface: Color

    data class Light(
        override val primary: Color = LightOnPrimaryContainer,
        override val secondary: Color = LightOnSecondaryContainer,
        override val tertiary: Color = LightOnTertiaryContainer,
        override val error: Color = LightOnErrorContainer,
        override val onSurface: Color = LightOnSurface,
        override val onSurfaceVariant: Color = LightOnSurfaceVariant,
        override val inverseOnSurface: Color = LightInverseOnSurface
    ) : OnSurfaceColors

    data class Dark(
        override val primary: Color = DarkOnPrimaryContainer,
        override val secondary: Color = DarkOnSecondaryContainer,
        override val tertiary: Color = DarkOnTertiaryContainer,
        override val error: Color = DarkOnErrorContainer,
        override val onSurface: Color = DarkOnSurface,
        override val onSurfaceVariant: Color = DarkOnSurfaceVariant,
        override val inverseOnSurface: Color = DarkInverseOnSurface,
    ) : OnSurfaceColors
}

internal val LightThemeColors = JetpackMoviesColors(light = true)
internal val DarkThemeColors = JetpackMoviesColors(light = false)

internal fun JetpackMoviesColors.toMaterialColors(): ColorScheme = ColorScheme(
    primary = brand.primary,
    onPrimary = brand.onPrimary,
    primaryContainer = surface.primary,
    onPrimaryContainer = onSurface.primary,
    inversePrimary = brand.inversePrimary,
    secondary = brand.secondary,
    onSecondary = brand.onSecondary,
    secondaryContainer = surface.secondary,
    onSecondaryContainer = onSurface.secondary,
    tertiary = brand.tertiary,
    onTertiary = brand.onTertiary,
    tertiaryContainer = surface.tertiary,
    onTertiaryContainer = onSurface.tertiary,
    background = brand.background,
    onBackground = brand.onBackground,
    surface = surface.surface,
    onSurface = onSurface.onSurface,
    surfaceVariant = surface.surfaceVariant,
    onSurfaceVariant = onSurface.onSurfaceVariant,
    surfaceTint = surface.secondary,
    inverseSurface = surface.inverseSurface,
    inverseOnSurface = onSurface.inverseOnSurface,
    error = base.error,
    onError = base.onError,
    errorContainer = surface.error,
    onErrorContainer = onSurface.error,
    outline = brand.outline,
    outlineVariant = brand.outlineVariant,
    scrim = brand.scrim,
)

internal val LocalColorScheme = staticCompositionLocalOf { LightThemeColors }
