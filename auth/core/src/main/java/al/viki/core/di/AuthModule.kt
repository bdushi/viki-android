package al.viki.core.di

import al.viki.core.remote.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class AuthModule {
    @Provides
    @Reusable
    fun authService(retrofit: Retrofit): AuthService = retrofit.create(AuthService::class.java)
}