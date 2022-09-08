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
        url: String
    ): Response<ResponseBody> {
        return imageService.uploadImage(url = url, file = file)
    }

    override suspend fun images(url: String): Response<Set<String>> {
        return imageService.images(url = url)
    }

    override suspend fun delete(url: String): Response<ResponseBody> {
        return imageService.delete(url)
    }
}