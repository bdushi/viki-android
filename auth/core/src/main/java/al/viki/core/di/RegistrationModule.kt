package al.viki.core.di

import al.viki.core.remote.service.RegistrationService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
@Module
@InstallIn(SingletonComponent::class)
class RegistrationModule {
    @Provides
    @Reusable
    fun registrationService(retrofit: Retrofit): RegistrationService = retrofit.create(RegistrationService::class.java)
}