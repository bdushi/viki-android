package al.bruno.core.data.source

import al.bruno.core.data.source.remote.PropertyRemoteDataSource
import al.viki.domain.Property
import al.bruno.core.Result
import al.bruno.core.data.source.model.response.PropertyPageResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import javax.inject.Inject

class PropertyRepository @Inject constructor(
    private val propertyRemoteDataSource: PropertyRemoteDataSource) {

    suspend fun properties(page: Int, size: Int) : Result<PropertyPageResponse> {
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

    suspend fun properties(@Body property: Property) : Response<ResponseBody> {
        return propertyRemoteDataSource.properties(property)
    }
}