package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.model.Authority
import al.bruno.core.data.source.remote.AuthorityRemoteDataSource
import javax.inject.Inject

class AuthorityRepository @Inject constructor(private val authorityDataSource: AuthorityRemoteDataSource) {

    suspend fun authorities() : Result<List<Authority>> {
        return try {
            val response = authorityDataSource.authorities()
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