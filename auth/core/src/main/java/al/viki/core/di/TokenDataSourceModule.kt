package al.viki.core.di

import al.viki.core.AuthDataSource
import al.viki.core.TokenDataSource
import al.viki.core.local.AuthLocalDataSource
import al.viki.core.remote.AuthRemoteDataSource
import al.viki.core.remote.TokenRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TokenDataSourceModule {
    @Binds
    abstract fun provideTokenRemoteDataSource(tokenRemoteDataSource: TokenRemoteDataSource): TokenDataSource

    @Binds
    abstract fun provideAuthRemoteDataSource(authDataSource: AuthRemoteDataSource): AuthDataSource

    @Binds
    abstract fun provideAuthLocalDataSource(authDataSource: AuthLocalDataSource): AuthDataSource
}