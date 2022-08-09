package al.viki.core.di

import al.viki.core.remote.service.RegistrationService

interface RegistrationModuleDependencies {
    fun registrationService(): RegistrationService
}