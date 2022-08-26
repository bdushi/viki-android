package al.viki.ui.details;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u0004\u0018\u00018\u00008DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0007R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0014X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u001a0\u001a0\u0014X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lal/viki/ui/details/DetailsFragment;", "T", "Landroidx/databinding/ViewDataBinding;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "get_binding", "()Landroidx/databinding/ViewDataBinding;", "set_binding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "binding", "getBinding", "photoAdapter", "Lal/bruno/adapter/CustomListAdapter;", "Lal/viki/model/PhotoUi;", "Lal/viki/databinding/DetailsPropertyPhotoItemBinding;", "getPhotoAdapter", "()Lal/bruno/adapter/CustomListAdapter;", "requestFilePermissions", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "getRequestFilePermissions", "()Landroidx/activity/result/ActivityResultLauncher;", "startForResult", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getStartForResult", "app_debug"})
public abstract class DetailsFragment<T extends androidx.databinding.ViewDataBinding> extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private T _binding;
    @org.jetbrains.annotations.NotNull()
    private final al.bruno.adapter.CustomListAdapter<al.viki.model.PhotoUi, al.viki.databinding.DetailsPropertyPhotoItemBinding> photoAdapter = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> startForResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestFilePermissions = null;
    
    public DetailsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final T get_binding() {
        return null;
    }
    
    protected final void set_binding(@org.jetbrains.annotations.Nullable()
    T p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final T getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final al.bruno.adapter.CustomListAdapter<al.viki.model.PhotoUi, al.viki.databinding.DetailsPropertyPhotoItemBinding> getPhotoAdapter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getStartForResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> getRequestFilePermissions() {
        return null;
    }
}