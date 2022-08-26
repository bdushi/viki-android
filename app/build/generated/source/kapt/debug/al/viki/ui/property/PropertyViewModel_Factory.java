package al.viki.ui.property;

import al.bruno.core.data.source.CityRepository;
import al.bruno.core.data.source.CurrencyRepository;
import al.bruno.core.data.source.OperationRepository;
import al.bruno.core.data.source.PropertyRepository;
import al.bruno.core.data.source.PropertyTypeRepository;
import al.bruno.core.data.source.UnitRepository;
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
public final class PropertyViewModel_Factory implements Factory<PropertyViewModel> {
  private final Provider<CityRepository> cityRepositoryProvider;

  private final Provider<CurrencyRepository> currencyRepositoryProvider;

  private final Provider<OperationRepository> operationRepositoryProvider;

  private final Provider<PropertyTypeRepository> propertyTypeRepositoryProvider;

  private final Provider<UnitRepository> unitRepositoryProvider;

  private final Provider<PropertyRepository> propertyRepositoryProvider;

  public PropertyViewModel_Factory(Provider<CityRepository> cityRepositoryProvider,
      Provider<CurrencyRepository> currencyRepositoryProvider,
      Provider<OperationRepository> operationRepositoryProvider,
      Provider<PropertyTypeRepository> propertyTypeRepositoryProvider,
      Provider<UnitRepository> unitRepositoryProvider,
      Provider<PropertyRepository> propertyRepositoryProvider) {
    this.cityRepositoryProvider = cityRepositoryProvider;
    this.currencyRepositoryProvider = currencyRepositoryProvider;
    this.operationRepositoryProvider = operationRepositoryProvider;
    this.propertyTypeRepositoryProvider = propertyTypeRepositoryProvider;
    this.unitRepositoryProvider = unitRepositoryProvider;
    this.propertyRepositoryProvider = propertyRepositoryProvider;
  }

  @Override
  public PropertyViewModel get() {
    return newInstance(cityRepositoryProvider.get(), currencyRepositoryProvider.get(), operationRepositoryProvider.get(), propertyTypeRepositoryProvider.get(), unitRepositoryProvider.get(), propertyRepositoryProvider.get());
  }

  public static PropertyViewModel_Factory create(Provider<CityRepository> cityRepositoryProvider,
      Provider<CurrencyRepository> currencyRepositoryProvider,
      Provider<OperationRepository> operationRepositoryProvider,
      Provider<PropertyTypeRepository> propertyTypeRepositoryProvider,
      Provider<UnitRepository> unitRepositoryProvider,
      Provider<PropertyRepository> propertyRepositoryProvider) {
    return new PropertyViewModel_Factory(cityRepositoryProvider, currencyRepositoryProvider, operationRepositoryProvider, propertyTypeRepositoryProvider, unitRepositoryProvider, propertyRepositoryProvider);
  }

  public static PropertyViewModel newInstance(CityRepository cityRepository,
      CurrencyRepository currencyRepository, OperationRepository operationRepository,
      PropertyTypeRepository propertyTypeRepository, UnitRepository unitRepository,
      PropertyRepository propertyRepository) {
    return new PropertyViewModel(cityRepository, currencyRepository, operationRepository, propertyTypeRepository, unitRepository, propertyRepository);
  }
}
