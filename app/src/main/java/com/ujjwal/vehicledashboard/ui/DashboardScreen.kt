package com.ujjwal.vehicledashboard.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ujjwal.vehicledashboard.model.VehicleState
import com.ujjwal.vehicledashboard.ui.components.Speedometer

@Composable
fun DashboardScreen(
    state: VehicleState
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text(
            text = "Vehicle Dashboard",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {

            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Speedometer(
                        speed = state.speed
                    )
                }
            }

            item {
                VehicleCard("Fuel", "${state.fuel}%")
            }

            item {
                VehicleCard("Battery", "${state.battery}%")
            }

            item {
                VehicleCard("Temperature", "${state.temperature}°C")
            }

            item {
                VehicleCard("Gear", state.gear)
            }

            item {
                VehicleCard(
                    "Door",
                    if (state.doorClosed) "Closed" else "Open"
                )
            }
        }
    }
}

@Composable
fun VehicleCard(
    title: String,
    value: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = "$title : $value",
            modifier = Modifier.padding(16.dp)
        )
    }
}