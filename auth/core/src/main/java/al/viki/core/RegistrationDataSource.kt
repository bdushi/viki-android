package al.viki.core

import al.viki.core.model.User
import retrofit2.Response

interface RegistrationDataSource {
    suspend fun register(user: User) : Response<User>
}