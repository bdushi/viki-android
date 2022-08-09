package al.viki.authentication.di

import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.forgot.password.ForgotPasswordActivity
import al.viki.authentication.register.RegisterActivity
import al.viki.core.di.AuthModuleDependencies
import al.viki.core.di.RegistrationModuleDependencies
import al.viki.core.di.TokenModuleDependencies
import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [AuthModuleDependencies::class, TokenModuleDependencies::class, RegistrationModuleDependencies::class])
interface AuthComponent {
    fun inject(activity: AuthenticationActivity)
    fun inject(activity: ForgotPasswordActivity)
    fun inject(activity: RegisterActivity)
    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(authModule: AuthModuleDependencies): Builder
        fun appDependencies(authModule: TokenModuleDependencies): Builder
        fun appDependencies(authModule: RegistrationModuleDependencies): Builder
        fun build(): AuthComponent
    }
}