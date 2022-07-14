package al.bruno.core.data.source.remote

import al.bruno.core.data.source.FloorPlanDataSource
import al.bruno.core.data.source.model.FloorPlan
import al.bruno.core.data.source.remote.service.FloorPlanService
import retrofit2.Response
import javax.inject.Inject

class FloorPlanRemoteDataSource @Inject constructor(private val florPlanService: FloorPlanService): FloorPlanDataSource {
    override suspend fun florPlans(): Response<List<FloorPlan>> {
        return florPlanService.florPlans()
    }
}