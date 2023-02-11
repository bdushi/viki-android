package al.bruno.core.data.source

import al.bruno.core.data.source.remote.PropertyRemoteDataSource
import al.bruno.core.Result
import al.bruno.core.data.source.model.request.PropertyRequest
import javax.inject.Inject

class PropertyRepository @Inject constructor(
    private val propertyRemoteDataSource: PropertyRemoteDataSource)
{
    suspend fun property(propertyRequest: PropertyRequest): Result<Int> {
        return try {
            val response = propertyRemoteDataSource.property(propertyRequest)
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

    suspend fun deleteProperty(id: Long) : Result<Boolean> {
        return try {
            val response = propertyRemoteDataSource.deleteProperty(id)
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