package com.ujjwal.vehicledashboard.datasource

import com.ujjwal.vehicledashboard.model.VehicleState
import javax.inject.Inject

class FakeVehicleDataSource @Inject constructor() : VehicleDataSource {

    override fun getVehicleState(): VehicleState {
        return VehicleState(
            speed = 80,
            fuel = 65,
            battery = 92,
            temperature = 32,
            gear = "D",
            doorClosed = true
        )
    }
}