package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.response.PropertyPageResponse
import al.bruno.core.data.source.model.response.PropertyResponse
import al.viki.domain.Property
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface PropertyService {
    @GET("api/report")
    suspend fun properties(@Query("page") page: Int, @Query("size") size: Int) : Response<PropertyPageResponse>

    @POST("property")
    suspend fun properties(@Body property: Property) : Response<ResponseBody>
}