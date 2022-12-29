package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.request.PropertyRequest
import al.bruno.core.data.source.model.request.RequestRequest
import al.bruno.core.data.source.model.response.PageResponse
import al.bruno.core.data.source.model.response.PropertyResponse
import al.bruno.core.data.source.model.response.RequestResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface PropertyService {
    @GET("api/report/properties")
    suspend fun properties(@Query("page") page: Int, @Query("size") size: Int, @QueryMap query: Map<String, String>) : Response<PageResponse<List<PropertyResponse>>>

    @GET("api/report/requests")
    suspend fun requests(@Query("page") page: Int, @Query("size") size: Int, @QueryMap query: Map<String, String>) : Response<PageResponse<List<RequestResponse>>>

    @POST("api/properties")
    suspend fun property(@Body propertyRequest: PropertyRequest) : Response<Int>

    @POST("api/requests")
    suspend fun request(@Body requestRequest: RequestRequest) : Response<Int>

    @DELETE("api/properties/{id}")
    suspend fun deleteProperty(@Path("id") id: Long) : Response<ResponseBody>

    @DELETE("api/requests/{id}")
    suspend fun deleteRequest(@Path("id") id: Long) : Response<ResponseBody>
}