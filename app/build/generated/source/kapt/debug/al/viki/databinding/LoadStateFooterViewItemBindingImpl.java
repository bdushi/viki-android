package al.viki.databinding;
import al.viki.R;
import al.viki.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class LoadStateFooterViewItemBindingImpl extends LoadStateFooterViewItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mOnClickOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers

    public LoadStateFooterViewItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private LoadStateFooterViewItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[2]
            , (android.widget.ProgressBar) bindings[1]
            , (android.widget.Button) bindings[3]
            );
        this.errorMsg.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.progressBar.setTag(null);
        this.retryButton.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.loadState == variableId) {
            setLoadState((androidx.paging.LoadState) variable);
        }
        else if (BR.onClick == variableId) {
            setOnClick((android.view.View.OnClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLoadState(@Nullable androidx.paging.LoadState LoadState) {
        this.mLoadState = LoadState;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.loadState);
        super.requestRebind();
    }
    public void setOnClick(@Nullable android.view.View.OnClickListener OnClick) {
        this.mOnClick = OnClick;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.onClick);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        boolean loadStateInstanceofAndroidxPagingLoadStateError = false;
        int loadStateInstanceofAndroidxPagingLoadStateErrorViewVISIBLEViewGONE = 0;
        androidx.paging.LoadState loadState = mLoadState;
        int loadStateInstanceofAndroidxPagingLoadStateLoadingViewVISIBLEViewGONE = 0;
        android.view.View.OnClickListener onClickOnClickAndroidViewViewOnClickListener = null;
        boolean loadStateInstanceofAndroidxPagingLoadStateLoading = false;
        android.view.View.OnClickListener onClick = mOnClick;

        if ((dirtyFlags & 0x5L) != 0) {



                // read loadState instanceof androidx.paging.LoadState.Error
                loadStateInstanceofAndroidxPagingLoadStateError = loadState instanceof androidx.paging.LoadState.Error;
                // read loadState instanceof androidx.paging.LoadState.Loading
                loadStateInstanceofAndroidxPagingLoadStateLoading = loadState instanceof androidx.paging.LoadState.Loading;
            if((dirtyFlags & 0x5L) != 0) {
                if(loadStateInstanceofAndroidxPagingLoadStateError) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }
            if((dirtyFlags & 0x5L) != 0) {
                if(loadStateInstanceofAndroidxPagingLoadStateLoading) {
                        dirtyFlags |= 0x40L;
                }
                else {
                        dirtyFlags |= 0x20L;
                }
            }


                // read loadState instanceof androidx.paging.LoadState.Error ? View.VISIBLE : View.GONE
                loadStateInstanceofAndroidxPagingLoadStateErrorViewVISIBLEViewGONE = ((loadStateInstanceofAndroidxPagingLoadStateError) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read loadState instanceof androidx.paging.LoadState.Loading ? View.VISIBLE : View.GONE
                loadStateInstanceofAndroidxPagingLoadStateLoadingViewVISIBLEViewGONE = ((loadStateInstanceofAndroidxPagingLoadStateLoading) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (onClick != null) {
                    // read onClick::onClick
                    onClickOnClickAndroidViewViewOnClickListener = (((mOnClickOnClickAndroidViewViewOnClickListener == null) ? (mOnClickOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mOnClickOnClickAndroidViewViewOnClickListener).setValue(onClick));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            this.errorMsg.setVisibility(loadStateInstanceofAndroidxPagingLoadStateErrorViewVISIBLEViewGONE);
            this.progressBar.setVisibility(loadStateInstanceofAndroidxPagingLoadStateLoadingViewVISIBLEViewGONE);
            this.retryButton.setVisibility(loadStateInstanceofAndroidxPagingLoadStateErrorViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            this.retryButton.setOnClickListener(onClickOnClickAndroidViewViewOnClickListener);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private android.view.View.OnClickListener value;
        public OnClickListenerImpl setValue(android.view.View.OnClickListener value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onClick(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): loadState
        flag 1 (0x2L): onClick
        flag 2 (0x3L): null
        flag 3 (0x4L): loadState instanceof androidx.paging.LoadState.Error ? View.VISIBLE : View.GONE
        flag 4 (0x5L): loadState instanceof androidx.paging.LoadState.Error ? View.VISIBLE : View.GONE
        flag 5 (0x6L): loadState instanceof androidx.paging.LoadState.Loading ? View.VISIBLE : View.GONE
        flag 6 (0x7L): loadState instanceof androidx.paging.LoadState.Loading ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}