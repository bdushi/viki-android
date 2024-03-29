package al.viki.core.remote.service

import al.viki.core.model.request.AuthRequest
import al.viki.core.model.response.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface AuthService {
    @POST("login")
    suspend fun auth(@Body authRequest: AuthRequest) : Response<AuthResponse>

    @FormUrlEncoded
    @POST("api/users/newPassword")
    suspend fun newPassword(@Field("password") password: String): Response<ResponseBody>

    @FormUrlEncoded
    @POST("api/users/changePassword")
    suspend fun changePassword(@Field("newPassword") newPassword: String): Response<ResponseBody>
}