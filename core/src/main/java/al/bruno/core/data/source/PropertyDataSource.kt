package al.bruno.core.data.source

import al.bruno.core.data.source.model.request.PropertyRequest
import al.bruno.core.data.source.model.request.RequestRequest
import al.bruno.core.data.source.model.response.PageResponse
import al.bruno.core.data.source.model.response.PropertyResponse
import al.bruno.core.data.source.model.response.RequestResponse
import okhttp3.ResponseBody
import retrofit2.Response

interface PropertyDataSource {
    suspend fun properties(page: Int, size: Int, type: String?, searchQuery: CharSequence?) : Response<PageResponse<List<PropertyResponse>>>
    suspend fun requests(page: Int, size: Int, type: String?, searchQuery: CharSequence?) : Response<PageResponse<List<RequestResponse>>>
    suspend fun property(propertyRequest: PropertyRequest) : Response<Int>
    suspend fun request(requestRequest: RequestRequest) : Response<Int>
    suspend fun deleteProperty(id: Long) : Response<ResponseBody>
    suspend fun deleteRequest(id: Long) : Response<ResponseBody>
}