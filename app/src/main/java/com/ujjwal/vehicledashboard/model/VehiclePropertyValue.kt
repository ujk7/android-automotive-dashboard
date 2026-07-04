package com.ujjwal.vehicledashboard.model

data class VehiclePropertyValue<T>(
    val propertyId: Int,
    val timestamp: Long,
    val value: T
)