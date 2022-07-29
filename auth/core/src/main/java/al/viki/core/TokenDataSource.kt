package al.viki.core

import al.viki.core.response.model.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Response

interface TokenDataSource {
    suspend fun resetPassword(email: String): Response<ResponseBody>
    suspend fun validateToken(token: String): Response<AuthResponse>
}