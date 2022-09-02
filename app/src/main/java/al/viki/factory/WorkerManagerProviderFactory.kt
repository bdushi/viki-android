package al.viki.factory

import al.bruno.core.data.source.ImageRepository
import al.viki.ui.property.UploadWorker
import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject
import javax.inject.Provider

class WorkerManagerProviderFactory @Inject constructor(
    private val imageRepository: ImageRepository
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            UploadWorker::class.java.name ->
                UploadWorker(workerParameters, appContext, imageRepository)
            else ->
                null
        }
    }
}