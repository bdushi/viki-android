package al.bruno.core.data.source.remote

import al.bruno.core.data.source.ImageDataSource
import al.bruno.core.data.source.remote.service.ImageService
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class ImageRemoteDataSource @Inject constructor(private val imageService: ImageService) : ImageDataSource {
    override suspend fun uploadImage(
        file: MultipartBody.Part,
        name: String
    ): Response<ResponseBody> {
        return imageService.uploadImage(file = file, name = name)
    }
}