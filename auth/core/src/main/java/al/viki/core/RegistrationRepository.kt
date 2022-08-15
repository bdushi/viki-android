package al.viki.core

import al.bruno.core.Result
import al.viki.core.model.User
import al.bruno.core.data.source.model.response.ValidationResponse
import al.viki.core.local.AuthLocalDataSource
import al.viki.core.model.response.AuthResponse
import al.viki.core.remote.RegistrationRemoteDataSource
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val registrationRemoteDataSource: RegistrationRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
) {
    suspend fun register(user: User, token: String): Result<AuthResponse> {
        return try {
            val response = registrationRemoteDataSource.register(user = user, token = token)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                authLocalDataSource.token(body.accessToken)
                Result.Success(body)
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }


    suspend fun validateToken(token: String): Result<ValidationResponse> {
        return try {
            val response = registrationRemoteDataSource.validateToken(token = token)
            val responseBody = response.body()
            if (response.isSuccessful && responseBody != null) {
                Result.Success(responseBody)
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }
}