package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.Unit
import retrofit2.Response
import retrofit2.http.GET

interface UnitService {
    @GET("api/units")
    suspend fun units() : Response<List<Unit>>
}