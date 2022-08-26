package al.viki;

import al.bruno.core.data.source.AuthorityRepository;
import al.bruno.core.data.source.CityRepository;
import al.bruno.core.data.source.CurrencyRepository;
import al.bruno.core.data.source.FloorPlanRepository;
import al.bruno.core.data.source.OperationRepository;
import al.bruno.core.data.source.PropertyRepository;
import al.bruno.core.data.source.PropertyTypeRepository;
import al.bruno.core.data.source.RequestAccountRepository;
import al.bruno.core.data.source.UnitRepository;
import al.bruno.core.data.source.UserRepository;
import al.bruno.core.data.source.remote.AuthorityRemoteDataSource;
import al.bruno.core.data.source.remote.CityRemoteDataSource;
import al.bruno.core.data.source.remote.CurrencyRemoteDataSource;
import al.bruno.core.data.source.remote.FloorPlanRemoteDataSource;
import al.bruno.core.data.source.remote.OperationRemoteDataSource;
import al.bruno.core.data.source.remote.PropertyRemoteDataSource;
import al.bruno.core.data.source.remote.PropertyTypeRemoteDataSource;
import al.bruno.core.data.source.remote.RequestAccountRemoteDataSource;
import al.bruno.core.data.source.remote.UnitRemoteDataSource;
import al.bruno.core.data.source.remote.UserRemoteDataSource;
import al.bruno.core.data.source.remote.service.AuthorityService;
import al.bruno.core.data.source.remote.service.CityService;
import al.bruno.core.data.source.remote.service.CurrencyService;
import al.bruno.core.data.source.remote.service.FloorPlanService;
import al.bruno.core.data.source.remote.service.OperationService;
import al.bruno.core.data.source.remote.service.PropertyService;
import al.bruno.core.data.source.remote.service.PropertyTypeService;
import al.bruno.core.data.source.remote.service.RequestAccountService;
import al.bruno.core.data.source.remote.service.UnitService;
import al.bruno.core.data.source.remote.service.UserService;
import al.bruno.core.di.CoreModule;
import al.bruno.core.di.CoreModule_ProvidesDataStoreFactory;
import al.bruno.core.di.NetworkModule;
import al.bruno.core.di.NetworkModule_AuthorityRequestAccountServiceFactory;
import al.bruno.core.di.NetworkModule_AuthorityServiceFactory;
import al.bruno.core.di.NetworkModule_AuthorityUserServiceFactory;
import al.bruno.core.di.NetworkModule_BaseUrlFactory;
import al.bruno.core.di.NetworkModule_CityServiceFactory;
import al.bruno.core.di.NetworkModule_ConverterFactoryFactory;
import al.bruno.core.di.NetworkModule_CurrencyServiceFactory;
import al.bruno.core.di.NetworkModule_ErrorHandlerFactory;
import al.bruno.core.di.NetworkModule_FloorPlanServiceFactory;
import al.bruno.core.di.NetworkModule_LoggingFactory;
import al.bruno.core.di.NetworkModule_OkHttpClientFactory;
import al.bruno.core.di.NetworkModule_OperationServiceFactory;
import al.bruno.core.di.NetworkModule_PropertyServiceFactory;
import al.bruno.core.di.NetworkModule_PropertyTypeServiceFactory;
import al.bruno.core.di.NetworkModule_ProviderRetrofitFactory;
import al.bruno.core.di.NetworkModule_UnitServiceFactory;
import al.bruno.core.error.ErrorHandler;
import al.bruno.core.interceptor.AuthorizationInterceptor;
import al.bruno.core.interceptor.RefreshTokenInterceptor;
import al.viki.authentication.auth.AuthenticationActivity;
import al.viki.authentication.auth.AuthenticationViewModel;
import al.viki.authentication.auth.AuthenticationViewModel_HiltModules_KeyModule_ProvideFactory;
import al.viki.authentication.forgot.password.ChangePasswordActivity;
import al.viki.authentication.forgot.password.ForgotPasswordActivity;
import al.viki.authentication.forgot.password.PasswordViewModel;
import al.viki.authentication.forgot.password.PasswordViewModel_HiltModules_KeyModule_ProvideFactory;
import al.viki.authentication.register.RegisterActivity;
import al.viki.authentication.register.RegisterViewModel;
import al.viki.authentication.register.RegisterViewModel_HiltModules_KeyModule_ProvideFactory;
import al.viki.core.AuthRepository;
import al.viki.core.RegistrationRepository;
import al.viki.core.TokeRepository;
import al.viki.core.di.AuthModule;
import al.viki.core.di.AuthModule_AuthServiceFactory;
import al.viki.core.di.RegistrationModule;
import al.viki.core.di.RegistrationModule_RegistrationServiceFactory;
import al.viki.core.di.TokenModule;
import al.viki.core.di.TokenModule_TokenServiceFactory;
import al.viki.core.local.AuthLocalDataSource;
import al.viki.core.remote.AuthRemoteDataSource;
import al.viki.core.remote.RegistrationRemoteDataSource;
import al.viki.core.remote.TokenRemoteDataSource;
import al.viki.core.remote.service.AuthService;
import al.viki.core.remote.service.RegistrationService;
import al.viki.core.remote.service.TokenService;
import al.viki.ui.account.RequestNewAccountFragment;
import al.viki.ui.account.RequestNewAccountViewModel;
import al.viki.ui.account.RequestNewAccountViewModel_HiltModules_KeyModule_ProvideFactory;
import al.viki.ui.details.PropertyDetailsFragment;
import al.viki.ui.details.RequestDetailsFragment;
import al.viki.ui.home.HomeFragment;
import al.viki.ui.home.HomeViewModel;
import al.viki.ui.home.HomeViewModel_HiltModules_KeyModule_ProvideFactory;
import al.viki.ui.main.MainActivity;
import al.viki.ui.main.MainActivity_MembersInjector;
import al.viki.ui.main.MainViewModel;
import al.viki.ui.main.MainViewModel_HiltModules_KeyModule_ProvideFactory;
import al.viki.ui.profile.ChangePasswordFragment;
import al.viki.ui.profile.ProfileFragment;
import al.viki.ui.property.NewPropertyFragment;
import al.viki.ui.property.PropertyViewModel;
import al.viki.ui.property.PropertyViewModel_HiltModules_KeyModule_ProvideFactory;
import al.viki.ui.request.NewRequestFragment;
import al.viki.ui.request.RequestViewModel;
import al.viki.ui.request.RequestViewModel_HiltModules_KeyModule_ProvideFactory;
import al.viki.ui.settings.SettingsFragment;
import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_Lifecycle_Factory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SingleCheck;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerVikiApplication_HiltComponents_SingletonC {
  private DaggerVikiApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private AuthModule authModule;

    private CoreModule coreModule;

    private NetworkModule networkModule;

    private RegistrationModule registrationModule;

    private TokenModule tokenModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public Builder authModule(AuthModule authModule) {
      this.authModule = Preconditions.checkNotNull(authModule);
      return this;
    }

    public Builder coreModule(CoreModule coreModule) {
      this.coreModule = Preconditions.checkNotNull(coreModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(
        HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
      Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
      return this;
    }

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }

    public Builder registrationModule(RegistrationModule registrationModule) {
      this.registrationModule = Preconditions.checkNotNull(registrationModule);
      return this;
    }

    public Builder tokenModule(TokenModule tokenModule) {
      this.tokenModule = Preconditions.checkNotNull(tokenModule);
      return this;
    }

    public VikiApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      if (authModule == null) {
        this.authModule = new AuthModule();
      }
      if (coreModule == null) {
        this.coreModule = new CoreModule();
      }
      if (networkModule == null) {
        this.networkModule = new NetworkModule();
      }
      if (registrationModule == null) {
        this.registrationModule = new RegistrationModule();
      }
      if (tokenModule == null) {
        this.tokenModule = new TokenModule();
      }
      return new SingletonCImpl(applicationContextModule, authModule, coreModule, networkModule, registrationModule, tokenModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements VikiApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public VikiApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl(singletonCImpl);
    }
  }

  private static final class ActivityCBuilder implements VikiApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public VikiApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements VikiApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public VikiApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements VikiApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public VikiApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements VikiApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public VikiApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements VikiApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public VikiApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle);
    }
  }

  private static final class ServiceCBuilder implements VikiApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public VikiApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends VikiApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends VikiApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectRequestNewAccountFragment(RequestNewAccountFragment arg0) {
    }

    @Override
    public void injectPropertyDetailsFragment(PropertyDetailsFragment arg0) {
    }

    @Override
    public void injectRequestDetailsFragment(RequestDetailsFragment arg0) {
    }

    @Override
    public void injectHomeFragment(HomeFragment arg0) {
    }

    @Override
    public void injectChangePasswordFragment(ChangePasswordFragment arg0) {
    }

    @Override
    public void injectProfileFragment(ProfileFragment arg0) {
    }

    @Override
    public void injectNewPropertyFragment(NewPropertyFragment arg0) {
    }

    @Override
    public void injectNewRequestFragment(NewRequestFragment arg0) {
    }

    @Override
    public void injectSettingsFragment(SettingsFragment arg0) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends VikiApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends VikiApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectAuthenticationActivity(AuthenticationActivity arg0) {
    }

    @Override
    public void injectChangePasswordActivity(ChangePasswordActivity arg0) {
    }

    @Override
    public void injectForgotPasswordActivity(ForgotPasswordActivity arg0) {
    }

    @Override
    public void injectRegisterActivity(RegisterActivity arg0) {
    }

    @Override
    public void injectMainActivity(MainActivity arg0) {
      injectMainActivity2(arg0);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return SetBuilder.<String>newSetBuilder(8).add(AuthenticationViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(HomeViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(MainViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(PasswordViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(PropertyViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(RegisterViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(RequestNewAccountViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(RequestViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build();
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    private MainActivity injectMainActivity2(MainActivity instance) {
      MainActivity_MembersInjector.injectAuthorizationInterceptor(instance, singletonCImpl.authorizationInterceptorProvider.get());
      MainActivity_MembersInjector.injectRefreshTokenInterceptor(instance, singletonCImpl.refreshTokenInterceptorProvider.get());
      return instance;
    }
  }

  private static final class ViewModelCImpl extends VikiApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AuthenticationViewModel> authenticationViewModelProvider;

    private Provider<PropertyService> propertyServiceProvider;

    private Provider<PropertyTypeService> propertyTypeServiceProvider;

    private Provider<UserService> authorityUserServiceProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<MainViewModel> mainViewModelProvider;

    private Provider<TokenService> tokenServiceProvider;

    private Provider<PasswordViewModel> passwordViewModelProvider;

    private Provider<CityService> cityServiceProvider;

    private Provider<CurrencyService> currencyServiceProvider;

    private Provider<OperationService> operationServiceProvider;

    private Provider<UnitService> unitServiceProvider;

    private Provider<PropertyViewModel> propertyViewModelProvider;

    private Provider<RegistrationService> registrationServiceProvider;

    private Provider<RegisterViewModel> registerViewModelProvider;

    private Provider<AuthorityService> authorityServiceProvider;

    private Provider<RequestAccountService> authorityRequestAccountServiceProvider;

    private Provider<ErrorHandler> errorHandlerProvider;

    private Provider<RequestNewAccountViewModel> requestNewAccountViewModelProvider;

    private Provider<FloorPlanService> floorPlanServiceProvider;

    private Provider<RequestViewModel> requestViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam);

    }

    private AuthRemoteDataSource authRemoteDataSource() {
      return new AuthRemoteDataSource(singletonCImpl.authServiceProvider.get());
    }

    private AuthLocalDataSource authLocalDataSource() {
      return new AuthLocalDataSource(singletonCImpl.providesDataStoreProvider.get());
    }

    private AuthRepository authRepository() {
      return new AuthRepository(authRemoteDataSource(), authLocalDataSource());
    }

    private PropertyRemoteDataSource propertyRemoteDataSource() {
      return new PropertyRemoteDataSource(propertyServiceProvider.get());
    }

    private PropertyRepository propertyRepository() {
      return new PropertyRepository(propertyRemoteDataSource());
    }

    private PropertyTypeRemoteDataSource propertyTypeRemoteDataSource() {
      return new PropertyTypeRemoteDataSource(propertyTypeServiceProvider.get());
    }

    private PropertyTypeRepository propertyTypeRepository() {
      return new PropertyTypeRepository(propertyTypeRemoteDataSource());
    }

    private UserRemoteDataSource userRemoteDataSource() {
      return new UserRemoteDataSource(authorityUserServiceProvider.get());
    }

    private UserRepository userRepository() {
      return new UserRepository(userRemoteDataSource());
    }

    private TokenRemoteDataSource tokenRemoteDataSource() {
      return new TokenRemoteDataSource(tokenServiceProvider.get());
    }

    private TokeRepository tokeRepository() {
      return new TokeRepository(tokenRemoteDataSource(), authLocalDataSource());
    }

    private CityRemoteDataSource cityRemoteDataSource() {
      return new CityRemoteDataSource(cityServiceProvider.get());
    }

    private CityRepository cityRepository() {
      return new CityRepository(cityRemoteDataSource());
    }

    private CurrencyRemoteDataSource currencyRemoteDataSource() {
      return new CurrencyRemoteDataSource(currencyServiceProvider.get());
    }

    private CurrencyRepository currencyRepository() {
      return new CurrencyRepository(currencyRemoteDataSource());
    }

    private OperationRemoteDataSource operationRemoteDataSource() {
      return new OperationRemoteDataSource(operationServiceProvider.get());
    }

    private OperationRepository operationRepository() {
      return new OperationRepository(operationRemoteDataSource());
    }

    private UnitRemoteDataSource unitRemoteDataSource() {
      return new UnitRemoteDataSource(unitServiceProvider.get());
    }

    private UnitRepository unitRepository() {
      return new UnitRepository(unitRemoteDataSource());
    }

    private RegistrationRemoteDataSource registrationRemoteDataSource() {
      return new RegistrationRemoteDataSource(registrationServiceProvider.get());
    }

    private RegistrationRepository registrationRepository() {
      return new RegistrationRepository(registrationRemoteDataSource(), authLocalDataSource());
    }

    private AuthorityRemoteDataSource authorityRemoteDataSource() {
      return new AuthorityRemoteDataSource(authorityServiceProvider.get());
    }

    private AuthorityRepository authorityRepository() {
      return new AuthorityRepository(authorityRemoteDataSource());
    }

    private RequestAccountRemoteDataSource requestAccountRemoteDataSource() {
      return new RequestAccountRemoteDataSource(authorityRequestAccountServiceProvider.get());
    }

    private RequestAccountRepository requestAccountRepository() {
      return new RequestAccountRepository(requestAccountRemoteDataSource(), errorHandlerProvider.get());
    }

    private FloorPlanRemoteDataSource floorPlanRemoteDataSource() {
      return new FloorPlanRemoteDataSource(floorPlanServiceProvider.get());
    }

    private FloorPlanRepository floorPlanRepository() {
      return new FloorPlanRepository(floorPlanRemoteDataSource());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam) {
      this.authenticationViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.propertyServiceProvider = SingleCheck.provider(new SwitchingProvider<PropertyService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2));
      this.propertyTypeServiceProvider = SingleCheck.provider(new SwitchingProvider<PropertyTypeService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3));
      this.authorityUserServiceProvider = SingleCheck.provider(new SwitchingProvider<UserService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4));
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.mainViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.tokenServiceProvider = SingleCheck.provider(new SwitchingProvider<TokenService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7));
      this.passwordViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.cityServiceProvider = SingleCheck.provider(new SwitchingProvider<CityService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9));
      this.currencyServiceProvider = SingleCheck.provider(new SwitchingProvider<CurrencyService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 10));
      this.operationServiceProvider = SingleCheck.provider(new SwitchingProvider<OperationService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 11));
      this.unitServiceProvider = SingleCheck.provider(new SwitchingProvider<UnitService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 12));
      this.propertyViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.registrationServiceProvider = SingleCheck.provider(new SwitchingProvider<RegistrationService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 14));
      this.registerViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 13);
      this.authorityServiceProvider = SingleCheck.provider(new SwitchingProvider<AuthorityService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 16));
      this.authorityRequestAccountServiceProvider = SingleCheck.provider(new SwitchingProvider<RequestAccountService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 17));
      this.errorHandlerProvider = SingleCheck.provider(new SwitchingProvider<ErrorHandler>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 18));
      this.requestNewAccountViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 15);
      this.floorPlanServiceProvider = SingleCheck.provider(new SwitchingProvider<FloorPlanService>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 20));
      this.requestViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 19);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return MapBuilder.<String, Provider<ViewModel>>newMapBuilder(8).put("al.viki.authentication.auth.AuthenticationViewModel", ((Provider) authenticationViewModelProvider)).put("al.viki.ui.home.HomeViewModel", ((Provider) homeViewModelProvider)).put("al.viki.ui.main.MainViewModel", ((Provider) mainViewModelProvider)).put("al.viki.authentication.forgot.password.PasswordViewModel", ((Provider) passwordViewModelProvider)).put("al.viki.ui.property.PropertyViewModel", ((Provider) propertyViewModelProvider)).put("al.viki.authentication.register.RegisterViewModel", ((Provider) registerViewModelProvider)).put("al.viki.ui.account.RequestNewAccountViewModel", ((Provider) requestNewAccountViewModelProvider)).put("al.viki.ui.request.RequestViewModel", ((Provider) requestViewModelProvider)).build();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // al.viki.authentication.auth.AuthenticationViewModel 
          return (T) new AuthenticationViewModel(viewModelCImpl.authRepository(), singletonCImpl.authorizationInterceptorProvider.get());

          case 1: // al.viki.ui.home.HomeViewModel 
          return (T) new HomeViewModel(viewModelCImpl.propertyRepository(), viewModelCImpl.propertyTypeRepository(), viewModelCImpl.userRepository());

          case 2: // al.bruno.core.data.source.remote.service.PropertyService 
          return (T) NetworkModule_PropertyServiceFactory.propertyService(singletonCImpl.networkModule, singletonCImpl.providerRetrofitProvider.get());

          case 3: // al.bruno.core.data.source.remote.service.PropertyTypeService 
          return (T) NetworkModule_PropertyTypeServiceFactory.propertyTypeService(singletonCImpl.networkModule, singletonCImpl.providerRetrofitProvider.get());

          case 4: // al.bruno.core.data.source.remote.service.UserService 
          return (T) NetworkModule_AuthorityUserServiceFactory.authorityUserService(singletonCImpl.networkModule, singletonCImpl.providerRetrofitProvider.get());

          case 5: // al.viki.ui.main.MainViewModel 
          return (T) new MainViewModel(viewModelCImpl.authRepository());

          case 6: // al.viki.authentication.forgot.password.PasswordViewModel 
          return (T) new PasswordViewModel(viewModelCImpl.tokeRepository(), viewModelCImpl.authRepository());

          case 7: // al.viki.core.remote.service.TokenService 
          return (T) TokenModule_TokenServiceFactory.tokenService(singletonCImpl.tokenModule, singletonCImpl.providerRetrofitProvider.get());

          case 8: // al.viki.ui.property.PropertyViewModel 
          return (T) new PropertyViewModel(viewModelCImpl.cityRepository(), viewModelCImpl.currencyRepository(), viewModelCImpl.operationRepository(), viewModelCImpl.propertyTypeRepository(), viewModelCImpl.unitRepository(), viewModelCImpl.propertyRepository());

          case 9: // al.bruno.core.data.source.remote.service.CityService 
          return (T) NetworkModule_CityServiceFactory.cityService(singletonCImpl.networkModule, singletonCImpl.providerRetrofitProvider.get());

          case 10: // al.bruno.core.data.source.remote.service.CurrencyService 
          return (T) NetworkModule_CurrencyServiceFactory.currencyService(singletonCImpl.networkModule, singletonCImpl.providerRetrofitProvider.get());

          case 11: // al.bruno.core.data.source.remote.service.OperationService 
          return (T) NetworkModule_OperationServiceFactory.operationService(singletonCImpl.networkModule, singletonCImpl.providerRetrofitProvider.get());

          case 12: // al.bruno.core.data.source.remote.service.UnitService 
          return (T) NetworkModule_UnitServiceFactory.unitService(singletonCImpl.networkModule, singletonCImpl.providerRetrofitProvider.get());

          case 13: // al.viki.authentication.register.RegisterViewModel 
          return (T) new RegisterViewModel(viewModelCImpl.registrationRepository());

          case 14: // al.viki.core.remote.service.RegistrationService 
          return (T) RegistrationModule_RegistrationServiceFactory.registrationService(singletonCImpl.registrationModule, singletonCImpl.providerRetrofitProvider.get());

          case 15: // al.viki.ui.account.RequestNewAccountViewModel 
          return (T) new RequestNewAccountViewModel(viewModelCImpl.authorityRepository(), viewModelCImpl.requestAccountRepository());

          case 16: // al.bruno.core.data.source.remote.service.AuthorityService 
          return (T) NetworkModule_AuthorityServiceFactory.authorityService(singletonCImpl.networkModule, singletonCImpl.providerRetrofitProvider.get());

          case 17: // al.bruno.core.data.source.remote.service.RequestAccountService 
          return (T) NetworkModule_AuthorityRequestAccountServiceFactory.authorityRequestAccountService(singletonCImpl.networkModule, singletonCImpl.providerRetrofitProvider.get());

          case 18: // al.bruno.core.error.ErrorHandler 
          return (T) NetworkModule_ErrorHandlerFactory.errorHandler(singletonCImpl.networkModule, singletonCImpl.providerRetrofitProvider.get());

          case 19: // al.viki.ui.request.RequestViewModel 
          return (T) new RequestViewModel(viewModelCImpl.cityRepository(), viewModelCImpl.currencyRepository(), viewModelCImpl.floorPlanRepository(), viewModelCImpl.propertyTypeRepository(), viewModelCImpl.unitRepository(), viewModelCImpl.propertyRepository());

          case 20: // al.bruno.core.data.source.remote.service.FloorPlanService 
          return (T) NetworkModule_FloorPlanServiceFactory.floorPlanService(singletonCImpl.networkModule, singletonCImpl.providerRetrofitProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends VikiApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    @SuppressWarnings("rawtypes")
    private Provider lifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.lifecycleProvider = DoubleCheck.provider(new SwitchingProvider<Object>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return (ActivityRetainedLifecycle) lifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.internal.managers.ActivityRetainedComponentManager.Lifecycle 
          return (T) ActivityRetainedComponentManager_Lifecycle_Factory.newInstance();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends VikiApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends VikiApplication_HiltComponents.SingletonC {
    private final AuthModule authModule;

    private final NetworkModule networkModule;

    private final CoreModule coreModule;

    private final ApplicationContextModule applicationContextModule;

    private final TokenModule tokenModule;

    private final RegistrationModule registrationModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<String> baseUrlProvider;

    private Provider<AuthorizationInterceptor> authorizationInterceptorProvider;

    private Provider<HttpLoggingInterceptor> loggingProvider;

    private Provider<OkHttpClient> okHttpClientProvider;

    private Provider<MoshiConverterFactory> converterFactoryProvider;

    private Provider<Retrofit> providerRetrofitProvider;

    private Provider<AuthService> authServiceProvider;

    private Provider<RefreshTokenInterceptor> refreshTokenInterceptorProvider;

    private Provider<DataStore<Preferences>> providesDataStoreProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam,
        AuthModule authModuleParam, CoreModule coreModuleParam, NetworkModule networkModuleParam,
        RegistrationModule registrationModuleParam, TokenModule tokenModuleParam) {
      this.authModule = authModuleParam;
      this.networkModule = networkModuleParam;
      this.coreModule = coreModuleParam;
      this.applicationContextModule = applicationContextModuleParam;
      this.tokenModule = tokenModuleParam;
      this.registrationModule = registrationModuleParam;
      initialize(applicationContextModuleParam, authModuleParam, coreModuleParam, networkModuleParam, registrationModuleParam, tokenModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam,
        final AuthModule authModuleParam, final CoreModule coreModuleParam,
        final NetworkModule networkModuleParam, final RegistrationModule registrationModuleParam,
        final TokenModule tokenModuleParam) {
      this.baseUrlProvider = DoubleCheck.provider(new SwitchingProvider<String>(singletonCImpl, 2));
      this.authorizationInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<AuthorizationInterceptor>(singletonCImpl, 4));
      this.loggingProvider = SingleCheck.provider(new SwitchingProvider<HttpLoggingInterceptor>(singletonCImpl, 5));
      this.okHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 3));
      this.converterFactoryProvider = SingleCheck.provider(new SwitchingProvider<MoshiConverterFactory>(singletonCImpl, 6));
      this.providerRetrofitProvider = SingleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 1));
      this.authServiceProvider = SingleCheck.provider(new SwitchingProvider<AuthService>(singletonCImpl, 0));
      this.refreshTokenInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<RefreshTokenInterceptor>(singletonCImpl, 7));
      this.providesDataStoreProvider = DoubleCheck.provider(new SwitchingProvider<DataStore<Preferences>>(singletonCImpl, 8));
    }

    @Override
    public void injectVikiApplication(VikiApplication arg0) {
    }

    @Override
    public AuthService authService() {
      return authServiceProvider.get();
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // al.viki.core.remote.service.AuthService 
          return (T) AuthModule_AuthServiceFactory.authService(singletonCImpl.authModule, singletonCImpl.providerRetrofitProvider.get());

          case 1: // retrofit2.Retrofit 
          return (T) NetworkModule_ProviderRetrofitFactory.providerRetrofit(singletonCImpl.networkModule, singletonCImpl.baseUrlProvider.get(), singletonCImpl.okHttpClientProvider.get(), singletonCImpl.converterFactoryProvider.get());

          case 2: // java.lang.String 
          return (T) NetworkModule_BaseUrlFactory.baseUrl(singletonCImpl.networkModule);

          case 3: // okhttp3.OkHttpClient 
          return (T) NetworkModule_OkHttpClientFactory.okHttpClient(singletonCImpl.networkModule, singletonCImpl.authorizationInterceptorProvider.get(), singletonCImpl.loggingProvider.get());

          case 4: // al.bruno.core.interceptor.AuthorizationInterceptor 
          return (T) new AuthorizationInterceptor();

          case 5: // okhttp3.logging.HttpLoggingInterceptor 
          return (T) NetworkModule_LoggingFactory.logging(singletonCImpl.networkModule);

          case 6: // retrofit2.converter.moshi.MoshiConverterFactory 
          return (T) NetworkModule_ConverterFactoryFactory.converterFactory(singletonCImpl.networkModule);

          case 7: // al.bruno.core.interceptor.RefreshTokenInterceptor 
          return (T) new RefreshTokenInterceptor();

          case 8: // androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> 
          return (T) CoreModule_ProvidesDataStoreFactory.providesDataStore(singletonCImpl.coreModule, ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
