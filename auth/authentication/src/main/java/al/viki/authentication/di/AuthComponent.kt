package al.viki.authentication.di

import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.forgot.password.ForgotPasswordActivity
import al.viki.core.di.AuthModuleDependencies
import al.viki.core.di.TokenModuleDependencies
import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [AuthModuleDependencies::class, TokenModuleDependencies::class])
interface AuthComponent {
    fun inject(activity: AuthenticationActivity)
    fun inject(activity: ForgotPasswordActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(authModule: AuthModuleDependencies): Builder
        fun appDependencies(authModule: TokenModuleDependencies): Builder
        fun build(): AuthComponent
    }
}