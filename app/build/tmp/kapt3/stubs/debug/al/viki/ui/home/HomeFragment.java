package al.viki.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020-H\u0016J\u001a\u00109\u001a\u00020-2\u0006\u0010:\u001a\u0002012\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u001a\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u0002012\b\b\u0001\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020-2\u0006\u0010:\u001a\u000201H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!R\u0010\u0010#\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\'\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010\r\u001a\u0004\b\'\u0010\u0017R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lal/viki/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lal/viki/databinding/FragmentHomeBinding;", "binding", "getBinding", "()Lal/viki/databinding/FragmentHomeBinding;", "homeViewModel", "Lal/viki/ui/home/HomeViewModel;", "getHomeViewModel", "()Lal/viki/ui/home/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "notifyAuthenticationChange", "Lal/viki/authentication/auth/NotifyAuthenticationChange;", "properties", "", "propertiesAdapter", "Lal/bruno/adapter/PagedListAdapter;", "Lal/bruno/core/data/source/model/response/PropertyResponse;", "Lal/viki/databinding/PropertiesItemBinding;", "getPropertiesAdapter", "()Lal/bruno/adapter/PagedListAdapter;", "propertiesAdapter$delegate", "propertiesLoadStateAdapter", "Lal/bruno/adapter/LoadStateAdapter;", "Lal/viki/databinding/LoadStateFooterViewItemBinding;", "propertyTypeAdapter", "Lal/bruno/adapter/DropDownAdapter;", "Lal/viki/model/PropertyTypeUi;", "Lal/viki/databinding/DropDownItemFilterBinding;", "getPropertyTypeAdapter", "()Lal/bruno/adapter/DropDownAdapter;", "propertyTypeAdapter$delegate", "propertyTypeUi", "requestsAdapter", "Lal/bruno/core/data/source/model/response/RequestResponse;", "Lal/viki/databinding/RequestItemBinding;", "getRequestsAdapter", "requestsAdapter$delegate", "requestsLoadStateAdapter", "userUi", "Lal/viki/model/UserUi;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "showMenu", "v", "menuRes", "", "switchView", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class HomeFragment extends androidx.fragment.app.Fragment {
    private boolean properties = true;
    private al.viki.model.UserUi userUi;
    private al.viki.model.PropertyTypeUi propertyTypeUi;
    private al.viki.databinding.FragmentHomeBinding _binding;
    private al.viki.authentication.auth.NotifyAuthenticationChange notifyAuthenticationChange;
    private final kotlin.Lazy homeViewModel$delegate = null;
    private final al.bruno.adapter.LoadStateAdapter<al.viki.databinding.LoadStateFooterViewItemBinding> propertiesLoadStateAdapter = null;
    private final al.bruno.adapter.LoadStateAdapter<al.viki.databinding.LoadStateFooterViewItemBinding> requestsLoadStateAdapter = null;
    private final kotlin.Lazy propertiesAdapter$delegate = null;
    private final kotlin.Lazy requestsAdapter$delegate = null;
    private final kotlin.Lazy propertyTypeAdapter$delegate = null;
    
    public HomeFragment() {
        super();
    }
    
    private final al.viki.ui.home.HomeViewModel getHomeViewModel() {
        return null;
    }
    
    private final al.bruno.adapter.PagedListAdapter<al.bruno.core.data.source.model.response.PropertyResponse, al.viki.databinding.PropertiesItemBinding> getPropertiesAdapter() {
        return null;
    }
    
    private final al.bruno.adapter.PagedListAdapter<al.bruno.core.data.source.model.response.RequestResponse, al.viki.databinding.RequestItemBinding> getRequestsAdapter() {
        return null;
    }
    
    private final al.bruno.adapter.DropDownAdapter<al.viki.model.PropertyTypeUi, al.viki.databinding.DropDownItemFilterBinding> getPropertyTypeAdapter() {
        return null;
    }
    
    private final al.viki.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void switchView(android.view.View view) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void showMenu(android.view.View v, @androidx.annotation.MenuRes()
    int menuRes) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}