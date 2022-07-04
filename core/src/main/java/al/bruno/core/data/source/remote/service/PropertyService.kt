package al.bruno.core.data.source.remote.service

import al.viki.domain.Property
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface PropertyService {
    @GET("property")
    suspend fun properties() : Response<List<Property>>

    @POST("property")
    suspend fun properties(@Body property: Property) : Response<ResponseBody>
}