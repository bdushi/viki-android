package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.asResponse
import al.bruno.core.data.source.model.request.PropertyRequest
import al.bruno.core.data.source.remote.PropertyRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PropertyRepository @Inject constructor(
    private val propertyRemoteDataSource: PropertyRemoteDataSource
) {
    suspend fun property(propertyRequest: PropertyRequest): Flow<Result<Int>> =
        propertyRemoteDataSource.property(propertyRequest).asResponse()

    suspend fun deleteProperty(id: Long): Result<Boolean> {
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