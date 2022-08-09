package al.viki.core

import al.bruno.core.Result
import al.viki.core.model.User
import al.viki.core.remote.RegistrationRemoteDataSource
import javax.inject.Inject

class RegistrationRepository @Inject constructor(private val registrationRemoteDataSource: RegistrationRemoteDataSource) {
    suspend fun register(user: User): Result<User> {
        return try {
            val response = registrationRemoteDataSource.register(user = user)
            val body = response.body()
            if (response.isSuccessful && body != null) {
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