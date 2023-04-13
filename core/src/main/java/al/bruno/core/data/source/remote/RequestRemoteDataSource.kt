package al.bruno.core.data.source.remote

import al.bruno.core.data.source.RequestDataSource
import al.bruno.core.data.source.model.request.RequestRequest
import al.bruno.core.data.source.remote.service.RequestService
import retrofit2.Response
import javax.inject.Inject

class RequestRemoteDataSource @Inject constructor(private val requestService: RequestService): RequestDataSource {
    override suspend fun request(requestRequest: RequestRequest): Response<Int> {
        return requestService.request(requestRequest = requestRequest)
    }

    override suspend fun deleteRequest(id: Long): Response<Int> {
        return requestService.deleteRequest(id = id)
    }
}