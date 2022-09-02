package al.viki.di

import al.bruno.core.di.CoreModule
import al.bruno.core.di.DataSourceModule
import al.bruno.core.di.NetworkModule
import al.viki.VikiApplication
import al.viki.core.di.AuthDataSourceModule
import al.viki.core.di.AuthModule
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    CoreModule::class,
    NetworkModule::class,
    DataSourceModule::class,
    AuthModule::class,
    AuthDataSourceModule::class,
    ActivityBindingModule::class,
    WorkManagerModule::class])
interface AppComponent : AndroidInjector<VikiApplication> {
    @Component.Factory
    interface Factory {
        fun application(@BindsInstance application: Context): AppComponent
    }
}