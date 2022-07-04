package al.viki.core

import al.viki.core.remote.AuthRemoteDataSource
import al.viki.core.local.AuthLocalDataSource
import al.viki.core.request.model.AuthRequest
import al.viki.core.response.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) {

    suspend fun auth(authRequest: AuthRequest): al.bruno.core.Result<AuthResponse> {
        return try {
            val response = authRemoteDataSource.auth(authRequest)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                authLocalDataSource.token(body.accessToken)
                al.bruno.core.Result.Success(body)
            } else if (response.code() == 401) {
                al.bruno.core.Result.Unauthorized
            } else {
                al.bruno.core.Result.Error(response.message())
            }
        } catch (ex: Exception) {
            al.bruno.core.Result.Error(ex.message)
        }
    }

    suspend fun verification(): Response<ResponseBody> {
        return authRemoteDataSource.verification()
    }

    fun token(): Flow<String?> {
        return authLocalDataSource.token()
    }

    suspend fun token(token: String) {
        return authLocalDataSource.token(token = token)
    }

    suspend fun clear() {
        return authLocalDataSource.clear()
    }
}