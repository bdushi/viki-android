package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.model.response.CityResponse
import al.bruno.core.data.source.remote.CityRemoteDataSource
import javax.inject.Inject

class CityRepository @Inject constructor(private val cityDataSource: CityRemoteDataSource) {
    suspend fun cities() : Result<List<CityResponse>> {
        return try {
            val response = cityDataSource.cities()
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