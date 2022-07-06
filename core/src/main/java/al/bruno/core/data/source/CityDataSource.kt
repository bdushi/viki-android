package al.bruno.core.data.source

import al.bruno.core.data.source.model.response.CityResponse
import retrofit2.Response

interface CityDataSource {
    suspend fun cities() : Response<List<CityResponse>>
}