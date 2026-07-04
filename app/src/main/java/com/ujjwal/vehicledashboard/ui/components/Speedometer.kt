package com.ujjwal.vehicledashboard.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun Speedometer(
    speed: Int
) {

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {

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

            val start = Offset(
                x = center.x + (size.minDimension / 2 - 40f) * kotlin.math.cos(angle).toFloat(),
                y = center.y + (size.minDimension / 2 - 40f) * kotlin.math.sin(angle).toFloat()
            )

            val end = Offset(
                x = center.x + (size.minDimension / 2 - 20f) * kotlin.math.cos(angle).toFloat(),
                y = center.y + (size.minDimension / 2 - 20f) * kotlin.math.sin(angle).toFloat()
            )

            drawLine(
                color = Color.DarkGray,
                start = start,
                end = end,
                strokeWidth = 4f
            )
        }
    }
}