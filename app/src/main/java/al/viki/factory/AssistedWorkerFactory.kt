package al.viki.factory

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters

interface AssistedWorkerFactory<T : ListenableWorker> {
    fun createWorker(
        appContext: Context,
        workerParams: WorkerParameters
    ): T
}