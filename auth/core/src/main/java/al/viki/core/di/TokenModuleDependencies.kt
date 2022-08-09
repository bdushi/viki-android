package al.viki.core.di

import al.viki.core.remote.service.TokenService

interface TokenModuleDependencies {
    fun tokenService(): TokenService
}