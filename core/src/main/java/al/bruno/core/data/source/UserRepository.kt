package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.model.User
import al.bruno.core.data.source.remote.UserRemoteDataSource
import javax.inject.Inject

class UserRepository @Inject constructor(private val userRemoteDataSource: UserRemoteDataSource){
    suspend fun user() : Result<User> {
        return try {
            val response = userRemoteDataSource.user()
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