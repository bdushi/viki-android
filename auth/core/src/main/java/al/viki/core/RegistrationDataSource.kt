package al.viki.core

import al.viki.core.model.User
import al.bruno.core.data.source.model.response.ValidationResponse
import al.viki.core.model.response.AuthResponse
import retrofit2.Response
interface RegistrationDataSource {
    suspend fun register(user: User, token: String) : Response<AuthResponse>

    suspend fun validateToken(token: String): Response<ValidationResponse>
}