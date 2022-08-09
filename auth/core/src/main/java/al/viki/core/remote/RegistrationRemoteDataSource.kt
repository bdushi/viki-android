package al.viki.core.remote

import al.viki.core.RegistrationDataSource
import al.viki.core.model.User
import al.viki.core.remote.service.RegistrationService
import retrofit2.Response
import javax.inject.Inject

class RegistrationRemoteDataSource @Inject constructor(private val registrationService: RegistrationService) : RegistrationDataSource {
    override suspend fun register(user: User): Response<User> {
        return registrationService.register(user = user)
    }
}