package al.viki.databinding;
import al.viki.R;
import al.viki.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class DropDownItemBindingImpl extends DropDownItemBinding  {

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
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView1;
    @NonNull
    private final androidx.appcompat.widget.AppCompatImageView mboundView2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public DropDownItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private DropDownItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.google.android.material.textview.MaterialTextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (androidx.appcompat.widget.AppCompatImageView) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.selection == variableId) {
            setSelection((al.bruno.adapter.Selection) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSelection(@Nullable al.bruno.adapter.Selection Selection) {
        this.mSelection = Selection;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.selection);
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
        boolean selectionSelection = false;
        int selectionSelectionViewVISIBLEViewGONE = 0;
        java.lang.String selectionSearchCriteria = null;
        al.bruno.adapter.Selection selection = mSelection;

        if ((dirtyFlags & 0x3L) != 0) {



                if (selection != null) {
                    // read selection.selection()
                    selectionSelection = selection.selection();
                    // read selection.searchCriteria()
                    selectionSearchCriteria = selection.searchCriteria();
                }
            if((dirtyFlags & 0x3L) != 0) {
                if(selectionSelection) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }


                // read selection.selection() ? View.VISIBLE : View.GONE
                selectionSelectionViewVISIBLEViewGONE = ((selectionSelection) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, selectionSearchCriteria);
            this.mboundView2.setVisibility(selectionSelectionViewVISIBLEViewGONE);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): selection
        flag 1 (0x2L): null
        flag 2 (0x3L): selection.selection() ? View.VISIBLE : View.GONE
        flag 3 (0x4L): selection.selection() ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}