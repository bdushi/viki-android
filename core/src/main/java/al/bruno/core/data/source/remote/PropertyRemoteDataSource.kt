package al.bruno.core.data.source.remote

import al.bruno.core.data.source.PropertyDataSource
import al.bruno.core.data.source.remote.service.PropertyService
import al.viki.domain.Property
import okhttp3.ResponseBody
import retrofit2.Response


class PropertyRemoteDataSource constructor(private val propertyService: PropertyService) : PropertyDataSource {
    override suspend fun properties(): Response<List<Property>> {
        return propertyService.properties()
    }

    override suspend fun properties(property: Property): Response<ResponseBody> {
        return propertyService.properties(property)
    }
}