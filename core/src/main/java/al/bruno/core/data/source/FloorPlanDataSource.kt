package al.bruno.core.data.source

import al.bruno.core.data.source.model.FloorPlan
import retrofit2.Response

interface FloorPlanDataSource {
    suspend fun florPlans() : Response<List<FloorPlan>>
}