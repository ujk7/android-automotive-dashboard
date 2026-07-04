package com.ujjwal.vehicledashboard.datasource

import com.ujjwal.vehicledashboard.model.VehicleState

interface VehicleDataSource {

    fun getVehicleState(): VehicleState
}