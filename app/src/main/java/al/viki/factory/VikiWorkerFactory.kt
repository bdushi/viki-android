package al.viki.factory

import al.bruno.core.data.source.ImageRepository
import androidx.work.DelegatingWorkerFactory
import javax.inject.Inject
import javax.inject.Singleton

/**
 * https://medium.com/androiddevelopers/customizing-workmanager-with-dagger-1029688c0978
 * https://medium.com/androiddevelopers/customizing-workmanager-fundamentals-fdaa17c46dd2
 */

class VikiWorkerFactory @Inject constructor(imageRepository: ImageRepository) : DelegatingWorkerFactory() {
    init {
        addFactory(WorkerManagerProviderFactory(imageRepository))
    }
}