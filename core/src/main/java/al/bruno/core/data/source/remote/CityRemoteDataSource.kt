package al.bruno.core.data.source.remote

import al.bruno.core.data.source.CityDataSource
import al.bruno.core.data.source.model.City
import al.bruno.core.data.source.remote.service.CityService
import retrofit2.Response
import javax.inject.Inject

class CityRemoteDataSource @Inject constructor(private val cityService: CityService) : CityDataSource {
    override suspend fun cities(): Response<List<City>> {
        return cityService.cities()
    }
}