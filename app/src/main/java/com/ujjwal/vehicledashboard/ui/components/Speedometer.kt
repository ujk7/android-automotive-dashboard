package com.ujjwal.vehicledashboard.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import android.graphics.Paint
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue

@Composable
fun Speedometer(
    speed: Int
) {
    val animatedSpeed by animateFloatAsState(
        targetValue = speed.toFloat(),
        animationSpec = tween(700),
        label = "speedAnimation"
    )

    Canvas(
        modifier = Modifier
            .size(320.dp)
    ) {
        val textPaint = Paint().apply {
            color = android.graphics.Color.DKGRAY
            textSize = 32f
            textAlign = Paint.Align.CENTER
            isAntiAlias = true
        }

        val needleAngle =
            135f + (animatedSpeed / 180f) * 270f

        drawCircle(
            color = Color.DarkGray,
            style = Stroke(width = 12f)
        )

        drawCircle(
            color = Color.Green,
            radius = 8f,
            center = Offset(size.width / 2, size.height / 2)
        )

        repeat(37) { index ->

            val angle = Math.toRadians((135 + index * 7.5).toDouble())

            val isMajorTick = index % 5 == 0

            val outerRadius = size.minDimension / 2 - 20f

            val innerRadius =
                if (isMajorTick)
                    outerRadius - 35f
                else
                    outerRadius - 20f

            val start = Offset(
                x = center.x + innerRadius * kotlin.math.cos(angle).toFloat(),
                y = center.y + innerRadius * kotlin.math.sin(angle).toFloat()
            )

            val end = Offset(
                x = center.x + outerRadius * kotlin.math.cos(angle).toFloat(),
                y = center.y + outerRadius * kotlin.math.sin(angle).toFloat()
            )

            drawLine(
                color = Color.DarkGray,
                start = start,
                end = end,
                strokeWidth = if (isMajorTick) 6f else 3f
            )
        }
        for (i in 0..8) {

            val speedLabel = i * 20

            val angle = Math.toRadians((135 + i * 37.5).toDouble())

            val radius = size.minDimension / 2 - 60f

            val x = center.x + radius * kotlin.math.cos(angle).toFloat()

            val y = center.y + radius * kotlin.math.sin(angle).toFloat()

            drawContext.canvas.nativeCanvas.drawText(
                speedLabel.toString(),
                x,
                y,
                textPaint
            )
        }
        val needleLength = size.minDimension / 2 - 60f

        val angleRad = Math.toRadians(needleAngle.toDouble())

        drawLine(
            color = Color.Red,
            start = center,
            end = Offset(
                x = center.x + needleLength * kotlin.math.cos(angleRad).toFloat(),
                y = center.y + needleLength * kotlin.math.sin(angleRad).toFloat()
            ),
            strokeWidth = 8f
        )
        drawCircle(
            color = Color.Red,
            radius = 10f,
            center = center
        )
    }
}