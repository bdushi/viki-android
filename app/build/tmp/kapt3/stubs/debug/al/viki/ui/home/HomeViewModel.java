package al.viki.ui.home;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ*\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u0010\u001a\u00020\u001eH\u0002J*\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00180\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\b\u0010\u0014\u001a\u00020\u001eH\u0002R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lal/viki/ui/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "propertyRepository", "Lal/bruno/core/data/source/PropertyRepository;", "propertyTypeRepository", "Lal/bruno/core/data/source/PropertyTypeRepository;", "userRepository", "Lal/bruno/core/data/source/UserRepository;", "(Lal/bruno/core/data/source/PropertyRepository;Lal/bruno/core/data/source/PropertyTypeRepository;Lal/bruno/core/data/source/UserRepository;)V", "_propertyTypes", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lal/bruno/core/State;", "", "Lal/viki/model/PropertyTypeUi;", "_user", "Lal/viki/model/UserUi;", "propertyTypes", "Lkotlinx/coroutines/flow/StateFlow;", "getPropertyTypes", "()Lkotlinx/coroutines/flow/StateFlow;", "user", "getUser", "propertiesCollectionPagedList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lal/bruno/core/data/source/model/response/PropertyResponse;", "type", "", "searchQuery", "", "", "requestCollectionPagedList", "Lal/bruno/core/data/source/model/response/RequestResponse;", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final al.bruno.core.data.source.PropertyRepository propertyRepository = null;
    private final al.bruno.core.data.source.PropertyTypeRepository propertyTypeRepository = null;
    private final al.bruno.core.data.source.UserRepository userRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<al.bruno.core.State<java.util.List<al.viki.model.PropertyTypeUi>>> _propertyTypes = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.PropertyTypeUi>>> propertyTypes = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<al.bruno.core.State<al.viki.model.UserUi>> _user = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<al.viki.model.UserUi>> user = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    al.bruno.core.data.source.PropertyRepository propertyRepository, @org.jetbrains.annotations.NotNull()
    al.bruno.core.data.source.PropertyTypeRepository propertyTypeRepository, @org.jetbrains.annotations.NotNull()
    al.bruno.core.data.source.UserRepository userRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.PropertyTypeUi>>> getPropertyTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<al.viki.model.UserUi>> getUser() {
        return null;
    }
    
    private final void user() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<al.bruno.core.data.source.model.response.PropertyResponse>> propertiesCollectionPagedList(@org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.CharSequence searchQuery) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<al.bruno.core.data.source.model.response.RequestResponse>> requestCollectionPagedList(@org.jetbrains.annotations.Nullable()
    java.lang.String type, @org.jetbrains.annotations.Nullable()
    java.lang.CharSequence searchQuery) {
        return null;
    }
    
    private final void propertyTypes() {
    }
}