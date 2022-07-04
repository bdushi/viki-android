package al.viki.core.remote.service

import al.viki.core.request.model.AuthRequest
import al.viki.core.response.model.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {
    @POST("login")
    suspend fun auth(@Body authRequest: AuthRequest) : Response<AuthResponse>

    @GET("authenticated/verification")
    suspend fun verification() : Response<ResponseBody>
}