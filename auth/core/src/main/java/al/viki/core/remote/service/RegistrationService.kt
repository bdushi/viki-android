package al.viki.core.remote.service

import al.viki.core.model.User
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface RegistrationService {
    @POST("/api/accounts")
    suspend fun register(@Body user: User) : Response<User>

    @GET("/api/requestAccount/validateToken")
    suspend fun validateToken(@Query("token") token: String): Response<ResponseBody>
}