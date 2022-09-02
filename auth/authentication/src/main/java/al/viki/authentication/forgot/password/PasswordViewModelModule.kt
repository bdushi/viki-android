package al.viki.authentication.forgot.password

import al.bruno.core.factory.ViewModelKey
import al.bruno.core.factory.ViewModelProviderFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PasswordViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(value =  PasswordViewModel::class)
    abstract fun bindPasswordViewModel(passwordViewModel: PasswordViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}