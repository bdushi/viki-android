package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.model.request.RequestRequest
import al.bruno.core.data.source.remote.RequestRemoteDataSource
import javax.inject.Inject

class RequestRepository @Inject constructor(
    private val requestDataSource: RequestRemoteDataSource)
{
    suspend fun request(requestRequest: RequestRequest): Result<Int> {
        return try {
            val response = requestDataSource.request(requestRequest)
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
    suspend fun deleteRequest(id: Long) : Result<Boolean> {
        return try {
            val response = requestDataSource.deleteRequest(id)
            if (response.isSuccessful) {
                Result.Success(response.isSuccessful)
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }
}