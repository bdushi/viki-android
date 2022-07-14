package al.bruno.core.data.source

import al.bruno.core.data.source.remote.PropertyRemoteDataSource
import al.bruno.core.Result
import al.bruno.core.data.source.model.request.PropertyRequest
import al.bruno.core.data.source.model.response.PropertyPageResponse
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class PropertyRepository @Inject constructor(
    private val propertyRemoteDataSource: PropertyRemoteDataSource) {

    suspend fun properties(page: Int, size: Int): Result<PropertyPageResponse> {
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

    suspend fun properties(propertyRequest: PropertyRequest): Result<Int> {
        return try {
            val response = propertyRemoteDataSource.properties(propertyRequest)
            if (response.isSuccessful) {
                Result.Success(response.code())
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