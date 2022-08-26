package al.viki.databinding;
import al.viki.R;
import al.viki.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentPropertyDetailsBindingImpl extends FragmentPropertyDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.details_property_app_bar_layout, 9);
        sViewsWithIds.put(R.id.top_app_bar, 10);
        sViewsWithIds.put(R.id.details_property_description_label, 11);
        sViewsWithIds.put(R.id.details_property_location_in_map_label, 12);
        sViewsWithIds.put(R.id.details_property_agent_label, 13);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentPropertyDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }
    private FragmentPropertyDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.textview.MaterialTextView) bindings[8]
            , (com.google.android.material.textview.MaterialTextView) bindings[13]
            , (com.google.android.material.appbar.AppBarLayout) bindings[9]
            , (com.google.android.material.textview.MaterialTextView) bindings[7]
            , (com.google.android.material.textview.MaterialTextView) bindings[11]
            , (androidx.viewpager2.widget.ViewPager2) bindings[1]
            , (com.google.android.material.tabs.TabLayout) bindings[2]
            , (com.google.android.material.textview.MaterialTextView) bindings[12]
            , (com.google.android.material.textview.MaterialTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[3]
            , (com.google.android.material.textview.MaterialTextView) bindings[5]
            , (com.google.android.material.textview.MaterialTextView) bindings[6]
            , (android.widget.LinearLayout) bindings[0]
            , (com.google.android.material.appbar.MaterialToolbar) bindings[10]
            );
        this.detailsPropertyAgent.setTag(null);
        this.detailsPropertyDescription.setTag(null);
        this.detailsPropertyItem.setTag(null);
        this.detailsPropertyItemDotIndicator.setTag(null);
        this.detailsPropertyOperation.setTag(null);
        this.detailsPropertyPhotoError.setTag(null);
        this.detailsPropertyPrice.setTag(null);
        this.detailsPropertyPricePerUnit.setTag(null);
        this.detailsPropertyRoot.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.property == variableId) {
            setProperty((al.viki.model.PropertyUi) variable);
        }
        else if (BR.isNotEmpty == variableId) {
            setIsNotEmpty((androidx.databinding.ObservableBoolean) variable);
        }
        else if (BR.adapter == variableId) {
            setAdapter((androidx.recyclerview.widget.ListAdapter) variable);
        }
        else if (BR.onClick == variableId) {
            setOnClick((android.view.View.OnClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setProperty(@Nullable al.viki.model.PropertyUi Property) {
        this.mProperty = Property;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.property);
        super.requestRebind();
    }
    public void setIsNotEmpty(@Nullable androidx.databinding.ObservableBoolean IsNotEmpty) {
        updateRegistration(0, IsNotEmpty);
        this.mIsNotEmpty = IsNotEmpty;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.isNotEmpty);
        super.requestRebind();
    }
    public void setAdapter(@Nullable androidx.recyclerview.widget.ListAdapter Adapter) {
        this.mAdapter = Adapter;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
    }
    public void setOnClick(@Nullable android.view.View.OnClickListener OnClick) {
        this.mOnClick = OnClick;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeIsNotEmpty((androidx.databinding.ObservableBoolean) object, fieldId);
        }
        return false;
    }
    private boolean onChangeIsNotEmpty(androidx.databinding.ObservableBoolean IsNotEmpty, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
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
        boolean isNotEmptyGet = false;
        java.lang.String detailsPropertyPriceAndroidStringPriceItemPropertyPricePropertyAreaPropertyCode = null;
        java.lang.String propertyFirstName = null;
        int isNotEmptyViewVISIBLEViewGONE = 0;
        java.lang.String detailsPropertyPricePerUnitAndroidStringPriceItemPerUnitPropertyPricePropertyCodePropertyUnit = null;
        java.lang.String propertyOperation = null;
        double propertyPrice = 0.0;
        int isNotEmptyViewGONEViewVISIBLE = 0;
        double propertyArea = 0.0;
        al.viki.model.PropertyUi property = mProperty;
        double propertyPricePropertyArea = 0.0;
        androidx.databinding.ObservableBoolean isNotEmpty = mIsNotEmpty;
        java.lang.String detailsPropertyAgentAndroidStringAgentItemPropertyFirstNamePropertyLastName = null;
        java.lang.String propertyLastName = null;
        androidx.recyclerview.widget.ListAdapter<?,? extends androidx.recyclerview.widget.RecyclerView.ViewHolder> adapter = mAdapter;
        java.lang.String propertyDescription = null;
        java.lang.String propertyUnit = null;
        java.lang.String propertyCode = null;

        if ((dirtyFlags & 0x12L) != 0) {



                if (property != null) {
                    // read property.firstName
                    propertyFirstName = property.getFirstName();
                    // read property.operation
                    propertyOperation = property.getOperation();
                    // read property.price
                    propertyPrice = property.getPrice();
                    // read property.area
                    propertyArea = property.getArea();
                    // read property.lastName
                    propertyLastName = property.getLastName();
                    // read property.description
                    propertyDescription = property.getDescription();
                    // read property.unit
                    propertyUnit = property.getUnit();
                    // read property.code
                    propertyCode = property.getCode();
                }


                // read (property.price) * (property.area)
                propertyPricePropertyArea = (propertyPrice) * (propertyArea);
                // read @android:string/agent_item
                detailsPropertyAgentAndroidStringAgentItemPropertyFirstNamePropertyLastName = detailsPropertyAgent.getResources().getString(R.string.agent_item, propertyFirstName, propertyLastName);
                // read @android:string/price_item_per_unit
                detailsPropertyPricePerUnitAndroidStringPriceItemPerUnitPropertyPricePropertyCodePropertyUnit = detailsPropertyPricePerUnit.getResources().getString(R.string.price_item_per_unit, propertyPrice, propertyCode, propertyUnit);


                // read @android:string/price_item
                detailsPropertyPriceAndroidStringPriceItemPropertyPricePropertyAreaPropertyCode = detailsPropertyPrice.getResources().getString(R.string.price_item, propertyPricePropertyArea, propertyCode);
        }
        if ((dirtyFlags & 0x11L) != 0) {



                if (isNotEmpty != null) {
                    // read isNotEmpty.get()
                    isNotEmptyGet = isNotEmpty.get();
                }
            if((dirtyFlags & 0x11L) != 0) {
                if(isNotEmptyGet) {
                        dirtyFlags |= 0x40L;
                        dirtyFlags |= 0x100L;
                }
                else {
                        dirtyFlags |= 0x20L;
                        dirtyFlags |= 0x80L;
                }
            }


                // read isNotEmpty.get() ? View.VISIBLE : View.GONE
                isNotEmptyViewVISIBLEViewGONE = ((isNotEmptyGet) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read isNotEmpty.get() ? View.GONE : View.VISIBLE
                isNotEmptyViewGONEViewVISIBLE = ((isNotEmptyGet) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
        }
        if ((dirtyFlags & 0x14L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x12L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.detailsPropertyAgent, detailsPropertyAgentAndroidStringAgentItemPropertyFirstNamePropertyLastName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.detailsPropertyDescription, propertyDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.detailsPropertyOperation, propertyOperation);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.detailsPropertyPrice, detailsPropertyPriceAndroidStringPriceItemPropertyPricePropertyAreaPropertyCode);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.detailsPropertyPricePerUnit, detailsPropertyPricePerUnitAndroidStringPriceItemPerUnitPropertyPricePropertyCodePropertyUnit);
        }
        if ((dirtyFlags & 0x14L) != 0) {
            // api target 1

            this.detailsPropertyItem.setAdapter(adapter);
        }
        if ((dirtyFlags & 0x11L) != 0) {
            // api target 1

            this.detailsPropertyItem.setVisibility(isNotEmptyViewGONEViewVISIBLE);
            this.detailsPropertyItemDotIndicator.setVisibility(isNotEmptyViewGONEViewVISIBLE);
            this.detailsPropertyPhotoError.setVisibility(isNotEmptyViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            al.viki.foundation.binding.util.Adapter.error(this.detailsPropertyPhotoError, androidx.appcompat.content.res.AppCompatResources.getDrawable(detailsPropertyPhotoError.getContext(), al.viki.foundation.R.drawable.ic_outline_image_not_supported));
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): isNotEmpty
        flag 1 (0x2L): property
        flag 2 (0x3L): adapter
        flag 3 (0x4L): onClick
        flag 4 (0x5L): null
        flag 5 (0x6L): isNotEmpty.get() ? View.VISIBLE : View.GONE
        flag 6 (0x7L): isNotEmpty.get() ? View.VISIBLE : View.GONE
        flag 7 (0x8L): isNotEmpty.get() ? View.GONE : View.VISIBLE
        flag 8 (0x9L): isNotEmpty.get() ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}