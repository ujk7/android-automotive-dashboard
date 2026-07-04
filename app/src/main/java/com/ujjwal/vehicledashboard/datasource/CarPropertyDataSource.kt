package com.ujjwal.vehicledashboard.datasource

import com.ujjwal.vehicledashboard.automotive.AutomotiveManager
import com.ujjwal.vehicledashboard.automotive.VehiclePropertyIds
import com.ujjwal.vehicledashboard.automotive.callback.VehiclePropertyCallback
import com.ujjwal.vehicledashboard.model.VehiclePropertyValue
import com.ujjwal.vehicledashboard.model.VehicleState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CarPropertyDataSource @Inject constructor(
    private val automotiveManager: AutomotiveManager
) : VehicleDataSource, VehiclePropertyCallback {

    private val _vehicleState = MutableStateFlow(
        VehicleState(
            speed = 0,
            fuel = 100,
            battery = 100,
            temperature = 28,
            gear = "D",
            doorClosed = true
        )
    )

    val vehicleState: StateFlow<VehicleState> =
        _vehicleState.asStateFlow()

    init {
        automotiveManager.registerCallback(this)
        automotiveManager.startVehicleSimulation()
    }

    override fun onPropertyChanged(
        propertyValue: VehiclePropertyValue<*>
    ) {
        when (propertyValue.propertyId) {

            VehiclePropertyIds.SPEED -> {
                val speed = propertyValue.value as Int
                _vehicleState.value =
                    _vehicleState.value.copy(speed = speed)
            }

            VehiclePropertyIds.FUEL -> {
                val fuel = propertyValue.value as Int
                _vehicleState.value =
                    _vehicleState.value.copy(fuel = fuel)
            }

            VehiclePropertyIds.BATTERY -> {
                val battery = propertyValue.value as Int
                _vehicleState.value =
                    _vehicleState.value.copy(battery = battery)
            }
        }
    }

    override fun getVehicleState(): VehicleState {
        return _vehicleState.value
    }
}