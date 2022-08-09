package al.viki.authentication.register

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import id.zelory.compressor.Compressor
import kotlinx.coroutines.Dispatchers
import java.io.File

class UploadProfilePictureWorker (private val appContext: Context, workerParams: WorkerParameters): CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        val photo = inputData.getString("PHOTO_UI")
        val username = inputData.getString("USERNAME")
        val storageRefChild = Firebase.storage.reference.child("photos/${username}")
        photo?.let {
            storageRefChild
                .putFile(Uri.fromFile(Compressor.compress(context = appContext, File(photo), Dispatchers.IO)))
                .addOnSuccessListener {
                    Log.d("UploadWorker", it.toString())
                }.addOnFailureListener {
                    Log.d("UploadWorker", it.toString())
                }.addOnCanceledListener {
                    Log.d("UploadWorker", "Canceled")
                }.addOnProgressListener {
                    val progress = 100 * it.bytesTransferred / it.totalByteCount
                    Log.d("UploadWorker", progress.toString())
                }
        } ?: run {
            return Result.failure()
        }
        return Result.success()
    }
}