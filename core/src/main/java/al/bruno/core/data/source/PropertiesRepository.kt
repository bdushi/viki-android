package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.asResponse
import al.bruno.core.data.source.model.response.PageResponse
import al.bruno.core.data.source.model.response.PropertiesResponse
import al.bruno.core.data.source.remote.PropertiesRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class PropertiesRepository  @Inject constructor(
    private val propertiesRemoteDataSource: PropertiesRemoteDataSource) {

    suspend fun properties(
        page: Int,
        size: Int,
        query: Map<String, String>
    ): Result<PageResponse<List<PropertiesResponse>>> {
        return try {
            val response = propertiesRemoteDataSource.properties(page, size, query)
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

    suspend fun properties(id: Long) : Result<PropertiesResponse> {
        return try {
            val response = propertiesRemoteDataSource.properties(id)
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

    suspend fun properties(
        query: Map<String, String>
    ) = propertiesRemoteDataSource
        .properties(query)
        .asResponse()
}