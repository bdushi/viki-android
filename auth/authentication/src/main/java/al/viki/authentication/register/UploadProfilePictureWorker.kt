package al.viki.authentication.register

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class UploadProfilePictureWorker(private val appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
//        val photo = inputData.getString("PHOTO_UI")
//        val username = inputData.getString("USERNAME")
//        val storageRefChild = Firebase.storage.reference.child("photos/${username}")
//        appContext.contentResolver.openInputStream(Uri.parse(photo))?.let { inputStream ->
//            storageRefChild
//                .child("/${username}")
//                .putFile(Uri.fromFile(Compressor.compress(context = appContext, inputStream.toFile(appContext), Dispatchers.IO)))
//                .addOnSuccessListener {
//                    Log.d("UploadWorker", it.toString())
//                }.addOnFailureListener {
//                    Log.d("UploadWorker", it.toString())
//                }.addOnCanceledListener {
//                    Log.d("UploadWorker", "Canceled")
//                }.addOnProgressListener {
//                    val progress = 100 * it.bytesTransferred / it.totalByteCount
//                    Log.d("UploadWorker", progress.toString())
//                }
//        } ?: run {
//            return Result.failure()
//        }
        return Result.success()
    }
}