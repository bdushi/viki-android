package al.viki.core.remote.service

import al.bruno.core.data.source.model.response.ValidationResponse
import al.viki.core.model.request.UserRegister
import al.viki.core.model.response.AuthResponse
import retrofit2.Response
import retrofit2.http.*

interface RegistrationService {
    @POST("/api/accounts/{token}")
    suspend fun register(@Body user: UserRegister, @Path("token") token: String) : Response<AuthResponse>

    @GET("/api/accounts/validateToken")
    suspend fun validateToken(@Query("token") token: String): Response<ValidationResponse>
}