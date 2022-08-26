package al.viki.ui.request;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\"\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00120\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00120\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00120\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u001c\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00120\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010\u001e\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u00110\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010\"\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00120\u00110\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010$\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00120\u00110\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010&\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00120\u00110\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010!R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00110\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010*\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00120\u00110\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010!\u00a8\u00060"}, d2 = {"Lal/viki/ui/request/RequestViewModel;", "Landroidx/lifecycle/ViewModel;", "cityRepository", "Lal/bruno/core/data/source/CityRepository;", "currencyRepository", "Lal/bruno/core/data/source/CurrencyRepository;", "floorPlanRepository", "Lal/bruno/core/data/source/FloorPlanRepository;", "propertyTypeRepository", "Lal/bruno/core/data/source/PropertyTypeRepository;", "unitRepository", "Lal/bruno/core/data/source/UnitRepository;", "propertyRepository", "Lal/bruno/core/data/source/PropertyRepository;", "(Lal/bruno/core/data/source/CityRepository;Lal/bruno/core/data/source/CurrencyRepository;Lal/bruno/core/data/source/FloorPlanRepository;Lal/bruno/core/data/source/PropertyTypeRepository;Lal/bruno/core/data/source/UnitRepository;Lal/bruno/core/data/source/PropertyRepository;)V", "_cities", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lal/bruno/core/State;", "", "Lal/viki/model/CityUi;", "_currencies", "Lal/viki/model/CurrencyUi;", "_floorPlans", "Lal/viki/model/FloorPlanUi;", "_propertyTypes", "Lal/viki/model/PropertyTypeUi;", "_request", "", "_units", "Lal/viki/model/UnitUi;", "cities", "Lkotlinx/coroutines/flow/StateFlow;", "getCities", "()Lkotlinx/coroutines/flow/StateFlow;", "currencies", "getCurrencies", "floorPlans", "getFloorPlans", "propertyTypes", "getPropertyTypes", "request", "getRequest", "units", "getUnits", "save", "", "newRequestUi", "Lal/viki/model/NewRequestUi;", "app_debug"})
public final class RequestViewModel extends androidx.lifecycle.ViewModel {
    private final al.bruno.core.data.source.CityRepository cityRepository = null;
    private final al.bruno.core.data.source.CurrencyRepository currencyRepository = null;
    private final al.bruno.core.data.source.FloorPlanRepository floorPlanRepository = null;
    private final al.bruno.core.data.source.PropertyTypeRepository propertyTypeRepository = null;
    private final al.bruno.core.data.source.UnitRepository unitRepository = null;
    private final al.bruno.core.data.source.PropertyRepository propertyRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<al.bruno.core.State<java.util.List<al.viki.model.CityUi>>> _cities = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.CityUi>>> cities = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<al.bruno.core.State<java.util.List<al.viki.model.CurrencyUi>>> _currencies = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.CurrencyUi>>> currencies = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<al.bruno.core.State<java.util.List<al.viki.model.FloorPlanUi>>> _floorPlans = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.FloorPlanUi>>> floorPlans = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<al.bruno.core.State<java.util.List<al.viki.model.PropertyTypeUi>>> _propertyTypes = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.PropertyTypeUi>>> propertyTypes = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<al.bruno.core.State<java.util.List<al.viki.model.UnitUi>>> _units = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.UnitUi>>> units = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<al.bruno.core.State<java.lang.Integer>> _request = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Integer>> request = null;
    
    @javax.inject.Inject()
    public RequestViewModel(@org.jetbrains.annotations.NotNull()
    al.bruno.core.data.source.CityRepository cityRepository, @org.jetbrains.annotations.NotNull()
    al.bruno.core.data.source.CurrencyRepository currencyRepository, @org.jetbrains.annotations.NotNull()
    al.bruno.core.data.source.FloorPlanRepository floorPlanRepository, @org.jetbrains.annotations.NotNull()
    al.bruno.core.data.source.PropertyTypeRepository propertyTypeRepository, @org.jetbrains.annotations.NotNull()
    al.bruno.core.data.source.UnitRepository unitRepository, @org.jetbrains.annotations.NotNull()
    al.bruno.core.data.source.PropertyRepository propertyRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.CityUi>>> getCities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.CurrencyUi>>> getCurrencies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.FloorPlanUi>>> getFloorPlans() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.PropertyTypeUi>>> getPropertyTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.UnitUi>>> getUnits() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Integer>> getRequest() {
        return null;
    }
    
    public final void save(@org.jetbrains.annotations.NotNull()
    al.viki.model.NewRequestUi newRequestUi) {
    }
}