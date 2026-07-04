package com.ujjwal.vehicledashboard.di

import com.ujjwal.vehicledashboard.data.VehicleRepository
import com.ujjwal.vehicledashboard.datasource.CarPropertyDataSource
import com.ujjwal.vehicledashboard.datasource.FakeVehicleDataSource
import com.ujjwal.vehicledashboard.datasource.VehicleDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideVehicleDataSource(
        carPropertyDataSource: CarPropertyDataSource
    ): VehicleDataSource {
        return carPropertyDataSource
    }

    @Provides
    @Singleton
    fun provideVehicleRepository(
        dataSource: VehicleDataSource
    ): VehicleRepository {
        return VehicleRepository(dataSource as CarPropertyDataSource)
    }
}