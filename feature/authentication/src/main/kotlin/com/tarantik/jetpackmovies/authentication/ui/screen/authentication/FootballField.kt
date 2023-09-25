package com.tarantik.jetpackmovies.authentication.ui.screen.authentication

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FootballField(
    fieldWidth: Dp,
    shots: List<Pair<Float, Float>>,
    goal: List<Boolean>
) {
    val grassColor = Color(0xFF4CAF50)
    val missColor = Color(0xFFFF5722)
    val goalColor = Color(0xFF00FF00)
    val lineColor = Color.White
    val fieldHeight = fieldWidth * 0.6f



    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Canvas(
            modifier = Modifier
                .size(
                    width = fieldWidth,
                    height = fieldHeight,
                )
            ) {
            val meterPx = size.width / 100
            val fieldWidthPx = fieldWidth.toPx()
            val fieldHeight = fieldHeight.toPx()

            drawRect(grassColor)

            val centerX = fieldWidth/2f
            val centerXPx = centerX.toPx()

            drawLine(
                color = lineColor,
                Offset(centerXPx, 0f),
                Offset(centerXPx, fieldHeight),
                strokeWidth = 4f
            )

            val centerCircleRadius = fieldWidthPx / 10f
            drawCircle(
                color = lineColor,
                center = Offset(centerXPx, (fieldHeight/2f)),
                radius = centerCircleRadius,
                style = Stroke(4f)
            )
        }
    }
}