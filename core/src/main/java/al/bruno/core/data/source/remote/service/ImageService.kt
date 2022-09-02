package al.bruno.core.data.source.remote.service

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*


interface ImageService {
    @POST("resources/{name}")
    @Multipart
    suspend fun uploadImage(@Url url:String = "http://192.168.1.141:8081/", @Part file: MultipartBody.Part, @Path("name") name: String): Response<ResponseBody>
}