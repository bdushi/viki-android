package al.viki.core.di

import al.viki.core.RegistrationDataSource
import al.viki.core.remote.RegistrationRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RegistrationDataSourceModule {
    @Binds
    abstract fun provideRegistrationRemoteDataSource(registrationRemoteDataSource: RegistrationRemoteDataSource): RegistrationDataSource
}
