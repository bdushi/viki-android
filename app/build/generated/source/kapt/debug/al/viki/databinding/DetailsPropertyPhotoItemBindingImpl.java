package al.viki.databinding;
import al.viki.R;
import al.viki.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DetailsPropertyPhotoItemBindingImpl extends DetailsPropertyPhotoItemBinding implements al.viki.generated.callback.OnClickListener.Listener {

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
    private final androidx.appcompat.widget.AppCompatImageView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DetailsPropertyPhotoItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 1, sIncludes, sViewsWithIds));
    }
    private DetailsPropertyPhotoItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            );
        this.mboundView0 = (androidx.appcompat.widget.AppCompatImageView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback4 = new al.viki.generated.callback.OnClickListener(this, 1);
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
        if (BR.onClick == variableId) {
            setOnClick((al.bruno.adapter.OnClickListener) variable);
        }
        else if (BR.photo == variableId) {
            setPhoto((al.viki.model.PhotoUi) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setOnClick(@Nullable al.bruno.adapter.OnClickListener OnClick) {
        this.mOnClick = OnClick;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.onClick);
        super.requestRebind();
    }
    public void setPhoto(@Nullable al.viki.model.PhotoUi Photo) {
        this.mPhoto = Photo;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.photo);
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
        al.bruno.adapter.OnClickListener<?> onClick = mOnClick;
        java.lang.String photoPhoto = null;
        al.viki.model.PhotoUi photo = mPhoto;

        if ((dirtyFlags & 0x6L) != 0) {



                if (photo != null) {
                    // read photo.photo
                    photoPhoto = photo.getPhoto();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.mboundView0.setOnClickListener(mCallback4);
        }
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            al.viki.foundation.binding.util.Adapter.bindImage(this.mboundView0, photoPhoto);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // onClick != null
        boolean onClickJavaLangObjectNull = false;
        // onClick
        al.bruno.adapter.OnClickListener onClick = mOnClick;
        // photo
        al.viki.model.PhotoUi photo = mPhoto;



        onClickJavaLangObjectNull = (onClick) != (null);
        if (onClickJavaLangObjectNull) {




            onClick.onClick(callbackArg_0, photo);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): onClick
        flag 1 (0x2L): photo
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}