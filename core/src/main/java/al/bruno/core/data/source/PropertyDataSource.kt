package al.bruno.core.data.source

import al.bruno.core.data.source.model.request.PropertyRequest
import al.bruno.core.data.source.model.request.RequestRequest
import al.bruno.core.data.source.model.response.PropertyPageResponse
import al.bruno.core.data.source.model.response.PropertyResponse
import al.bruno.core.data.source.model.response.RequestResponse
import okhttp3.ResponseBody
import retrofit2.Response

interface PropertyDataSource {
    suspend fun properties(page: Int, size: Int) : Response<PropertyPageResponse<List<PropertyResponse>>>
    suspend fun requests(page: Int, size: Int) : Response<PropertyPageResponse<List<RequestResponse>>>
    suspend fun property(propertyRequest: PropertyRequest) : Response<Int>
    suspend fun request(requestRequest: RequestRequest) : Response<Int>
}