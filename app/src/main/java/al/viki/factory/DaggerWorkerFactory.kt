package al.viki.factory

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject
import javax.inject.Provider

class DaggerWorkerFactory @Inject constructor(
    private val workerInjector: Provider<WorkerInjector>
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker {
        val injector = workerInjector.get()
        return injector.create(
            appContext,
            workerParameters,
            Class.forName(workerClassName).asSubclass(Worker::class.java)
        )
    }
}