package al.bruno.core.data.source.remote

import al.bruno.core.data.source.PropertyDataSource
import al.bruno.core.data.source.model.request.PropertyRequest
import al.bruno.core.data.source.model.request.RequestRequest
import al.bruno.core.data.source.model.response.PageResponse
import al.bruno.core.data.source.model.response.PropertyResponse
import al.bruno.core.data.source.model.response.RequestResponse
import al.bruno.core.data.source.remote.service.PropertyService
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class PropertyRemoteDataSource @Inject constructor(private val propertyService: PropertyService) : PropertyDataSource {
    override suspend fun properties(
        page: Int,
        size: Int,
        query: Map<String, String>
    ): Response<PageResponse<List<PropertyResponse>>> {
        return propertyService.properties(page = page, size = size, query = query)
    }

    override suspend fun requests(
        page: Int,
        size: Int,
        query: Map<String, String>
    ): Response<PageResponse<List<RequestResponse>>> {
        return propertyService.requests(page = page, size = size, query = query)
    }

    override suspend fun property(propertyRequest: PropertyRequest): Response<Int> {
        return propertyService.property(propertyRequest)
    }

    override suspend fun property(id: Long): Response<PropertyResponse> {
        return propertyService.property(id)
    }

    override suspend fun request(requestRequest: RequestRequest): Response<Int> {
        return propertyService.request(requestRequest)
    }

    override suspend fun request(id: Long): Response<RequestResponse> {
        return propertyService.request(id)
    }

    override suspend fun deleteProperty(id: Long): Response<ResponseBody> {
        return propertyService.deleteProperty(id)
    }

    override suspend fun deleteRequest(id: Long): Response<ResponseBody> {
        return propertyService.deleteRequest(id)
    }
}