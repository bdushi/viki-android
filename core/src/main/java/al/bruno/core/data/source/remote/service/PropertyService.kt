package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.request.PropertyRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface PropertyService {
    @POST("api/properties")
    suspend fun property(@Body propertyRequest: PropertyRequest) : Response<Int>

    @DELETE("api/properties/{id}")
    suspend fun deleteProperty(@Path("id") id: Long) : Response<ResponseBody>
}