package al.bruno.core.data.source

import al.bruno.core.data.source.remote.PropertyRemoteDataSource
import al.bruno.core.Result
import al.bruno.core.data.source.model.request.PropertyRequest
import al.bruno.core.data.source.model.request.RequestRequest
import al.bruno.core.data.source.model.response.PropertyPageResponse
import al.bruno.core.data.source.model.response.PropertyResponse
import javax.inject.Inject

class PropertyRepository @Inject constructor(
    private val propertyRemoteDataSource: PropertyRemoteDataSource) {

    suspend fun properties(page: Int, size: Int): Result<PropertyPageResponse<List<PropertyResponse>>> {
        return try {
            val response = propertyRemoteDataSource.properties(page, size)
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

    suspend fun property(propertyRequest: PropertyRequest): Result<Int> {
        return try {
            val response = propertyRemoteDataSource.property(propertyRequest)
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

    suspend fun request(requestRequest: RequestRequest): Result<Int> {
        return try {
            val response = propertyRemoteDataSource.request(requestRequest)
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