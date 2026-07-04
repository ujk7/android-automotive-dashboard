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

@Composable
fun Speedometer(
    speed: Int
) {

    Canvas(
        modifier = Modifier
            .size(320.dp)
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
    }
}