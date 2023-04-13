package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.request.RequestRequest
import retrofit2.Response
import retrofit2.http.*

interface RequestService {
    @POST("api/requests")
    suspend fun request(@Body requestRequest: RequestRequest) : Response<Int>

    @DELETE("api/requests/{id}")
    suspend fun deleteRequest(@Path("id") id: Long) : Response<Int>
}