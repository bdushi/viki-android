package al.viki.di

import al.viki.ui.account.RequestNewAccountFragment
import al.viki.ui.details.PropertyDetailsFragment
import al.viki.ui.details.RequestDetailsFragment
import al.viki.ui.home.HomeFragment
import al.viki.ui.property.NewPropertyFragment
import al.viki.ui.request.NewRequestFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {
    @ContributesAndroidInjector
    internal abstract fun contributeRequestNewAccountFragment(): RequestNewAccountFragment
    @ContributesAndroidInjector
    internal abstract fun contributePropertyDetailsFragment(): PropertyDetailsFragment
    @ContributesAndroidInjector
    internal abstract fun contributeRequestDetailsFragment(): RequestDetailsFragment
    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment
    @ContributesAndroidInjector
    internal abstract fun contributeNewPropertyFragment(): NewPropertyFragment
    @ContributesAndroidInjector
    internal abstract fun contributeNewRequestFragment(): NewRequestFragment
}