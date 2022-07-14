package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.FloorPlan
import retrofit2.Response
import retrofit2.http.GET

interface FloorPlanService {
    @GET("api/florPlans")
    suspend fun florPlans() : Response<List<FloorPlan>>
}