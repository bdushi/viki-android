package al.viki.ui.property;

import java.lang.System;

/**
 * https://firebase.google.com/docs/storage/android/upload-files#kotlin+ktx
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0004H\u0016J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J&\u00100\u001a\u0004\u0018\u00010.2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020,H\u0016J\u001a\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u00105\u001a\u0004\u0018\u000106H\u0017R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010%0%0!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\'\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010%0%0!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!8\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lal/viki/ui/property/NewPropertyFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Lal/bruno/adapter/OnClickListener;", "Lal/viki/model/PhotoUi;", "()V", "_binding", "Lal/viki/databinding/FragmentNewPropertyBinding;", "binding", "getBinding", "()Lal/viki/databinding/FragmentNewPropertyBinding;", "cityAdapter", "Lal/bruno/adapter/DropDownAdapter;", "Lal/viki/model/CityUi;", "Lal/viki/databinding/DropDownItemBinding;", "currencyAdapter", "Lal/viki/model/CurrencyUi;", "newPropertyUi", "Lal/viki/model/NewPropertyUi;", "operationAdapter", "Lal/viki/model/OperationUi;", "photoAdapter", "Lal/bruno/adapter/CustomListAdapter;", "Lal/viki/databinding/NewPropertyPhotoItemBinding;", "propertyTypeAdapter", "Lal/viki/model/PropertyTypeUi;", "propertyViewModel", "Lal/viki/ui/property/PropertyViewModel;", "getPropertyViewModel", "()Lal/viki/ui/property/PropertyViewModel;", "propertyViewModel$delegate", "Lkotlin/Lazy;", "requestFilePermissions", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "requestGallery", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "requestLocation", "requestLocationPermissions", "unitAdapter", "Lal/viki/model/UnitUi;", "onClick", "", "view", "Landroid/view/View;", "t", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class NewPropertyFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener, al.bruno.adapter.OnClickListener<al.viki.model.PhotoUi> {
    private final al.viki.model.NewPropertyUi newPropertyUi = null;
    private final kotlin.Lazy propertyViewModel$delegate = null;
    private al.viki.databinding.FragmentNewPropertyBinding _binding;
    private final al.bruno.adapter.DropDownAdapter<al.viki.model.CityUi, al.viki.databinding.DropDownItemBinding> cityAdapter = null;
    private final al.bruno.adapter.DropDownAdapter<al.viki.model.CurrencyUi, al.viki.databinding.DropDownItemBinding> currencyAdapter = null;
    private final al.bruno.adapter.DropDownAdapter<al.viki.model.PropertyTypeUi, al.viki.databinding.DropDownItemBinding> propertyTypeAdapter = null;
    private final al.bruno.adapter.DropDownAdapter<al.viki.model.UnitUi, al.viki.databinding.DropDownItemBinding> unitAdapter = null;
    private final al.bruno.adapter.DropDownAdapter<al.viki.model.OperationUi, al.viki.databinding.DropDownItemBinding> operationAdapter = null;
    private final al.bruno.adapter.CustomListAdapter<al.viki.model.PhotoUi, al.viki.databinding.NewPropertyPhotoItemBinding> photoAdapter = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> requestLocation = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> requestGallery = null;
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestLocationPermissions = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestFilePermissions = null;
    
    public NewPropertyFragment() {
        super();
    }
    
    private final al.viki.ui.property.PropertyViewModel getPropertyViewModel() {
        return null;
    }
    
    private final al.viki.databinding.FragmentNewPropertyBinding getBinding() {
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
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    al.viki.model.PhotoUi t) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
    }
}