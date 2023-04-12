package al.viki.core

import al.bruno.core.Result
import al.viki.core.model.User
import al.viki.core.remote.UserRemoteDataSource
import javax.inject.Inject

class UserRepository @Inject constructor(private val userRemoteDataSource: UserRemoteDataSource) {
    suspend fun user(): Result<User> = try {
        val response = userRemoteDataSource.user()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            Result.Success(body)
        } else {
            Result.Error(response.message())
        }
    } catch (ex: Exception) {
        Result.Error(ex.message)
    }
}