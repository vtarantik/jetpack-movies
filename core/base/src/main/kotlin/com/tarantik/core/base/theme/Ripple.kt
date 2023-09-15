package com.tarantik.core.base.theme

import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable

@Immutable
object RippleTheme : RippleTheme {
    @Composable
    override fun defaultColor() = JetpackMoviesTheme.colors.brand.inversePrimary

    @Composable
    override fun rippleAlpha() = alpha()
}

private fun alpha() = RippleAlpha(
    pressedAlpha = 0.2f,
    focusedAlpha = 0.2f,
    draggedAlpha = 0.24f,
    hoveredAlpha = 0.1f,
)
