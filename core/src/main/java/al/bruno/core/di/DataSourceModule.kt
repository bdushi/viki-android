package al.bruno.core.di

import al.bruno.core.data.source.CityDataSource
import al.bruno.core.data.source.PropertyDataSource
import al.bruno.core.data.source.remote.CityRemoteDataSource
import al.bruno.core.data.source.remote.PropertyRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun providePropertyRemoteDataSource(propertyRemoteDataSource: PropertyRemoteDataSource): PropertyDataSource

    @Binds
    abstract fun provideCityRemoteDataSource(cityRemoteDataSource: CityRemoteDataSource): CityDataSource
}