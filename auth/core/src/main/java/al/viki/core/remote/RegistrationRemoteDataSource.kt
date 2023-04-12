package al.viki.core.remote

import al.viki.core.RegistrationDataSource
import al.viki.core.model.User
import al.viki.core.model.request.UserRegister
import al.viki.core.remote.service.RegistrationService
import javax.inject.Inject

class RegistrationRemoteDataSource @Inject constructor(private val registrationService: RegistrationService) : RegistrationDataSource {
    override suspend fun register(user: UserRegister, token: String) = registrationService.register(user = user, token = token)
    override suspend fun validateToken(token: String) = registrationService.validateToken(token = token)
}