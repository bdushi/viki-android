package al.viki.authentication.auth

import al.bruno.core.factory.ViewModelKey
import al.bruno.core.factory.ViewModelProviderFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(value =  AuthenticationViewModel::class)
    abstract fun bindAuthenticationViewModel(authenticationViewModel: AuthenticationViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}