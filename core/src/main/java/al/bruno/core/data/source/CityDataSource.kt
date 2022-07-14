package al.bruno.core.data.source

import al.bruno.core.data.source.model.City
import retrofit2.Response

interface CityDataSource {
    suspend fun cities() : Response<List<City>>
}