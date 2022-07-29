package al.viki.core.di

import al.viki.core.remote.service.TokenService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class TokenModule {
    @Provides
    @Reusable
    fun tokenService(retrofit: Retrofit): TokenService = retrofit.create(TokenService::class.java)
}