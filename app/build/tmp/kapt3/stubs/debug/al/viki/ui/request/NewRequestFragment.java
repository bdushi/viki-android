package al.viki.ui.request;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\u001a\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\"2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0017R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00140\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00138\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lal/viki/ui/request/NewRequestFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lal/viki/databinding/FragmentNewRequestBinding;", "binding", "getBinding", "()Lal/viki/databinding/FragmentNewRequestBinding;", "cityAdapter", "Lal/bruno/adapter/DropDownAdapter;", "Lal/viki/model/CityUi;", "Lal/viki/databinding/DropDownItemBinding;", "currencyAdapter", "Lal/viki/model/CurrencyUi;", "newRequestUi", "Lal/viki/model/NewRequestUi;", "propertyTypeAdapter", "Lal/viki/model/PropertyTypeUi;", "requestLocation", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "requestLocationPermissions", "", "", "requestViewModel", "Lal/viki/ui/request/RequestViewModel;", "getRequestViewModel", "()Lal/viki/ui/request/RequestViewModel;", "requestViewModel$delegate", "Lkotlin/Lazy;", "unitAdapter", "Lal/viki/model/UnitUi;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class NewRequestFragment extends androidx.fragment.app.Fragment {
    private final al.viki.model.NewRequestUi newRequestUi = null;
    private final kotlin.Lazy requestViewModel$delegate = null;
    private al.viki.databinding.FragmentNewRequestBinding _binding;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> requestLocation = null;
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestLocationPermissions = null;
    private final al.bruno.adapter.DropDownAdapter<al.viki.model.CityUi, al.viki.databinding.DropDownItemBinding> cityAdapter = null;
    private final al.bruno.adapter.DropDownAdapter<al.viki.model.CurrencyUi, al.viki.databinding.DropDownItemBinding> currencyAdapter = null;
    private final al.bruno.adapter.DropDownAdapter<al.viki.model.PropertyTypeUi, al.viki.databinding.DropDownItemBinding> propertyTypeAdapter = null;
    private final al.bruno.adapter.DropDownAdapter<al.viki.model.UnitUi, al.viki.databinding.DropDownItemBinding> unitAdapter = null;
    
    public NewRequestFragment() {
        super();
    }
    
    private final al.viki.ui.request.RequestViewModel getRequestViewModel() {
        return null;
    }
    
    private final al.viki.databinding.FragmentNewRequestBinding getBinding() {
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
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}