package al.viki.di

import al.bruno.core.factory.ViewModelKey
import al.bruno.core.factory.ViewModelProviderFactory
import al.viki.ui.account.RequestNewAccountViewModel
import al.viki.ui.home.HomeViewModel
import al.viki.ui.main.MainViewModel
import al.viki.ui.property.PropertyViewModel
import al.viki.ui.request.RequestViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(value =  RequestNewAccountViewModel::class)
    abstract fun bindRequestNewAccountViewModel(requestNewAccountViewModel: RequestNewAccountViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(value =  MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(value =  HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(value =  PropertyViewModel::class)
    abstract fun bindPropertyViewModel(propertyViewModel: PropertyViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(value =  RequestViewModel::class)
    abstract fun bindRequestViewModel(requestViewModel: RequestViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory
    ): ViewModelProvider.Factory
}