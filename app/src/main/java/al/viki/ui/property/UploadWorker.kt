package al.viki.ui.property

import al.bruno.core.data.source.ImageRepository
import al.viki.BuildConfig
import al.viki.foundation.common.toFile
import android.content.Context
import android.net.Uri
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import id.zelory.compressor.Compressor
import kotlinx.coroutines.Dispatchers
import okhttp3.*
import okhttp3.RequestBody.Companion.asRequestBody

/**
 * https://proandroiddev.com/custom-notification-with-work-manager-for-android-41f10090a75e
 *
 * https://proandroiddev.com/customize-workmanager-with-appstartup-hilt-97c16d103052
 *
 * https://developer.android.com/topic/libraries/architecture/workmanager/advanced/custom-configuration#implement-configuration-provider
 *
 * https://developer.android.com/training/dependency-injection/hilt-jetpack
 */
@HiltWorker
class UploadWorker @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val imageRepository: ImageRepository
) : CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        val photoList = inputData.getStringArray("PHOTO_UI")
        val id = inputData.getInt("ID", -1)
        if (id != -1) {
            photoList?.forEachIndexed { index, photo ->
                // val progress = 100 * it.bytesTransferred / it.totalByteCount
                appContext.contentResolver.openInputStream(Uri.parse(photo))?.let { inputStream ->
                        val file = Compressor.compress(
                            context = appContext,
                            inputStream.toFile(appContext),
                            Dispatchers.IO
                        )
                        when (
                            imageRepository
                                .uploadImage(
                                    MultipartBody
                                        .Part
                                        .createFormData(
                                            "file",
                                            file.name,
                                            file.asRequestBody()
                                        ),
                                    "${BuildConfig.FILE_HOST_NAME}/resources/${id}/${index}"
                                )
                        ) {
                            is al.bruno.core.Result.Error -> Result.failure()
                            is al.bruno.core.Result.Success -> Result.success()
                        }
                    } ?: run {
                    return Result.failure()
                }
            } ?: run {
                return Result.failure()
            }
        } else {
            return Result.failure()
        }
        return Result.success()
    }
}