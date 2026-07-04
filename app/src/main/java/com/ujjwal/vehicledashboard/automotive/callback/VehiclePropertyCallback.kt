package com.ujjwal.vehicledashboard.automotive.callback

import com.ujjwal.vehicledashboard.model.VehiclePropertyValue

interface VehiclePropertyCallback {

    fun onPropertyChanged(
        propertyValue: VehiclePropertyValue<*>
    )
}