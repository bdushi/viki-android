package al.bruno.core.di

import al.bruno.core.data.source.*
import al.bruno.core.data.source.remote.*
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {
    @Binds
    abstract fun providePropertyRemoteDataSource(propertyRemoteDataSource: PropertyRemoteDataSource): PropertyDataSource

    @Binds
    abstract fun provideCityRemoteDataSource(cityRemoteDataSource: CityRemoteDataSource): CityDataSource

    @Binds
    abstract fun provideCurrencyRemoteDataSource(currencyRemoteDataSource: CurrencyRemoteDataSource): CurrencyDataSource

    @Binds
    abstract fun provideFloorPlanRemoteDataSource(floorPlanRemoteDataSource: FloorPlanRemoteDataSource): FloorPlanDataSource

    @Binds
    abstract fun provideOperationRemoteDataSource(operationRemoteDataSource: OperationRemoteDataSource): OperationDataSource

    @Binds
    abstract fun providePropertyTypeRemoteDataSource(propertyTypeRemoteDataSource: PropertyTypeRemoteDataSource): PropertyTypeDataSource

    @Binds
    abstract fun provideUnitRemoteDataSource(unitRemoteDataSource: UnitRemoteDataSource): UnitDataSource

    @Binds
    abstract fun provideAuthorityRemoteDataSource(authorityRemoteDataSource: AuthorityRemoteDataSource): AuthorityDataSource

    @Binds
    abstract fun provideRequestAccountRemoteDataSource(authorityRemoteDataSource: RequestAccountRemoteDataSource): RequestAccountDataSource

    @Binds
    abstract fun provideUserRemoteDataSource(userRemoteDataSource: UserRemoteDataSource): UserDataSource

    @Binds
    abstract fun provideImageRemoteDataSource(imageRemoteDataSource: ImageRemoteDataSource): ImageDataSource



}