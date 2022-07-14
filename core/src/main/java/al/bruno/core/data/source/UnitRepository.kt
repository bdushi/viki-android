package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.model.Unit
import al.bruno.core.data.source.remote.UnitRemoteDataSource
import javax.inject.Inject

class UnitRepository @Inject constructor(private val unitDataSource: UnitRemoteDataSource) {
    suspend fun units() : Result<List<Unit>> {
        return try {
            val response = unitDataSource.units()
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