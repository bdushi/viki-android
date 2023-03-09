package al.bruno.core.data.source.remote

import al.bruno.core.data.source.PropertyDataSource
import al.bruno.core.data.source.model.request.PropertyRequest
import al.bruno.core.data.source.remote.service.PropertyService
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class PropertyRemoteDataSource @Inject constructor(private val propertyService: PropertyService) : PropertyDataSource {
    override suspend fun property(propertyRequest: PropertyRequest): Response<Int> {
        return propertyService.property(propertyRequest = propertyRequest)
    }

    override suspend fun deleteProperty(id: Long): Response<Boolean> {
        return propertyService.deleteProperty(id = id)
    }
}