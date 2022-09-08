package al.bruno.core.data.source.remote.service

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ImageService {
    @POST
    @Multipart
    suspend fun uploadImage(@Url url:String, @Part file: MultipartBody.Part): Response<ResponseBody>

    @GET
    suspend fun images(@Url url:String): Response<Set<String>>

    @GET
    suspend fun delete(@Url url:String): Response<ResponseBody>
}