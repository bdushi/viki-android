package al.viki.core

import al.bruno.core.Result
import al.bruno.core.interceptor.AuthorizationInterceptor
import al.viki.core.local.AuthLocalDataSource
import al.viki.core.remote.TokenRemoteDataSource
import al.viki.core.model.response.AuthResponse
import javax.inject.Inject

class TokeRepository @Inject constructor(
    private val tokenRemoteDataSource: TokenRemoteDataSource,
    private val authorizationInterceptor: AuthorizationInterceptor
) {

    suspend fun resetPassword(email: String): Result<Boolean>{
        return try {
            val response = tokenRemoteDataSource.resetPassword(email)
            if (response.isSuccessful) {
                Result.Success(response.isSuccessful)
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
                authorizationInterceptor.token = body.accessToken
                Result.Success(body)
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }
}