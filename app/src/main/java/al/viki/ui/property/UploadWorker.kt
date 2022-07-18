package al.viki.ui.property

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.core.net.toUri
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import id.zelory.compressor.Compressor
import kotlinx.coroutines.Dispatchers
import java.io.File

class UploadWorker(private val appContext: Context, workerParams: WorkerParameters): CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        val photoList = inputData.getStringArray("PHOTO_UI")
        val id = inputData.getInt("ID", -1)
        if(id != -1) {
            val storageRefChild = Firebase.storage.reference.child("photos/${id}")
            photoList?.forEachIndexed { index, photo ->
                val file: Uri = Uri.fromFile(Compressor.compress(context = appContext, File(photo), Dispatchers.IO))
                storageRefChild
                    .child("/${id}_${index}")
                    .putFile(file)
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
        } else {
            return Result.failure()
        }
        return Result.success()
    }

}