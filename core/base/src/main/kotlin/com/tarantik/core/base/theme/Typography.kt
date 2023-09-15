package com.tarantik.core.base.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.airbnb.android.showkase.annotation.ShowkaseTypography
import com.tarantik.core.base.R

val headlineXxl = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Black,
    fontSize = 24.sp,
    lineHeight = 36.sp,
)

@ShowkaseTypography(group = "Base")
val headlineXl = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Black,
    fontSize = 20.sp,
    lineHeight = 30.sp,
)

@ShowkaseTypography(group = "Base")
val headlineLarge = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Black,
    fontSize = 16.sp,
    lineHeight = 26.sp,
)

@ShowkaseTypography(group = "Base")
val headlineMedium = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Black,
    fontSize = 14.sp,
    lineHeight = 20.sp,
)

@ShowkaseTypography(group = "Base")
val headlineSmall = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Black,
    fontSize = 12.sp,
    lineHeight = 18.sp,
)

@ShowkaseTypography(group = "Base")
val headlineXSmall = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Black,
    fontSize = 8.sp,
    lineHeight = 10.sp,
)

@ShowkaseTypography(group = "Base")
val subheadLarge = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    lineHeight = 24.sp,
)

@ShowkaseTypography(group = "Base")
val subheadMedium = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.SemiBold,
    fontSize = 14.sp,
    lineHeight = 22.sp,
)

@ShowkaseTypography(group = "Base")
val subheadSmall = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.SemiBold,
    fontSize = 12.sp,
    lineHeight = 20.sp,
)

@ShowkaseTypography(group = "Base")
val subheadXSmall = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.SemiBold,
    fontSize = 10.sp,
)

@ShowkaseTypography(group = "Base")
val subheadXXSmall = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.SemiBold,
    fontSize = 8.sp,
)

@ShowkaseTypography(group = "Base")
val titleLarge = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 22.sp,
)

@ShowkaseTypography(group = "Base")
val titleMedium = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 20.sp,
)

@ShowkaseTypography(group = "Base")
val titleSmall = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    lineHeight = 18.sp,
)

@ShowkaseTypography(group = "Base")
val labelLarge = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Black,
    fontSize = 16.sp,
    lineHeight = 24.sp,
)

@ShowkaseTypography(group = "Base")
val labelMedium = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Black,
    fontSize = 14.sp,
    lineHeight = 22.sp,
)

@ShowkaseTypography(group = "Base")
val labelSmall = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Black,
    fontSize = 12.sp,
    lineHeight = 20.sp,
)

@ShowkaseTypography(group = "Base")
val bodyXLarge = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 22.sp,
)

@ShowkaseTypography(group = "Base")
val bodyLarge = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 20.sp,
)

@ShowkaseTypography(group = "Base")
val bodyMedium = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    lineHeight = 18.sp,
)

@ShowkaseTypography(group = "Base")
val bodySmall = TextStyle(
    fontFamily = Fonts.inter,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    lineHeight = 16.sp,
)

@Immutable
data class JetpackMoviesTypography(
    val headline: Headline = Headline(),
    val subhead: Subhead = Subhead(),
    val title: Title = Title(),
    val body: Body = Body(),
    val label: Label = Label(),
)

@Immutable
data class Headline(
    val xxl: TextStyle = headlineXxl,
    val xl: TextStyle = headlineXl,
    val large: TextStyle = headlineLarge,
    val medium: TextStyle = headlineMedium,
    val small: TextStyle = headlineSmall,
    val xSmall: TextStyle = headlineXSmall,
)

@Immutable
data class Subhead(
    val large: TextStyle = subheadLarge,
    val medium: TextStyle = subheadMedium,
    val small: TextStyle = subheadSmall,
    val xSmall: TextStyle = subheadXSmall,
    val xxSmall: TextStyle = subheadXXSmall,
)

@Immutable
data class Title(
    val large: TextStyle = titleLarge,
    val medium: TextStyle = titleMedium,
    val small: TextStyle = titleSmall,
)

@Immutable
data class Body(
    val xLarge: TextStyle = bodyXLarge,
    val large: TextStyle = bodyLarge,
    val medium: TextStyle = bodyMedium,
    val small: TextStyle = bodySmall,
)

@Immutable
data class Label(
    val large: TextStyle = labelLarge,
    val medium: TextStyle = labelMedium,
    val small: TextStyle = labelSmall,
)

internal val Typography = JetpackMoviesTypography()

internal fun JetpackMoviesTypography.toMaterialTypography() = Typography(
    headlineLarge = headline.xxl,
    headlineMedium = headline.xl,
    headlineSmall = headline.large,
    titleLarge = title.large,
    titleMedium = title.medium,
    titleSmall = title.small,
    labelLarge = label.large,
    labelMedium = label.medium,
    labelSmall = label.small,
    bodyLarge = body.large,
    bodyMedium = body.medium,
    bodySmall = body.small,
)

object Fonts {
    val inter = FontFamily(
        Font(R.font.inter_black, weight = FontWeight.Black),
        Font(R.font.inter_semi_bold, weight = FontWeight.SemiBold),
        Font(R.font.inter_medium, weight = FontWeight.Medium),
        Font(R.font.inter_regular, weight = FontWeight.Normal),
    )
}

internal val LocalTypography = staticCompositionLocalOf { Typography }
