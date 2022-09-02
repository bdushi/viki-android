package al.viki.core.di

import al.viki.core.remote.service.AuthService
import al.viki.core.remote.service.RegistrationService
import al.viki.core.remote.service.TokenService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class AuthModule {
    @Provides
    @Singleton
    fun authService(retrofit: Retrofit): AuthService = retrofit.create(AuthService::class.java)

    @Provides
    @Singleton
    fun registrationService(retrofit: Retrofit): RegistrationService = retrofit.create(RegistrationService::class.java)

    @Provides
    @Reusable
    fun tokenService(retrofit: Retrofit): TokenService = retrofit.create(TokenService::class.java)
}