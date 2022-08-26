package al.viki.databinding;
import al.viki.R;
import al.viki.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PropertiesItemBindingImpl extends PropertiesItemBinding implements al.viki.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.properties_item_info, 11);
    }
    // views
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView10;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView7;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView8;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView9;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback8;
    @Nullable
    private final android.view.View.OnClickListener mCallback10;
    @Nullable
    private final android.view.View.OnClickListener mCallback9;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PropertiesItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private PropertiesItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.card.MaterialCardView) bindings[0]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[2]
            , (com.google.android.material.textview.MaterialTextView) bindings[6]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[3]
            , (android.widget.LinearLayout) bindings[11]
            , (com.google.android.material.textview.MaterialTextView) bindings[5]
            , (com.google.android.material.textview.MaterialTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[1]
            );
        this.mboundView10 = (com.google.android.material.textview.MaterialTextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView7 = (com.google.android.material.textview.MaterialTextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (com.google.android.material.textview.MaterialTextView) bindings[8];
        this.mboundView8.setTag(null);
        this.mboundView9 = (com.google.android.material.textview.MaterialTextView) bindings[9];
        this.mboundView9.setTag(null);
        this.properties.setTag(null);
        this.propertiesDeleteItem.setTag(null);
        this.propertiesItemAddress.setTag(null);
        this.propertiesItemImage.setTag(null);
        this.propertiesItemPrice.setTag(null);
        this.propertiesItemTitle.setTag(null);
        this.propertiesShareItem.setTag(null);
        setRootTag(root);
        // listeners
        mCallback8 = new al.viki.generated.callback.OnClickListener(this, 1);
        mCallback10 = new al.viki.generated.callback.OnClickListener(this, 3);
        mCallback9 = new al.viki.generated.callback.OnClickListener(this, 2);
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
        if (BR.property == variableId) {
            setProperty((al.bruno.core.data.source.model.response.PropertyResponse) variable);
        }
        else if (BR.onClick == variableId) {
            setOnClick((al.bruno.adapter.OnClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setProperty(@Nullable al.bruno.core.data.source.model.response.PropertyResponse Property) {
        this.mProperty = Property;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.property);
        super.requestRebind();
    }
    public void setOnClick(@Nullable al.bruno.adapter.OnClickListener OnClick) {
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
        java.lang.String propertyFloorPlan = null;
        java.lang.String mboundView8AndroidStringAreaItemPropertyAreaPropertyUnit = null;
        long propertyId = 0;
        java.lang.String propertiesItemPriceAndroidStringPriceItemPropertyPricePropertyAreaPropertyCode = null;
        java.lang.String propertyOperation = null;
        int propertyFloorPlanJavaLangObjectNullViewVISIBLEViewGONE = 0;
        double propertyPrice = 0.0;
        double propertyArea = 0.0;
        al.bruno.core.data.source.model.response.PropertyResponse property = mProperty;
        double propertyPricePropertyArea = 0.0;
        boolean propertyFloorPlanJavaLangObjectNull = false;
        java.lang.String propertyAddress = null;
        java.lang.String propertyTitle = null;
        al.bruno.adapter.OnClickListener<?> onClick = mOnClick;
        java.lang.String propertyUnit = null;
        java.lang.String mboundView9AndroidStringPriceItemPerUnitPropertyPricePropertyCodePropertyUnit = null;
        java.lang.String propertyCode = null;

        if ((dirtyFlags & 0x5L) != 0) {



                if (property != null) {
                    // read property.floorPlan
                    propertyFloorPlan = property.getFloorPlan();
                    // read property.id
                    propertyId = property.getId();
                    // read property.operation
                    propertyOperation = property.getOperation();
                    // read property.price
                    propertyPrice = property.getPrice();
                    // read property.area
                    propertyArea = property.getArea();
                    // read property.address
                    propertyAddress = property.getAddress();
                    // read property.title
                    propertyTitle = property.getTitle();
                    // read property.unit
                    propertyUnit = property.getUnit();
                    // read property.code
                    propertyCode = property.getCode();
                }


                // read property.floorPlan != null
                propertyFloorPlanJavaLangObjectNull = (propertyFloorPlan) != (null);
                // read (property.price) * (property.area)
                propertyPricePropertyArea = (propertyPrice) * (propertyArea);
                // read @android:string/area_item
                mboundView8AndroidStringAreaItemPropertyAreaPropertyUnit = mboundView8.getResources().getString(R.string.area_item, propertyArea, propertyUnit);
                // read @android:string/price_item_per_unit
                mboundView9AndroidStringPriceItemPerUnitPropertyPricePropertyCodePropertyUnit = mboundView9.getResources().getString(R.string.price_item_per_unit, propertyPrice, propertyCode, propertyUnit);
            if((dirtyFlags & 0x5L) != 0) {
                if(propertyFloorPlanJavaLangObjectNull) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read property.floorPlan != null ? View.VISIBLE : View.GONE
                propertyFloorPlanJavaLangObjectNullViewVISIBLEViewGONE = ((propertyFloorPlanJavaLangObjectNull) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read @android:string/price_item
                propertiesItemPriceAndroidStringPriceItemPropertyPricePropertyAreaPropertyCode = propertiesItemPrice.getResources().getString(R.string.price_item, propertyPricePropertyArea, propertyCode);
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView10, propertyOperation);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, propertyFloorPlan);
            this.mboundView7.setVisibility(propertyFloorPlanJavaLangObjectNullViewVISIBLEViewGONE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, mboundView8AndroidStringAreaItemPropertyAreaPropertyUnit);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, mboundView9AndroidStringPriceItemPerUnitPropertyPricePropertyCodePropertyUnit);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.propertiesItemAddress, propertyAddress);
            al.viki.foundation.binding.util.Adapter.bindCloudImage(this.propertiesItemImage, propertyId);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.propertiesItemPrice, propertiesItemPriceAndroidStringPriceItemPropertyPricePropertyAreaPropertyCode);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.propertiesItemTitle, propertyTitle);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.properties.setOnClickListener(mCallback8);
            this.propertiesDeleteItem.setOnClickListener(mCallback10);
            this.propertiesShareItem.setOnClickListener(mCallback9);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // property
                al.bruno.core.data.source.model.response.PropertyResponse property = mProperty;
                // onClick != null
                boolean onClickJavaLangObjectNull = false;
                // onClick
                al.bruno.adapter.OnClickListener onClick = mOnClick;



                onClickJavaLangObjectNull = (onClick) != (null);
                if (onClickJavaLangObjectNull) {




                    onClick.onClick(callbackArg_0, property);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // property
                al.bruno.core.data.source.model.response.PropertyResponse property = mProperty;
                // onClick != null
                boolean onClickJavaLangObjectNull = false;
                // onClick
                al.bruno.adapter.OnClickListener onClick = mOnClick;



                onClickJavaLangObjectNull = (onClick) != (null);
                if (onClickJavaLangObjectNull) {




                    onClick.onClick(callbackArg_0, property);
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // property
                al.bruno.core.data.source.model.response.PropertyResponse property = mProperty;
                // onClick != null
                boolean onClickJavaLangObjectNull = false;
                // onClick
                al.bruno.adapter.OnClickListener onClick = mOnClick;



                onClickJavaLangObjectNull = (onClick) != (null);
                if (onClickJavaLangObjectNull) {




                    onClick.onClick(callbackArg_0, property);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): property
        flag 1 (0x2L): onClick
        flag 2 (0x3L): null
        flag 3 (0x4L): property.floorPlan != null ? View.VISIBLE : View.GONE
        flag 4 (0x5L): property.floorPlan != null ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}