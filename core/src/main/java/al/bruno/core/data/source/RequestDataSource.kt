package al.bruno.core.data.source

import al.bruno.core.data.source.model.request.RequestRequest
import retrofit2.Response

interface RequestDataSource {
    suspend fun request(requestRequest: RequestRequest) : Response<Int>
    suspend fun deleteRequest(id: Long) : Response<Int>
}