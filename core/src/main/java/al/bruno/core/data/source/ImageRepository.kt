package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.remote.ImageRemoteDataSource
import okhttp3.MultipartBody
import javax.inject.Inject
import javax.inject.Singleton

class ImageRepository @Inject constructor(private val imageRemoteDataSource: ImageRemoteDataSource) {
    suspend fun uploadImage(
        file: MultipartBody.Part,
        name: String
    ): Result<Int> {
        return try {
            val response = imageRemoteDataSource.uploadImage(file, name)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.Success(response.code())
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }
}