package com.tarantik.core.base.composable

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ActivityScreen(
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    content: @Composable () -> Unit,
) {
    val bc = backgroundColor ?: MaterialTheme.colorScheme.background
    val cc = contentColor ?: contentColorFor(bc)

    Surface(
        color = bc,
        contentColor = cc,
    ) {
        content()
    }
}
