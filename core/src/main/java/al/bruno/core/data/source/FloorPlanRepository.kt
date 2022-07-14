package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.model.FloorPlan
import al.bruno.core.data.source.remote.FloorPlanRemoteDataSource
import javax.inject.Inject

class FloorPlanRepository @Inject constructor(private val floorPlanDataSource: FloorPlanRemoteDataSource) {
    suspend fun floorPlans() : Result<List<FloorPlan>> {
        return try {
            val response = floorPlanDataSource.florPlans()
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