package al.viki.core.remote

import al.viki.core.AuthDataSource
import al.viki.core.remote.service.AuthService
import al.viki.core.model.request.AuthRequest
import al.viki.core.model.response.AuthResponse
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(private val authService: AuthService) : AuthDataSource {
    override suspend fun auth(authRequest: AuthRequest): Response<AuthResponse> {
        return authService.auth(authRequest = authRequest)
    }

    override fun token(): Flow<String?> {
        TODO("Not yet implemented")
    }

    override suspend fun token(accessToken: String, refreshToken: String) {
        TODO("Not yet implemented")
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }


    override suspend fun newPassword(password: String): Response<ResponseBody> {
        return authService.newPassword(password)
    }

    override suspend fun changePassword(newPassword: String): Response<ResponseBody> {
        return authService.newPassword(newPassword)
    }
}