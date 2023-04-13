package al.viki.core

import al.viki.core.model.request.AuthRequest
import al.viki.core.model.response.AuthResponse
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response

interface AuthDataSource {
    suspend fun auth(authRequest: AuthRequest): Response<AuthResponse>
    fun token(): Flow<String?>
    suspend fun token(accessToken: String, refreshToken: String)
    suspend fun clear()
    suspend fun newPassword(password: String): Response<ResponseBody>
    suspend fun changePassword(newPassword: String): Response<ResponseBody>
}