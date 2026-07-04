package com.ujjwal.vehicledashboard.automotive

import com.ujjwal.vehicledashboard.automotive.callback.VehiclePropertyCallback
import com.ujjwal.vehicledashboard.model.VehiclePropertyValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AutomotiveManager @Inject constructor() {

    private var callback: VehiclePropertyCallback? = null

    fun registerCallback(
        callback: VehiclePropertyCallback
    ) {
        this.callback = callback
    }

    fun startVehicleSimulation() {

        CoroutineScope(Dispatchers.Default).launch {

            var speed = 0
            var fuel = 100
            var battery = 100

            while (true) {

                delay(1000)

                speed += 5
                if (speed > 180) speed = 0

                fuel--
                if (fuel < 0) fuel = 100

                battery--
                if (battery < 0) battery = 100

                callback?.onPropertyChanged(
                    VehiclePropertyValue(
                        propertyId = VehiclePropertyIds.SPEED,
                        timestamp = System.currentTimeMillis(),
                        value = speed
                    )
                )

                callback?.onPropertyChanged(
                    VehiclePropertyValue(
                        propertyId = VehiclePropertyIds.FUEL,
                        timestamp = System.currentTimeMillis(),
                        value = fuel
                    )
                )

                callback?.onPropertyChanged(
                    VehiclePropertyValue(
                        propertyId = VehiclePropertyIds.BATTERY,
                        timestamp = System.currentTimeMillis(),
                        value = battery
                    )
                )
            }
        }
    }
}