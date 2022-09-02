package al.viki.core.di

import al.viki.core.AuthDataSource
import al.viki.core.RegistrationDataSource
import al.viki.core.TokenDataSource
import al.viki.core.local.AuthLocalDataSource
import al.viki.core.remote.AuthRemoteDataSource
import al.viki.core.remote.RegistrationRemoteDataSource
import al.viki.core.remote.TokenRemoteDataSource
import dagger.Binds
import dagger.Module

@Module
abstract class AuthDataSourceModule {
    @Binds
    abstract fun provideAuthRemoteDataSource(authDataSource: AuthRemoteDataSource): AuthDataSource

    @Binds
    abstract fun provideAuthLocalDataSource(authDataSource: AuthLocalDataSource): AuthDataSource

    @Binds
    abstract fun provideRegistrationRemoteDataSource(registrationRemoteDataSource: RegistrationRemoteDataSource): RegistrationDataSource

    @Binds
    abstract fun provideTokenRemoteDataSource(tokenRemoteDataSource: TokenRemoteDataSource): TokenDataSource
}