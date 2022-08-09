package al.viki.core.remote.service

import al.viki.core.model.response.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface TokenService {
    @GET("api/resetToken/resetPassword")
    suspend fun resetPassword(@Query("email") email: String): Response<ResponseBody>

    @GET("api/resetToken/validateToken")
    suspend fun validateToken(@Query("token") token: String): Response<AuthResponse>
}