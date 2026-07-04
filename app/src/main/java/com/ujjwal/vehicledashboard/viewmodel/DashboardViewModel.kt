package com.ujjwal.vehicledashboard.viewmodel

import androidx.lifecycle.ViewModel
import com.ujjwal.vehicledashboard.data.VehicleRepository
import com.ujjwal.vehicledashboard.model.VehicleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    repository: VehicleRepository
) : ViewModel() {

    val state: StateFlow<VehicleState> =
        repository.vehicleState
}