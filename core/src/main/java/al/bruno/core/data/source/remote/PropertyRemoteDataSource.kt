package al.bruno.core.data.source.remote

import al.bruno.core.data.source.PropertyDataSource
import al.bruno.core.data.source.model.response.PropertyPageResponse
import al.bruno.core.data.source.model.response.PropertyResponse
import al.bruno.core.data.source.remote.service.PropertyService
import al.viki.domain.Property
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class PropertyRemoteDataSource @Inject constructor(private val propertyService: PropertyService) : PropertyDataSource {
    override suspend fun properties(page: Int, size: Int): Response<PropertyPageResponse> {
        return propertyService.properties(page = page, size = size)
    }

    override suspend fun properties(property: Property): Response<ResponseBody> {
        return propertyService.properties(property)
    }
}