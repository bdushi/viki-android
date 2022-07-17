package al.bruno.core.data.source.remote

import al.bruno.core.data.source.PropertyDataSource
import al.bruno.core.data.source.model.request.PropertyRequest
import al.bruno.core.data.source.model.response.PropertyPageResponse
import al.bruno.core.data.source.remote.service.PropertyService
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class PropertyRemoteDataSource @Inject constructor(private val propertyService: PropertyService) : PropertyDataSource {
    override suspend fun properties(page: Int, size: Int): Response<PropertyPageResponse> {
        return propertyService.properties(page = page, size = size)
    }

    override suspend fun properties(propertyRequest: PropertyRequest): Response<Int> {
        return propertyService.properties(propertyRequest)
    }
}