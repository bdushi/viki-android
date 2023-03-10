package al.viki.di

import al.viki.factory.AssistedWorkerFactory
import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerParameters
import dagger.Module
import dagger.Provides

@Module
abstract class AssistedWorkerModule<T : ListenableWorker> {
    @Provides
    fun provideWorker(
        appContext: Context,
        workerParams: WorkerParameters,
        dependencies: AssistedWorkerFactory<T>
    ): T {
        return dependencies.createWorker(appContext, workerParams)
    }
    @Provides
    fun provideWorkerFactory(
        dependencies: AssistedWorkerFactory<T>
    ): AssistedWorkerFactory<T> {
        return object : AssistedWorkerFactory<T> {
            override fun createWorker(
                appContext: Context,
                workerParams: WorkerParameters
            ): T {
                return provideWorker(appContext, workerParams, dependencies)
            }
        }
    }
}