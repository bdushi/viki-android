package al.viki.core

import al.viki.core.request.model.AuthRequest
import al.viki.core.response.model.AuthResponse
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response

interface AuthDataSource {
    suspend fun auth(authRequest: AuthRequest): Response<AuthResponse>
    suspend fun verification() : Response<ResponseBody>
    suspend fun token(): Flow<Preferences>
    suspend fun token(token: String)
    suspend fun clear()
}