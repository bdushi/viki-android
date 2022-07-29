package al.viki.core

import al.bruno.core.Result
import al.viki.core.local.AuthLocalDataSource
import al.viki.core.remote.TokenRemoteDataSource
import al.viki.core.response.model.AuthResponse
import javax.inject.Inject

class TokeRepository @Inject constructor(
    private val tokenRemoteDataSource: TokenRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) {

    suspend fun resetPassword(email: String): Result<Boolean>{
        return try {
            val response = tokenRemoteDataSource.resetPassword(email)
            if (response.isSuccessful) {
                Result.Success(response.isSuccessful)
            } else if (response.code() == 401) {
                Result.Unauthorized
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }

    suspend fun validateToken(token: String): Result<AuthResponse> {
        return try {
            val response = tokenRemoteDataSource.validateToken(token)
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
}