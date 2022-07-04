package al.viki.authentication.di

import al.viki.authentication.AuthenticationActivity
import al.viki.core.di.AuthModuleDependencies
import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [AuthModuleDependencies::class])
interface AuthComponent {
    fun inject(activity: AuthenticationActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(authModule: AuthModuleDependencies): Builder
        fun build(): AuthComponent
    }
}