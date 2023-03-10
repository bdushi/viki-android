package al.viki.di

import al.viki.factory.DaggerChildWorkerFactory
import androidx.work.WorkerFactory
import dagger.Binds
import dagger.Module

@Module
abstract class WorkerBindingModule {
    //    @Binds
//    abstract fun bindWorkerFactory(factory: UploadWorker.Factory): ChildWorkerFactory
//    @AssistedFactory
//    interface ImageUploadWorkerFactory {
//        fun create(data: Data): UploadWorker
//    }


//    @ContributesAndroidInjector
//    abstract fun contributeUploadWorker(): UploadWorker

    @Binds
    abstract fun bindWorkManagerFactory(factory: DaggerChildWorkerFactory): WorkerFactory
//    abstract fun bindMyWorkerFactory(factory: UploadWorker.Factory): AssistedWorkerFactory<*>

}