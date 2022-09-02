package al.bruno.core.data.source

import al.bruno.core.data.source.remote.PropertyRemoteDataSource
import al.bruno.core.Result
import al.bruno.core.data.source.model.request.PropertyRequest
import al.bruno.core.data.source.model.request.RequestRequest
import al.bruno.core.data.source.model.response.PageResponse
import al.bruno.core.data.source.model.response.PropertyResponse
import al.bruno.core.data.source.model.response.RequestResponse
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class PropertyRepository @Inject constructor(
    private val propertyRemoteDataSource: PropertyRemoteDataSource) {

    suspend fun properties(
        page: Int,
        size: Int,
        type: String?,
        searchQuery: CharSequence?
    ): Result<PageResponse<List<PropertyResponse>>> {
        return try {
            val response = propertyRemoteDataSource.properties(page, size, type, searchQuery)
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

    suspend fun requests(
        page: Int,
        size: Int,
        type: String?,
        searchQuery: CharSequence?
    ): Result<PageResponse<List<RequestResponse>>> {
        return try {
            val response = propertyRemoteDataSource.requests(page, size, type, searchQuery)
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

    suspend fun request(requestRequest: RequestRequest): Result<Int> {
        return try {
            val response = propertyRemoteDataSource.request(requestRequest)
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
    suspend fun deleteRequest(id: Long) : Result<Boolean> {
        return try {
            val response = propertyRemoteDataSource.deleteRequest(id)
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