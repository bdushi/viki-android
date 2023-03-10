package al.viki.factory

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters

interface WorkerInjector {
    fun create(appContext: Context, params: WorkerParameters, workerClass: Class<out Worker>): ListenableWorker
}