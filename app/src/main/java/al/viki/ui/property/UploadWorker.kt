package al.viki.ui.property

import al.bruno.core.data.source.ImageRepository
import al.viki.factory.ChildWorkerFactory
import al.viki.foundation.common.toFile
import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import id.zelory.compressor.Compressor
import kotlinx.coroutines.Dispatchers
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody

/**
 * https://proandroiddev.com/custom-notification-with-work-manager-for-android-41f10090a75e
 *
 * https://proandroiddev.com/customize-workmanager-with-appstartup-hilt-97c16d103052
 */

class UploadWorker @AssistedInject constructor(
    @Assisted params: WorkerParameters,
    @Assisted appContext: Context,
    private val imageRepository: ImageRepository
) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        Log.d(UploadWorker::class.java.name, "UploadWorker")
        val photoList = inputData.getStringArray("PHOTO_UI")
        val id = inputData.getInt("ID", -1)
        if (id != -1) {
            photoList?.forEachIndexed { index, photo ->
                // val progress = 100 * it.bytesTransferred / it.totalByteCount
                applicationContext.contentResolver.openInputStream(Uri.parse(photo))
                    ?.let { inputStream ->
                        val file = Compressor.compress(
                            context = applicationContext,
                            inputStream.toFile(applicationContext),
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
                                    "/${id}_${index}"
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

//    @AssistedFactory
//    interface Factory : ChildWorkerFactory
//    @AssistedFactory
//    interface Factory : AssistedWorkerFactory<UploadWorker>
}