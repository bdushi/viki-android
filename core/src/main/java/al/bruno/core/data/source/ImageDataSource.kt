package al.bruno.core.data.source

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response

interface ImageDataSource {
    suspend fun uploadImage(file: MultipartBody.Part, url: String): Response<ResponseBody>
    suspend fun images(url: String): Response<Set<String>>
    suspend fun delete(url: String): Response<ResponseBody>
}