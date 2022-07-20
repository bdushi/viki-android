package al.viki.core

import al.viki.core.remote.AuthRemoteDataSource
import al.viki.core.local.AuthLocalDataSource
import al.viki.core.request.model.AuthRequest
import al.viki.core.response.model.AuthResponse
import al.bruno.core.Result
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) {

    suspend fun auth(authRequest: AuthRequest): Result<AuthResponse> {
        return try {
            val response = authRemoteDataSource.auth(authRequest)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                authLocalDataSource.token(body.accessToken)
                Result.Success(body)
            } else if (response.code() == 401) {
                Result.Unauthorized
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }

    suspend fun verification(): Response<ResponseBody> {
        return authRemoteDataSource.verification()
    }

    suspend fun token(): Flow<Preferences> {
        return authLocalDataSource.token()
    }

    suspend fun clear() {
        return authLocalDataSource.clear()
    }
}