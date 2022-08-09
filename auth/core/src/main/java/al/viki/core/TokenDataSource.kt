package al.viki.core

import al.viki.core.model.response.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Response

interface TokenDataSource {
    suspend fun resetPassword(email: String): Response<ResponseBody>
    suspend fun validateToken(token: String): Response<AuthResponse>
}