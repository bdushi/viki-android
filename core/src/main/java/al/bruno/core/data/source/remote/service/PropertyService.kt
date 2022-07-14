package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.request.PropertyRequest
import al.bruno.core.data.source.model.response.PropertyPageResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface PropertyService {
    @GET("api/report")
    suspend fun properties(@Query("page") page: Int, @Query("size") size: Int) : Response<PropertyPageResponse>

    @POST("api/properties")
    suspend fun properties(@Body propertyRequest: PropertyRequest) : Response<ResponseBody>
}