package al.viki.di

import al.viki.authentication.auth.AuthViewModelModule
import al.viki.authentication.auth.AuthenticationActivity
import al.viki.authentication.auth.AuthenticationViewModel
import al.viki.authentication.forgot.password.ChangePasswordActivity
import al.viki.authentication.forgot.password.ForgotPasswordActivity
import al.viki.authentication.forgot.password.PasswordViewModelModule
import al.viki.authentication.register.RegisterActivity
import al.viki.authentication.register.RegisterModule
import al.viki.authentication.register.RegisterViewModel
import al.viki.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [MainFragmentBuildersModule::class, MainViewModelModule::class])
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [AuthViewModelModule::class])
    abstract fun authenticationActivity(): AuthenticationActivity

    @ContributesAndroidInjector(modules = [PasswordViewModelModule::class])
    abstract fun changePasswordActivity(): ChangePasswordActivity

    @ContributesAndroidInjector(modules = [PasswordViewModelModule::class])
    abstract fun forgotPasswordActivity(): ForgotPasswordActivity

    @ContributesAndroidInjector(modules = [RegisterModule::class])
    abstract fun registerActivity(): RegisterActivity
}