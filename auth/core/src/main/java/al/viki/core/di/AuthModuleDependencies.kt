package al.viki.core.di

import al.viki.core.remote.service.AuthService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AuthModuleDependencies {
    fun authService(): AuthService
}