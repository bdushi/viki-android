package al.bruno.core.data.source.remote

import al.bruno.core.data.source.RequestDataSource
import al.bruno.core.data.source.model.request.RequestRequest
import al.bruno.core.data.source.remote.service.RequestService
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class RequestRemoteDataSource @Inject constructor(private val requestService: RequestService): RequestDataSource {
    override suspend fun request(requestRequest: RequestRequest): Response<Int> {
        return requestService.request(requestRequest = requestRequest)
    }

    override suspend fun deleteRequest(id: Long): Response<ResponseBody> {
        return requestService.deleteRequest(id = id)
    }
}