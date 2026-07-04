package com.ujjwal.vehicledashboard.data

import com.ujjwal.vehicledashboard.datasource.CarPropertyDataSource
import com.ujjwal.vehicledashboard.model.VehicleState
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VehicleRepository @Inject constructor(
    private val dataSource: CarPropertyDataSource
) {

    val vehicleState: StateFlow<VehicleState>
        get() = dataSource.vehicleState
}