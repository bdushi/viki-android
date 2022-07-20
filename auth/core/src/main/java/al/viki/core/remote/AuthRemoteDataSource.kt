package al.viki.core.remote

import al.viki.core.AuthDataSource
import al.viki.core.remote.service.AuthService
import al.viki.core.request.model.AuthRequest
import al.viki.core.response.model.AuthResponse
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class AuthRemoteDataSource @Inject constructor(private val authService: AuthService) : AuthDataSource {
    override suspend fun auth(authRequest: AuthRequest): Response<AuthResponse> {
        return authService.auth(authRequest = authRequest)
    }

    override suspend fun verification(): Response<ResponseBody> {
        return authService.verification()
    }

    override suspend fun token(): Flow<Preferences> {
        TODO("Not yet implemented")
    }


    override suspend fun token(token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }
}