package com.ujjwal.vehicledashboard.model

data class VehicleState(
    val speed: Int,
    val fuel: Int,
    val battery: Int,
    val temperature: Int,
    val gear: String,
    val doorClosed: Boolean
)