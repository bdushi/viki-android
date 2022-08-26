package al.viki.ui.request;

import al.bruno.core.data.source.CityRepository;
import al.bruno.core.data.source.CurrencyRepository;
import al.bruno.core.data.source.FloorPlanRepository;
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
public final class RequestViewModel_Factory implements Factory<RequestViewModel> {
  private final Provider<CityRepository> cityRepositoryProvider;

  private final Provider<CurrencyRepository> currencyRepositoryProvider;

  private final Provider<FloorPlanRepository> floorPlanRepositoryProvider;

  private final Provider<PropertyTypeRepository> propertyTypeRepositoryProvider;

  private final Provider<UnitRepository> unitRepositoryProvider;

  private final Provider<PropertyRepository> propertyRepositoryProvider;

  public RequestViewModel_Factory(Provider<CityRepository> cityRepositoryProvider,
      Provider<CurrencyRepository> currencyRepositoryProvider,
      Provider<FloorPlanRepository> floorPlanRepositoryProvider,
      Provider<PropertyTypeRepository> propertyTypeRepositoryProvider,
      Provider<UnitRepository> unitRepositoryProvider,
      Provider<PropertyRepository> propertyRepositoryProvider) {
    this.cityRepositoryProvider = cityRepositoryProvider;
    this.currencyRepositoryProvider = currencyRepositoryProvider;
    this.floorPlanRepositoryProvider = floorPlanRepositoryProvider;
    this.propertyTypeRepositoryProvider = propertyTypeRepositoryProvider;
    this.unitRepositoryProvider = unitRepositoryProvider;
    this.propertyRepositoryProvider = propertyRepositoryProvider;
  }

  @Override
  public RequestViewModel get() {
    return newInstance(cityRepositoryProvider.get(), currencyRepositoryProvider.get(), floorPlanRepositoryProvider.get(), propertyTypeRepositoryProvider.get(), unitRepositoryProvider.get(), propertyRepositoryProvider.get());
  }

  public static RequestViewModel_Factory create(Provider<CityRepository> cityRepositoryProvider,
      Provider<CurrencyRepository> currencyRepositoryProvider,
      Provider<FloorPlanRepository> floorPlanRepositoryProvider,
      Provider<PropertyTypeRepository> propertyTypeRepositoryProvider,
      Provider<UnitRepository> unitRepositoryProvider,
      Provider<PropertyRepository> propertyRepositoryProvider) {
    return new RequestViewModel_Factory(cityRepositoryProvider, currencyRepositoryProvider, floorPlanRepositoryProvider, propertyTypeRepositoryProvider, unitRepositoryProvider, propertyRepositoryProvider);
  }

  public static RequestViewModel newInstance(CityRepository cityRepository,
      CurrencyRepository currencyRepository, FloorPlanRepository floorPlanRepository,
      PropertyTypeRepository propertyTypeRepository, UnitRepository unitRepository,
      PropertyRepository propertyRepository) {
    return new RequestViewModel(cityRepository, currencyRepository, floorPlanRepository, propertyTypeRepository, unitRepository, propertyRepository);
  }
}
