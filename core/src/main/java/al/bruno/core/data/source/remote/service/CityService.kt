package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.City
import retrofit2.Response
import retrofit2.http.GET

interface CityService {
    @GET("api/cities")
    suspend fun cities() : Response<List<City>>
}