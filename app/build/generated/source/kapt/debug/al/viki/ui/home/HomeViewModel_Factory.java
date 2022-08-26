package al.viki.ui.home;

import al.bruno.core.data.source.PropertyRepository;
import al.bruno.core.data.source.PropertyTypeRepository;
import al.bruno.core.data.source.UserRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<PropertyRepository> propertyRepositoryProvider;

  private final Provider<PropertyTypeRepository> propertyTypeRepositoryProvider;

  private final Provider<UserRepository> userRepositoryProvider;

  public HomeViewModel_Factory(Provider<PropertyRepository> propertyRepositoryProvider,
      Provider<PropertyTypeRepository> propertyTypeRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider) {
    this.propertyRepositoryProvider = propertyRepositoryProvider;
    this.propertyTypeRepositoryProvider = propertyTypeRepositoryProvider;
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(propertyRepositoryProvider.get(), propertyTypeRepositoryProvider.get(), userRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<PropertyRepository> propertyRepositoryProvider,
      Provider<PropertyTypeRepository> propertyTypeRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider) {
    return new HomeViewModel_Factory(propertyRepositoryProvider, propertyTypeRepositoryProvider, userRepositoryProvider);
  }

  public static HomeViewModel newInstance(PropertyRepository propertyRepository,
      PropertyTypeRepository propertyTypeRepository, UserRepository userRepository) {
    return new HomeViewModel(propertyRepository, propertyTypeRepository, userRepository);
  }
}
