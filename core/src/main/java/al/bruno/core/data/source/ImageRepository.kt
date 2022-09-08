package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.remote.ImageRemoteDataSource
import okhttp3.MultipartBody
import javax.inject.Inject

class ImageRepository @Inject constructor(private val imageRemoteDataSource: ImageRemoteDataSource) {
    suspend fun uploadImage(
        file: MultipartBody.Part,
        url: String
    ): Result<Int> {
        return try {
            val response = imageRemoteDataSource.uploadImage(file, url)
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

    suspend fun images(url: String): Result<Set<String>> {
        return try {
            val response = imageRemoteDataSource.images(url)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.Success(body)
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }

    suspend fun delete(url: String): Result<Int> {
        return try {
            val response = imageRemoteDataSource.delete(url)
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