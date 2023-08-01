package al.viki.core

import al.viki.core.remote.AuthRemoteDataSource
import al.viki.core.local.AuthLocalDataSource
import al.viki.core.model.request.AuthRequest
import al.viki.core.model.response.AuthResponse
import al.bruno.core.Result
import kotlinx.coroutines.flow.Flow
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
                authLocalDataSource.token(
                    accessToken = body.accessToken,
                    refreshToken = body.refreshToken
                )
                Result.Success(body)
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }

    suspend fun newPassword(password: String): Result<Boolean> {
        return try {
            val response = authRemoteDataSource.newPassword(password = password)
            if (response.isSuccessful) {
                Result.Success(response.isSuccessful)
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }


    suspend fun changePassword(newPassword: String): Result<Boolean> {
        return try {
            val response = authRemoteDataSource.changePassword(newPassword)
            if (response.isSuccessful) {
                Result.Success(response.isSuccessful)
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }

    fun token(): Flow<String?> {
        return authLocalDataSource.token()
    }

    suspend fun clear() {
        return authLocalDataSource.clear()
    }
}