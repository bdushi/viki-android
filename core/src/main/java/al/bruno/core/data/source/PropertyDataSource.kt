package al.bruno.core.data.source

import al.bruno.core.data.source.model.request.PropertyRequest
import retrofit2.Response

interface PropertyDataSource {
    suspend fun property(propertyRequest: PropertyRequest) : Response<Int>
    suspend fun deleteProperty(id: Long) : Response<Int>
}