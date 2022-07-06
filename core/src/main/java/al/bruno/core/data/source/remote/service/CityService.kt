package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.response.CityResponse
import retrofit2.Response
import retrofit2.http.GET

interface CityService {
    @GET("api/cities")
    suspend fun cities() : Response<List<CityResponse>>
}