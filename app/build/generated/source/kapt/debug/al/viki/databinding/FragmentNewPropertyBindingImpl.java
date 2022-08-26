package al.viki.databinding;
import al.viki.R;
import al.viki.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentNewPropertyBindingImpl extends FragmentNewPropertyBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.new_property_app_bar_layout, 17);
        sViewsWithIds.put(R.id.top_app_bar, 18);
        sViewsWithIds.put(R.id.new_property_scroll_view, 19);
        sViewsWithIds.put(R.id.new_property_title, 20);
        sViewsWithIds.put(R.id.new_property_description, 21);
        sViewsWithIds.put(R.id.new_property_type, 22);
        sViewsWithIds.put(R.id.new_property_operation, 23);
        sViewsWithIds.put(R.id.new_property_price, 24);
        sViewsWithIds.put(R.id.new_property_currency, 25);
        sViewsWithIds.put(R.id.new_property_area, 26);
        sViewsWithIds.put(R.id.new_property_unit, 27);
        sViewsWithIds.put(R.id.new_property_address, 28);
        sViewsWithIds.put(R.id.new_property_city, 29);
    }
    // views
    @NonNull
    private final android.widget.ProgressBar mboundView1;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView11;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView13;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView3;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView4;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView9;
    // variables
    // values
    // listeners
    private OnItemClickListenerImpl mNewPropertyCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener;
    private OnItemClickListenerImpl1 mNewPropertyCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener;
    private OnItemClickListenerImpl2 mNewPropertyOperationListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener;
    private OnItemClickListenerImpl3 mNewPropertyPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener;
    private OnItemClickListenerImpl4 mNewPropertyUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener;
    private OnClickListenerImpl mOnClickOnClickAndroidViewViewOnClickListener;
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView11androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newProperty.area
            //         is newProperty.setArea((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView11);
            // localize variables for thread safety
            // newProperty.area
            java.lang.String newPropertyArea = null;
            // newProperty != null
            boolean newPropertyJavaLangObjectNull = false;
            // newProperty
            al.viki.model.NewPropertyUi newProperty = mNewProperty;



            newPropertyJavaLangObjectNull = (newProperty) != (null);
            if (newPropertyJavaLangObjectNull) {




                newProperty.setArea(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView13androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newProperty.address
            //         is newProperty.setAddress((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView13);
            // localize variables for thread safety
            // newProperty != null
            boolean newPropertyJavaLangObjectNull = false;
            // newProperty.address
            java.lang.String newPropertyAddress = null;
            // newProperty
            al.viki.model.NewPropertyUi newProperty = mNewProperty;



            newPropertyJavaLangObjectNull = (newProperty) != (null);
            if (newPropertyJavaLangObjectNull) {




                newProperty.setAddress(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newProperty.title
            //         is newProperty.setTitle((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // newProperty != null
            boolean newPropertyJavaLangObjectNull = false;
            // newProperty.title
            java.lang.String newPropertyTitle = null;
            // newProperty
            al.viki.model.NewPropertyUi newProperty = mNewProperty;



            newPropertyJavaLangObjectNull = (newProperty) != (null);
            if (newPropertyJavaLangObjectNull) {




                newProperty.setTitle(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newProperty.description
            //         is newProperty.setDescription((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // newProperty != null
            boolean newPropertyJavaLangObjectNull = false;
            // newProperty.description
            java.lang.String newPropertyDescription = null;
            // newProperty
            al.viki.model.NewPropertyUi newProperty = mNewProperty;



            newPropertyJavaLangObjectNull = (newProperty) != (null);
            if (newPropertyJavaLangObjectNull) {




                newProperty.setDescription(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView9androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newProperty.price
            //         is newProperty.setPrice((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView9);
            // localize variables for thread safety
            // newProperty != null
            boolean newPropertyJavaLangObjectNull = false;
            // newProperty.price
            java.lang.String newPropertyPrice = null;
            // newProperty
            al.viki.model.NewPropertyUi newProperty = mNewProperty;



            newPropertyJavaLangObjectNull = (newProperty) != (null);
            if (newPropertyJavaLangObjectNull) {




                newProperty.setPrice(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener newPropertyFloorPlanItemandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newProperty.floorPlan
            //         is newProperty.setFloorPlan((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(newPropertyFloorPlanItem);
            // localize variables for thread safety
            // newProperty != null
            boolean newPropertyJavaLangObjectNull = false;
            // newProperty
            al.viki.model.NewPropertyUi newProperty = mNewProperty;
            // newProperty.floorPlan
            java.lang.String newPropertyFloorPlan = null;



            newPropertyJavaLangObjectNull = (newProperty) != (null);
            if (newPropertyJavaLangObjectNull) {




                newProperty.setFloorPlan(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentNewPropertyBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds));
    }
    private FragmentNewPropertyBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (com.google.android.material.textfield.TextInputLayout) bindings[28]
            , (com.google.android.material.appbar.AppBarLayout) bindings[17]
            , (com.google.android.material.textfield.TextInputLayout) bindings[26]
            , (com.google.android.material.textfield.TextInputLayout) bindings[29]
            , (com.google.android.material.textfield.MaterialAutoCompleteTextView) bindings[15]
            , (com.google.android.material.textfield.TextInputLayout) bindings[25]
            , (com.google.android.material.textfield.MaterialAutoCompleteTextView) bindings[10]
            , (com.google.android.material.textfield.TextInputLayout) bindings[21]
            , (com.google.android.material.textfield.TextInputLayout) bindings[6]
            , (com.google.android.material.textfield.TextInputEditText) bindings[7]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[14]
            , (com.google.android.material.textfield.TextInputLayout) bindings[23]
            , (com.google.android.material.textfield.MaterialAutoCompleteTextView) bindings[8]
            , (androidx.recyclerview.widget.RecyclerView) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[24]
            , (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0]
            , (com.google.android.material.button.MaterialButton) bindings[16]
            , (androidx.core.widget.NestedScrollView) bindings[19]
            , (com.google.android.material.textfield.TextInputLayout) bindings[20]
            , (com.google.android.material.textfield.TextInputLayout) bindings[22]
            , (com.google.android.material.textfield.MaterialAutoCompleteTextView) bindings[5]
            , (com.google.android.material.textfield.TextInputLayout) bindings[27]
            , (com.google.android.material.textfield.MaterialAutoCompleteTextView) bindings[12]
            , (com.google.android.material.appbar.MaterialToolbar) bindings[18]
            );
        this.mboundView1 = (android.widget.ProgressBar) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView11 = (com.google.android.material.textfield.TextInputEditText) bindings[11];
        this.mboundView11.setTag(null);
        this.mboundView13 = (com.google.android.material.textfield.TextInputEditText) bindings[13];
        this.mboundView13.setTag(null);
        this.mboundView3 = (com.google.android.material.textfield.TextInputEditText) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (com.google.android.material.textfield.TextInputEditText) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView9 = (com.google.android.material.textfield.TextInputEditText) bindings[9];
        this.mboundView9.setTag(null);
        this.newPropertyCityItem.setTag(null);
        this.newPropertyCurrencyItem.setTag(null);
        this.newPropertyFloorPlan.setTag(null);
        this.newPropertyFloorPlanItem.setTag(null);
        this.newPropertyLocation.setTag(null);
        this.newPropertyOperationItem.setTag(null);
        this.newPropertyPhotoItem.setTag(null);
        this.newPropertyRootView.setTag(null);
        this.newPropertySave.setTag(null);
        this.newPropertyTypeItem.setTag(null);
        this.newPropertyUnitItem.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1000000L;
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
        if (BR.propertyViewModel == variableId) {
            setPropertyViewModel((al.viki.ui.property.PropertyViewModel) variable);
        }
        else if (BR.currencyAdapter == variableId) {
            setCurrencyAdapter((al.bruno.adapter.DropDownAdapter) variable);
        }
        else if (BR.propertyTypeAdapter == variableId) {
            setPropertyTypeAdapter((al.bruno.adapter.DropDownAdapter) variable);
        }
        else if (BR.floorPlanAdapter == variableId) {
            setFloorPlanAdapter((al.bruno.adapter.DropDownAdapter) variable);
        }
        else if (BR.operationAdapter == variableId) {
            setOperationAdapter((al.bruno.adapter.DropDownAdapter) variable);
        }
        else if (BR.cityAdapter == variableId) {
            setCityAdapter((al.bruno.adapter.DropDownAdapter) variable);
        }
        else if (BR.onClick == variableId) {
            setOnClick((android.view.View.OnClickListener) variable);
        }
        else if (BR.newProperty == variableId) {
            setNewProperty((al.viki.model.NewPropertyUi) variable);
        }
        else if (BR.unitAdapter == variableId) {
            setUnitAdapter((al.bruno.adapter.DropDownAdapter) variable);
        }
        else if (BR.photoAdapter == variableId) {
            setPhotoAdapter((androidx.recyclerview.widget.ListAdapter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPropertyViewModel(@Nullable al.viki.ui.property.PropertyViewModel PropertyViewModel) {
        this.mPropertyViewModel = PropertyViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.propertyViewModel);
        super.requestRebind();
    }
    public void setCurrencyAdapter(@Nullable al.bruno.adapter.DropDownAdapter CurrencyAdapter) {
        this.mCurrencyAdapter = CurrencyAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.currencyAdapter);
        super.requestRebind();
    }
    public void setPropertyTypeAdapter(@Nullable al.bruno.adapter.DropDownAdapter PropertyTypeAdapter) {
        this.mPropertyTypeAdapter = PropertyTypeAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.propertyTypeAdapter);
        super.requestRebind();
    }
    public void setFloorPlanAdapter(@Nullable al.bruno.adapter.DropDownAdapter FloorPlanAdapter) {
        this.mFloorPlanAdapter = FloorPlanAdapter;
    }
    public void setOperationAdapter(@Nullable al.bruno.adapter.DropDownAdapter OperationAdapter) {
        this.mOperationAdapter = OperationAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.operationAdapter);
        super.requestRebind();
    }
    public void setCityAdapter(@Nullable al.bruno.adapter.DropDownAdapter CityAdapter) {
        this.mCityAdapter = CityAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x100L;
        }
        notifyPropertyChanged(BR.cityAdapter);
        super.requestRebind();
    }
    public void setOnClick(@Nullable android.view.View.OnClickListener OnClick) {
        this.mOnClick = OnClick;
        synchronized(this) {
            mDirtyFlags |= 0x200L;
        }
        notifyPropertyChanged(BR.onClick);
        super.requestRebind();
    }
    public void setNewProperty(@Nullable al.viki.model.NewPropertyUi NewProperty) {
        updateRegistration(1, NewProperty);
        this.mNewProperty = NewProperty;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.newProperty);
        super.requestRebind();
    }
    public void setUnitAdapter(@Nullable al.bruno.adapter.DropDownAdapter UnitAdapter) {
        this.mUnitAdapter = UnitAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x400L;
        }
        notifyPropertyChanged(BR.unitAdapter);
        super.requestRebind();
    }
    public void setPhotoAdapter(@Nullable androidx.recyclerview.widget.ListAdapter PhotoAdapter) {
        this.mPhotoAdapter = PhotoAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x800L;
        }
        notifyPropertyChanged(BR.photoAdapter);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangePropertyViewModelProperties((kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Integer>>) object, fieldId);
            case 1 :
                return onChangeNewProperty((al.viki.model.NewPropertyUi) object, fieldId);
            case 2 :
                return onChangePropertyViewModelPhoto((kotlinx.coroutines.flow.StateFlow<java.util.List<al.viki.model.PhotoUi>>) object, fieldId);
        }
        return false;
    }
    private boolean onChangePropertyViewModelProperties(kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Integer>> PropertyViewModelProperties, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeNewProperty(al.viki.model.NewPropertyUi NewProperty, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.title) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000L;
            }
            return true;
        }
        else if (fieldId == BR.description) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000L;
            }
            return true;
        }
        else if (fieldId == BR.apartment) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000L;
            }
            return true;
        }
        else if (fieldId == BR.price) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000L;
            }
            return true;
        }
        else if (fieldId == BR.area) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000L;
            }
            return true;
        }
        else if (fieldId == BR.address) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000L;
            }
            return true;
        }
        else if (fieldId == BR.location) {
            synchronized(this) {
                    mDirtyFlags |= 0x40000L;
            }
            return true;
        }
        else if (fieldId == BR.propertyType) {
            synchronized(this) {
                    mDirtyFlags |= 0x80000L;
            }
            return true;
        }
        else if (fieldId == BR.operation) {
            synchronized(this) {
                    mDirtyFlags |= 0x100000L;
            }
            return true;
        }
        else if (fieldId == BR.currency) {
            synchronized(this) {
                    mDirtyFlags |= 0x200000L;
            }
            return true;
        }
        else if (fieldId == BR.unit) {
            synchronized(this) {
                    mDirtyFlags |= 0x400000L;
            }
            return true;
        }
        else if (fieldId == BR.city) {
            synchronized(this) {
                    mDirtyFlags |= 0x800000L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangePropertyViewModelPhoto(kotlinx.coroutines.flow.StateFlow<java.util.List<al.viki.model.PhotoUi>> PropertyViewModelPhoto, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        int propertyViewModelPropertiesInstanceofStateLoadingViewVISIBLEViewGONE = 0;
        boolean newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNull = false;
        android.widget.AdapterView.OnItemClickListener newPropertyCityListener = null;
        boolean newPropertyAreaJavaLangObjectNull = false;
        boolean propertyViewModelPropertiesInstanceofStateLoading = false;
        java.lang.String NewPropertyTitle1 = null;
        android.widget.AdapterView.OnItemClickListener newPropertyPropertyTypeListener = null;
        al.viki.model.CurrencyUi NewPropertyCurrency1 = null;
        al.viki.ui.property.PropertyViewModel propertyViewModel = mPropertyViewModel;
        boolean newPropertyCurrencyJavaLangObjectNull = false;
        al.viki.model.LocationUi NewPropertyLocation1 = null;
        boolean newPropertyPriceJavaLangObjectNull = false;
        al.viki.model.CityUi NewPropertyCity1 = null;
        android.widget.AdapterView.OnItemClickListener newPropertyCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = null;
        android.widget.AdapterView.OnItemClickListener newPropertyUnitListener = null;
        al.bruno.adapter.DropDownAdapter<? extends al.bruno.adapter.Selection,? extends androidx.databinding.ViewDataBinding> currencyAdapter = mCurrencyAdapter;
        boolean newPropertyLocationJavaLangObjectNull = false;
        java.util.List<al.viki.model.PhotoUi> propertyViewModelPhotoGetValue = null;
        android.widget.AdapterView.OnItemClickListener newPropertyCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = null;
        boolean newPropertyUnitJavaLangObjectNull = false;
        boolean newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNullNewPropertyCityJavaLangObjectNullNewPropertyLocationJavaLangObjectNullPropertyViewModelPhotoEmpty = false;
        java.lang.String NewPropertyFloorPlan1 = null;
        boolean newPropertyTitleJavaLangObjectNull = false;
        boolean newPropertyDescriptionJavaLangObjectNull = false;
        boolean newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNull = false;
        al.bruno.adapter.DropDownAdapter<? extends al.bruno.adapter.Selection,? extends androidx.databinding.ViewDataBinding> propertyTypeAdapter = mPropertyTypeAdapter;
        boolean newPropertyOperationJavaLangObjectNull = false;
        java.lang.String NewPropertyAddress1 = null;
        boolean newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNull = false;
        boolean newPropertyAddressJavaLangObjectNull = false;
        al.bruno.core.State<java.lang.Integer> propertyViewModelPropertiesGetValue = null;
        al.bruno.adapter.DropDownAdapter<? extends al.bruno.adapter.Selection,? extends androidx.databinding.ViewDataBinding> operationAdapter = mOperationAdapter;
        al.viki.model.PropertyTypeUi newPropertyPropertyType = null;
        java.lang.String NewPropertyPrice1 = null;
        boolean newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNull = false;
        boolean newPropertyApartment = false;
        java.lang.String NewPropertyArea1 = null;
        boolean newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNull = false;
        android.widget.AdapterView.OnItemClickListener newPropertyOperationListener = null;
        kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Integer>> propertyViewModelProperties = null;
        java.lang.String NewPropertyDescription1 = null;
        al.bruno.adapter.DropDownAdapter<? extends al.bruno.adapter.Selection,? extends androidx.databinding.ViewDataBinding> cityAdapter = mCityAdapter;
        boolean newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNull = false;
        boolean newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNull = false;
        android.widget.AdapterView.OnItemClickListener newPropertyOperationListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = null;
        android.widget.AdapterView.OnItemClickListener newPropertyPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = null;
        int newPropertyApartmentViewVISIBLEViewGONE = 0;
        android.widget.AdapterView.OnItemClickListener newPropertyUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = null;
        android.view.View.OnClickListener onClickOnClickAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener onClick = mOnClick;
        al.viki.model.NewPropertyUi newProperty = mNewProperty;
        al.bruno.adapter.DropDownAdapter<? extends al.bruno.adapter.Selection,? extends androidx.databinding.ViewDataBinding> unitAdapter = mUnitAdapter;
        androidx.recyclerview.widget.ListAdapter<?,? extends androidx.recyclerview.widget.RecyclerView.ViewHolder> photoAdapter = mPhotoAdapter;
        boolean newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNull = false;
        al.viki.model.OperationUi NewPropertyOperation1 = null;
        boolean propertyViewModelPhotoEmpty = false;
        al.viki.model.UnitUi NewPropertyUnit1 = null;
        boolean newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNullNewPropertyCityJavaLangObjectNullNewPropertyLocationJavaLangObjectNull = false;
        boolean newPropertyPropertyTypeJavaLangObjectNull = false;
        boolean PropertyViewModelPhotoEmpty1 = false;
        android.widget.AdapterView.OnItemClickListener newPropertyCurrencyListener = null;
        boolean newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNullNewPropertyCityJavaLangObjectNull = false;
        int newPropertyLocationJavaLangObjectNullNewPropertyLocationAndroidColorVikiColorPrimaryNewPropertyLocationAndroidColorSuccess = 0;
        boolean newPropertyCityJavaLangObjectNull = false;
        kotlinx.coroutines.flow.StateFlow<java.util.List<al.viki.model.PhotoUi>> propertyViewModelPhoto = null;

        if ((dirtyFlags & 0x1ffb00fL) != 0) {


            if ((dirtyFlags & 0x1000009L) != 0) {

                    if (propertyViewModel != null) {
                        // read propertyViewModel.properties
                        propertyViewModelProperties = propertyViewModel.getProperties();
                    }
                    androidx.databinding.ViewDataBindingKtx.updateStateFlowRegistration(this, 0, propertyViewModelProperties);


                    if (propertyViewModelProperties != null) {
                        // read propertyViewModel.properties.getValue()
                        propertyViewModelPropertiesGetValue = propertyViewModelProperties.getValue();
                    }


                    // read propertyViewModel.properties.getValue() instanceof State.Loading
                    propertyViewModelPropertiesInstanceofStateLoading = propertyViewModelPropertiesGetValue instanceof al.bruno.core.State.Loading;
                if((dirtyFlags & 0x1000009L) != 0) {
                    if(propertyViewModelPropertiesInstanceofStateLoading) {
                            dirtyFlags |= 0x4000000L;
                    }
                    else {
                            dirtyFlags |= 0x2000000L;
                    }
                }


                    // read propertyViewModel.properties.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
                    propertyViewModelPropertiesInstanceofStateLoadingViewVISIBLEViewGONE = ((propertyViewModelPropertiesInstanceofStateLoading) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
            if ((dirtyFlags & 0x1ffb00eL) != 0) {

                    if (propertyViewModel != null) {
                        // read propertyViewModel.photo
                        propertyViewModelPhoto = propertyViewModel.getPhoto();
                    }
                    androidx.databinding.ViewDataBindingKtx.updateStateFlowRegistration(this, 2, propertyViewModelPhoto);


                    if (propertyViewModelPhoto != null) {
                        // read propertyViewModel.photo.getValue()
                        propertyViewModelPhotoGetValue = propertyViewModelPhoto.getValue();
                    }


                    if (propertyViewModelPhotoGetValue != null) {
                        // read propertyViewModel.photo.getValue().empty
                        PropertyViewModelPhotoEmpty1 = propertyViewModelPhotoGetValue.isEmpty();
                    }


                    // read !propertyViewModel.photo.getValue().empty
                    propertyViewModelPhotoEmpty = !PropertyViewModelPhotoEmpty1;
            }
        }
        if ((dirtyFlags & 0x1000010L) != 0) {
        }
        if ((dirtyFlags & 0x1000020L) != 0) {
        }
        if ((dirtyFlags & 0x1000080L) != 0) {
        }
        if ((dirtyFlags & 0x1000100L) != 0) {
        }
        if ((dirtyFlags & 0x1000200L) != 0) {



                if (onClick != null) {
                    // read onClick::onClick
                    onClickOnClickAndroidViewViewOnClickListener = (((mOnClickOnClickAndroidViewViewOnClickListener == null) ? (mOnClickOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mOnClickOnClickAndroidViewViewOnClickListener).setValue(onClick));
                }
        }
        if ((dirtyFlags & 0x1fff00eL) != 0) {


            if ((dirtyFlags & 0x1000002L) != 0) {

                    if (newProperty != null) {
                        // read newProperty.cityListener
                        newPropertyCityListener = newProperty.getCityListener();
                        // read newProperty.propertyTypeListener
                        newPropertyPropertyTypeListener = newProperty.getPropertyTypeListener();
                        // read newProperty.unitListener
                        newPropertyUnitListener = newProperty.getUnitListener();
                        // read newProperty.floorPlan
                        NewPropertyFloorPlan1 = newProperty.getFloorPlan();
                        // read newProperty.operationListener
                        newPropertyOperationListener = newProperty.getOperationListener();
                        // read newProperty.currencyListener
                        newPropertyCurrencyListener = newProperty.getCurrencyListener();
                    }


                    if (newPropertyCityListener != null) {
                        // read newProperty.cityListener::onItemClick
                        newPropertyCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = (((mNewPropertyCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener == null) ? (mNewPropertyCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = new OnItemClickListenerImpl1()) : mNewPropertyCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener).setValue(newPropertyCityListener));
                    }
                    if (newPropertyPropertyTypeListener != null) {
                        // read newProperty.propertyTypeListener::onItemClick
                        newPropertyPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = (((mNewPropertyPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener == null) ? (mNewPropertyPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = new OnItemClickListenerImpl3()) : mNewPropertyPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener).setValue(newPropertyPropertyTypeListener));
                    }
                    if (newPropertyUnitListener != null) {
                        // read newProperty.unitListener::onItemClick
                        newPropertyUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = (((mNewPropertyUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener == null) ? (mNewPropertyUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = new OnItemClickListenerImpl4()) : mNewPropertyUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener).setValue(newPropertyUnitListener));
                    }
                    if (newPropertyOperationListener != null) {
                        // read newProperty.operationListener::onItemClick
                        newPropertyOperationListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = (((mNewPropertyOperationListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener == null) ? (mNewPropertyOperationListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = new OnItemClickListenerImpl2()) : mNewPropertyOperationListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener).setValue(newPropertyOperationListener));
                    }
                    if (newPropertyCurrencyListener != null) {
                        // read newProperty.currencyListener::onItemClick
                        newPropertyCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = (((mNewPropertyCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener == null) ? (mNewPropertyCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = new OnItemClickListenerImpl()) : mNewPropertyCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener).setValue(newPropertyCurrencyListener));
                    }
            }
            if ((dirtyFlags & 0x1ffb00eL) != 0) {

                    if (newProperty != null) {
                        // read newProperty.title
                        NewPropertyTitle1 = newProperty.getTitle();
                        // read newProperty.currency
                        NewPropertyCurrency1 = newProperty.getCurrency();
                        // read newProperty.location
                        NewPropertyLocation1 = newProperty.getLocation();
                        // read newProperty.city
                        NewPropertyCity1 = newProperty.getCity();
                        // read newProperty.address
                        NewPropertyAddress1 = newProperty.getAddress();
                        // read newProperty.propertyType
                        newPropertyPropertyType = newProperty.getPropertyType();
                        // read newProperty.price
                        NewPropertyPrice1 = newProperty.getPrice();
                        // read newProperty.area
                        NewPropertyArea1 = newProperty.getArea();
                        // read newProperty.description
                        NewPropertyDescription1 = newProperty.getDescription();
                        // read newProperty.operation
                        NewPropertyOperation1 = newProperty.getOperation();
                        // read newProperty.unit
                        NewPropertyUnit1 = newProperty.getUnit();
                    }


                    // read newProperty.title != null
                    newPropertyTitleJavaLangObjectNull = (NewPropertyTitle1) != (null);
                    // read newProperty.currency != null
                    newPropertyCurrencyJavaLangObjectNull = (NewPropertyCurrency1) != (null);
                    // read newProperty.location != null
                    newPropertyLocationJavaLangObjectNull = (NewPropertyLocation1) != (null);
                    // read newProperty.city != null
                    newPropertyCityJavaLangObjectNull = (NewPropertyCity1) != (null);
                    // read newProperty.address != null
                    newPropertyAddressJavaLangObjectNull = (NewPropertyAddress1) != (null);
                    // read newProperty.propertyType != null
                    newPropertyPropertyTypeJavaLangObjectNull = (newPropertyPropertyType) != (null);
                    // read newProperty.price != null
                    newPropertyPriceJavaLangObjectNull = (NewPropertyPrice1) != (null);
                    // read newProperty.area != null
                    newPropertyAreaJavaLangObjectNull = (NewPropertyArea1) != (null);
                    // read newProperty.description != null
                    newPropertyDescriptionJavaLangObjectNull = (NewPropertyDescription1) != (null);
                    // read newProperty.operation != null
                    newPropertyOperationJavaLangObjectNull = (NewPropertyOperation1) != (null);
                    // read newProperty.unit != null
                    newPropertyUnitJavaLangObjectNull = (NewPropertyUnit1) != (null);
                if((dirtyFlags & 0x1040002L) != 0) {
                    if(newPropertyLocationJavaLangObjectNull) {
                            dirtyFlags |= 0x40000000L;
                    }
                    else {
                            dirtyFlags |= 0x20000000L;
                    }
                }

                if ((dirtyFlags & 0x1040002L) != 0) {

                        // read newProperty.location != null ? @android:color/vikiColorPrimary : @android:color/success
                        newPropertyLocationJavaLangObjectNullNewPropertyLocationAndroidColorVikiColorPrimaryNewPropertyLocationAndroidColorSuccess = ((newPropertyLocationJavaLangObjectNull) ? (getColorFromResource(newPropertyLocation, R.color.vikiColorPrimary)) : (getColorFromResource(newPropertyLocation, R.color.success)));
                }

                    // read (newProperty.title != null) & (newProperty.description != null)
                    newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNull = (newPropertyTitleJavaLangObjectNull) & (newPropertyDescriptionJavaLangObjectNull);


                    // read ((newProperty.title != null) & (newProperty.description != null)) & (newProperty.propertyType != null)
                    newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNull = (newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNull) & (newPropertyPropertyTypeJavaLangObjectNull);


                    // read (((newProperty.title != null) & (newProperty.description != null)) & (newProperty.propertyType != null)) & (newProperty.operation != null)
                    newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNull = (newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNull) & (newPropertyOperationJavaLangObjectNull);


                    // read ((((newProperty.title != null) & (newProperty.description != null)) & (newProperty.propertyType != null)) & (newProperty.operation != null)) & (newProperty.price != null)
                    newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNull = (newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNull) & (newPropertyPriceJavaLangObjectNull);


                    // read (((((newProperty.title != null) & (newProperty.description != null)) & (newProperty.propertyType != null)) & (newProperty.operation != null)) & (newProperty.price != null)) & (newProperty.currency != null)
                    newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNull = (newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNull) & (newPropertyCurrencyJavaLangObjectNull);


                    // read ((((((newProperty.title != null) & (newProperty.description != null)) & (newProperty.propertyType != null)) & (newProperty.operation != null)) & (newProperty.price != null)) & (newProperty.currency != null)) & (newProperty.area != null)
                    newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNull = (newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNull) & (newPropertyAreaJavaLangObjectNull);


                    // read (((((((newProperty.title != null) & (newProperty.description != null)) & (newProperty.propertyType != null)) & (newProperty.operation != null)) & (newProperty.price != null)) & (newProperty.currency != null)) & (newProperty.area != null)) & (newProperty.unit != null)
                    newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNull = (newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNull) & (newPropertyUnitJavaLangObjectNull);


                    // read ((((((((newProperty.title != null) & (newProperty.description != null)) & (newProperty.propertyType != null)) & (newProperty.operation != null)) & (newProperty.price != null)) & (newProperty.currency != null)) & (newProperty.area != null)) & (newProperty.unit != null)) & (newProperty.address != null)
                    newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNull = (newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNull) & (newPropertyAddressJavaLangObjectNull);


                    // read (((((((((newProperty.title != null) & (newProperty.description != null)) & (newProperty.propertyType != null)) & (newProperty.operation != null)) & (newProperty.price != null)) & (newProperty.currency != null)) & (newProperty.area != null)) & (newProperty.unit != null)) & (newProperty.address != null)) & (newProperty.city != null)
                    newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNullNewPropertyCityJavaLangObjectNull = (newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNull) & (newPropertyCityJavaLangObjectNull);


                    // read ((((((((((newProperty.title != null) & (newProperty.description != null)) & (newProperty.propertyType != null)) & (newProperty.operation != null)) & (newProperty.price != null)) & (newProperty.currency != null)) & (newProperty.area != null)) & (newProperty.unit != null)) & (newProperty.address != null)) & (newProperty.city != null)) & (newProperty.location != null)
                    newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNullNewPropertyCityJavaLangObjectNullNewPropertyLocationJavaLangObjectNull = (newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNullNewPropertyCityJavaLangObjectNull) & (newPropertyLocationJavaLangObjectNull);


                    // read (((((((((((newProperty.title != null) & (newProperty.description != null)) & (newProperty.propertyType != null)) & (newProperty.operation != null)) & (newProperty.price != null)) & (newProperty.currency != null)) & (newProperty.area != null)) & (newProperty.unit != null)) & (newProperty.address != null)) & (newProperty.city != null)) & (newProperty.location != null)) & (!propertyViewModel.photo.getValue().empty)
                    newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNullNewPropertyCityJavaLangObjectNullNewPropertyLocationJavaLangObjectNullPropertyViewModelPhotoEmpty = (newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNullNewPropertyCityJavaLangObjectNullNewPropertyLocationJavaLangObjectNull) & (propertyViewModelPhotoEmpty);
            }
            if ((dirtyFlags & 0x1004002L) != 0) {

                    if (newProperty != null) {
                        // read newProperty.apartment
                        newPropertyApartment = newProperty.getApartment();
                    }
                if((dirtyFlags & 0x1004002L) != 0) {
                    if(newPropertyApartment) {
                            dirtyFlags |= 0x10000000L;
                    }
                    else {
                            dirtyFlags |= 0x8000000L;
                    }
                }


                    // read newProperty.apartment ? View.VISIBLE : View.GONE
                    newPropertyApartmentViewVISIBLEViewGONE = ((newPropertyApartment) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        if ((dirtyFlags & 0x1000400L) != 0) {
        }
        if ((dirtyFlags & 0x1000800L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x1000009L) != 0) {
            // api target 1

            this.mboundView1.setVisibility(propertyViewModelPropertiesInstanceofStateLoadingViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x1010002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView11, NewPropertyArea1);
        }
        if ((dirtyFlags & 0x1000000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView11, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView11androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView13, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView13androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView9, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView9androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.newPropertyFloorPlanItem, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, newPropertyFloorPlanItemandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x1020002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView13, NewPropertyAddress1);
        }
        if ((dirtyFlags & 0x1001002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, NewPropertyTitle1);
        }
        if ((dirtyFlags & 0x1002002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, NewPropertyDescription1);
        }
        if ((dirtyFlags & 0x1008002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, NewPropertyPrice1);
        }
        if ((dirtyFlags & 0x1000002L) != 0) {
            // api target 1

            al.viki.foundation.binding.util.Adapter.adapter(this.newPropertyCityItem, newPropertyCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener);
            al.viki.foundation.binding.util.Adapter.adapter(this.newPropertyCurrencyItem, newPropertyCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.newPropertyFloorPlanItem, NewPropertyFloorPlan1);
            al.viki.foundation.binding.util.Adapter.adapter(this.newPropertyOperationItem, newPropertyOperationListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener);
            al.viki.foundation.binding.util.Adapter.adapter(this.newPropertyTypeItem, newPropertyPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener);
            al.viki.foundation.binding.util.Adapter.adapter(this.newPropertyUnitItem, newPropertyUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener);
        }
        if ((dirtyFlags & 0x1000100L) != 0) {
            // api target 1

            this.newPropertyCityItem.setAdapter(cityAdapter);
        }
        if ((dirtyFlags & 0x1000010L) != 0) {
            // api target 1

            this.newPropertyCurrencyItem.setAdapter(currencyAdapter);
        }
        if ((dirtyFlags & 0x1004002L) != 0) {
            // api target 1

            this.newPropertyFloorPlan.setVisibility(newPropertyApartmentViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x1000200L) != 0) {
            // api target 1

            this.newPropertyLocation.setOnClickListener(onClickOnClickAndroidViewViewOnClickListener);
            this.newPropertySave.setOnClickListener(onClickOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x1040002L) != 0) {
            // api target 21
            if(getBuildSdkInt() >= 21) {

                this.newPropertyLocation.setImageTintList(androidx.databinding.adapters.Converters.convertColorToColorStateList(newPropertyLocationJavaLangObjectNullNewPropertyLocationAndroidColorVikiColorPrimaryNewPropertyLocationAndroidColorSuccess));
            }
        }
        if ((dirtyFlags & 0x1000080L) != 0) {
            // api target 1

            this.newPropertyOperationItem.setAdapter(operationAdapter);
        }
        if ((dirtyFlags & 0x1000800L) != 0) {
            // api target 1

            this.newPropertyPhotoItem.setAdapter(photoAdapter);
        }
        if ((dirtyFlags & 0x1ffb00eL) != 0) {
            // api target 1

            this.newPropertySave.setEnabled(newPropertyTitleJavaLangObjectNullNewPropertyDescriptionJavaLangObjectNullNewPropertyPropertyTypeJavaLangObjectNullNewPropertyOperationJavaLangObjectNullNewPropertyPriceJavaLangObjectNullNewPropertyCurrencyJavaLangObjectNullNewPropertyAreaJavaLangObjectNullNewPropertyUnitJavaLangObjectNullNewPropertyAddressJavaLangObjectNullNewPropertyCityJavaLangObjectNullNewPropertyLocationJavaLangObjectNullPropertyViewModelPhotoEmpty);
        }
        if ((dirtyFlags & 0x1000020L) != 0) {
            // api target 1

            this.newPropertyTypeItem.setAdapter(propertyTypeAdapter);
        }
        if ((dirtyFlags & 0x1000400L) != 0) {
            // api target 1

            this.newPropertyUnitItem.setAdapter(unitAdapter);
        }
    }
    // Listener Stub Implementations
    public static class OnItemClickListenerImpl implements android.widget.AdapterView.OnItemClickListener{
        private android.widget.AdapterView.OnItemClickListener value;
        public OnItemClickListenerImpl setValue(android.widget.AdapterView.OnItemClickListener value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onItemClick(android.widget.AdapterView arg0, android.view.View arg1, int arg2, long arg3) {
            this.value.onItemClick(arg0, arg1, arg2, arg3); 
        }
    }
    public static class OnItemClickListenerImpl1 implements android.widget.AdapterView.OnItemClickListener{
        private android.widget.AdapterView.OnItemClickListener value;
        public OnItemClickListenerImpl1 setValue(android.widget.AdapterView.OnItemClickListener value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onItemClick(android.widget.AdapterView arg0, android.view.View arg1, int arg2, long arg3) {
            this.value.onItemClick(arg0, arg1, arg2, arg3); 
        }
    }
    public static class OnItemClickListenerImpl2 implements android.widget.AdapterView.OnItemClickListener{
        private android.widget.AdapterView.OnItemClickListener value;
        public OnItemClickListenerImpl2 setValue(android.widget.AdapterView.OnItemClickListener value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onItemClick(android.widget.AdapterView arg0, android.view.View arg1, int arg2, long arg3) {
            this.value.onItemClick(arg0, arg1, arg2, arg3); 
        }
    }
    public static class OnItemClickListenerImpl3 implements android.widget.AdapterView.OnItemClickListener{
        private android.widget.AdapterView.OnItemClickListener value;
        public OnItemClickListenerImpl3 setValue(android.widget.AdapterView.OnItemClickListener value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onItemClick(android.widget.AdapterView arg0, android.view.View arg1, int arg2, long arg3) {
            this.value.onItemClick(arg0, arg1, arg2, arg3); 
        }
    }
    public static class OnItemClickListenerImpl4 implements android.widget.AdapterView.OnItemClickListener{
        private android.widget.AdapterView.OnItemClickListener value;
        public OnItemClickListenerImpl4 setValue(android.widget.AdapterView.OnItemClickListener value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onItemClick(android.widget.AdapterView arg0, android.view.View arg1, int arg2, long arg3) {
            this.value.onItemClick(arg0, arg1, arg2, arg3); 
        }
    }
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
        flag 0 (0x1L): propertyViewModel.properties
        flag 1 (0x2L): newProperty
        flag 2 (0x3L): propertyViewModel.photo
        flag 3 (0x4L): propertyViewModel
        flag 4 (0x5L): currencyAdapter
        flag 5 (0x6L): propertyTypeAdapter
        flag 6 (0x7L): floorPlanAdapter
        flag 7 (0x8L): operationAdapter
        flag 8 (0x9L): cityAdapter
        flag 9 (0xaL): onClick
        flag 10 (0xbL): unitAdapter
        flag 11 (0xcL): photoAdapter
        flag 12 (0xdL): newProperty.title
        flag 13 (0xeL): newProperty.description
        flag 14 (0xfL): newProperty.apartment
        flag 15 (0x10L): newProperty.price
        flag 16 (0x11L): newProperty.area
        flag 17 (0x12L): newProperty.address
        flag 18 (0x13L): newProperty.location
        flag 19 (0x14L): newProperty.propertyType
        flag 20 (0x15L): newProperty.operation
        flag 21 (0x16L): newProperty.currency
        flag 22 (0x17L): newProperty.unit
        flag 23 (0x18L): newProperty.city
        flag 24 (0x19L): null
        flag 25 (0x1aL): propertyViewModel.properties.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
        flag 26 (0x1bL): propertyViewModel.properties.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
        flag 27 (0x1cL): newProperty.apartment ? View.VISIBLE : View.GONE
        flag 28 (0x1dL): newProperty.apartment ? View.VISIBLE : View.GONE
        flag 29 (0x1eL): newProperty.location != null ? @android:color/vikiColorPrimary : @android:color/success
        flag 30 (0x1fL): newProperty.location != null ? @android:color/vikiColorPrimary : @android:color/success
    flag mapping end*/
    //end
}