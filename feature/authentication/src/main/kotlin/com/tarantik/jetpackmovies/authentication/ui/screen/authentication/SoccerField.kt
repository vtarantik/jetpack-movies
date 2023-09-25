package com.tarantik.jetpackmovies.authentication.ui.screen.authentication

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.unit.Dp

@Composable
fun SoccerField(fieldWidth: Dp, shots: List<Pair<Float, Float>>, goals: List<Boolean>) {
    val grassColor = Color(0xFF4CAF50)
    val goalColor = Color(0xFFFF5722)
    val missColor = Color(0xFF00FF00)
    val lineColor = Color.White
    val fieldHeight = fieldWidth * 0.6f
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.background(Color.Black)
    ){
        Canvas(modifier = Modifier.size(
            width = fieldWidth,
            height = fieldHeight
        )) {
            val meterPx = size.width / 100
            val fieldHeightPx = fieldHeight.toPx()
            val fieldWidthPx = fieldWidth.toPx()

            drawRect(grassColor)

            // Draw center line
            val centerX = fieldWidth / 2f
            val centerXPx = centerX.toPx()
            drawLine(lineColor, Offset(centerX.toPx(), 0f), Offset(centerX.toPx(), fieldHeight.toPx()), strokeWidth = 4f)

            // Draw center circle
            val centerCircleRadius = fieldWidth / 10f
            drawCircle(lineColor, center = Offset(centerX.toPx(), (fieldHeight / 2f).toPx()), radius = centerCircleRadius.toPx(), style = Stroke(width = 4f))

            // Draw penalty boxes
            val penaltyAreaWidth = meterPx * 16.5f
            val penaltyAreaHeight = meterPx * 40.3f
            val leftPenaltyArea = Rect(left = 0f, top = (fieldHeightPx - penaltyAreaHeight) / 2f, right = penaltyAreaWidth, bottom = (fieldHeightPx + penaltyAreaHeight) / 2f)
            val rightPenaltyArea = Rect(left = fieldWidthPx - penaltyAreaWidth, top = (fieldHeightPx - penaltyAreaHeight) / 2f, right = fieldWidthPx, bottom = (fieldHeightPx + penaltyAreaHeight) / 2f)
            drawRect(lineColor, leftPenaltyArea.topLeft, leftPenaltyArea.size, style = Stroke(width = 4f))
            drawRect(lineColor, rightPenaltyArea.topLeft, rightPenaltyArea.size, style = Stroke(width = 4f))

            // Draw penalty marks
            val penaltyMarkRadius = meterPx * 0.5f
            val leftPenaltyMark = Offset(meterPx * 11f, fieldHeightPx / 2f)
            val rightPenaltyMark = Offset(fieldWidthPx - meterPx * 11f, fieldHeightPx / 2f)
            drawCircle(lineColor, penaltyMarkRadius, leftPenaltyMark)
            drawCircle(lineColor, penaltyMarkRadius, rightPenaltyMark)

            // Draw goal areas
            val goalAreaWidth = meterPx * 5.5f
            val goalAreaHeight = meterPx * 18.32f
            val leftGoalArea = Rect(left = 0f, top = (fieldHeightPx - goalAreaHeight) / 2f, right = goalAreaWidth, bottom = (fieldHeightPx + goalAreaHeight) / 2f)
            val rightGoalArea = Rect(left = fieldWidthPx - goalAreaWidth, top = (fieldHeightPx - goalAreaHeight) / 2f, right = fieldWidthPx, bottom = (fieldHeightPx + goalAreaHeight) / 2f)
            drawRect(lineColor, leftGoalArea.topLeft, leftGoalArea.size, style = Stroke(width = 4f))
            drawRect(lineColor, rightGoalArea.topLeft, rightGoalArea.size, style = Stroke(width = 4f))

            // Draw goals
            val goalWidth = meterPx * 1f
            val goalHeight = meterPx * 7.32f
            val leftGoal = Rect(left = 0f, top = (fieldHeightPx - goalHeight) / 2f, right = goalWidth, bottom = (fieldHeightPx + goalHeight) / 2f)
            val rightGoal = Rect(left = fieldWidthPx - goalWidth, top = (fieldHeightPx - goalHeight) / 2f, right = fieldWidthPx, bottom = (fieldHeightPx + goalHeight) / 2f)
            drawRect(lineColor, leftGoal.topLeft, leftGoal.size, style = Stroke(4f))
            drawRect(lineColor, rightGoal.topLeft, rightGoal.size, style = Stroke(4f))

            // Draw corner kicks
            val cornerKickRadius = meterPx * 2f
            val topLeftCornerKick = Offset(0f - cornerKickRadius/2f, - cornerKickRadius/2f)
            val topRightCornerKick = Offset(fieldWidthPx- cornerKickRadius/2f , - cornerKickRadius/2f)
            val bottomLeftCornerKick = Offset(- cornerKickRadius/2f, fieldHeightPx - cornerKickRadius/2f)
            val bottomRightCornerKick = Offset(fieldWidthPx - cornerKickRadius/2f, fieldHeightPx- cornerKickRadius/2f)
            drawArc(size = Size(cornerKickRadius, cornerKickRadius), topLeft = topLeftCornerKick, color = lineColor, startAngle = 0f, sweepAngle = 90f, useCenter = false, style = Stroke(4f))
            drawArc(size = Size(cornerKickRadius, cornerKickRadius), topLeft = topRightCornerKick, color = lineColor, startAngle = 90f, sweepAngle = 90f, useCenter = false, style = Stroke(4f))
            drawArc(size = Size(cornerKickRadius, cornerKickRadius), topLeft = bottomLeftCornerKick, color = lineColor, startAngle = 270f, sweepAngle = 90f, useCenter = false, style = Stroke(4f))
            drawArc(size = Size(cornerKickRadius, cornerKickRadius), topLeft = bottomRightCornerKick, color = lineColor, startAngle = 180f, sweepAngle = 90f, useCenter = false, style = Stroke(4f))

            // Draw shots
            val shotPointRadius = meterPx * 1f
            for ((i, shot) in shots.withIndex()) {
                val shotX = shot.first
                val shotY = shot.second
                val isGoal = goals[i]

                val shotOffset = Offset(shotX, shotY)
                val arrowOffset = Offset(0f, fieldHeightPx / 2f)

                if (isGoal) {
                    drawCircle(goalColor, shotPointRadius, shotOffset)
                } else {
                    drawCircle(missColor, shotPointRadius, shotOffset)
                }

                drawLine(
                    color = lineColor,
                    start = shotOffset,
                    end = arrowOffset,
                    strokeWidth = 2f,
                    pathEffect = PathEffect.cornerPathEffect(5f),
                    cap = StrokeCap.Round,
                    alpha = 0.8f
                )
            }
        }
    }
}