package al.bruno.core.data.source

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response

interface ImageDataSource {
    suspend fun uploadImage(file: MultipartBody.Part, name: String): Response<ResponseBody>
}