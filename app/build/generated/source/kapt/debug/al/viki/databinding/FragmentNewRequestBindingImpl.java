package al.viki.databinding;
import al.viki.R;
import al.viki.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentNewRequestBindingImpl extends FragmentNewRequestBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.top_app_bar, 15);
        sViewsWithIds.put(R.id.new_request_scroll_view, 16);
        sViewsWithIds.put(R.id.new_request_title, 17);
        sViewsWithIds.put(R.id.new_request_description, 18);
        sViewsWithIds.put(R.id.new_request_type, 19);
        sViewsWithIds.put(R.id.new_request_price, 20);
        sViewsWithIds.put(R.id.new_request_currency, 21);
        sViewsWithIds.put(R.id.new_request_area, 22);
        sViewsWithIds.put(R.id.new_request_unit, 23);
        sViewsWithIds.put(R.id.new_request_address, 24);
        sViewsWithIds.put(R.id.new_request_city, 25);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.widget.ProgressBar mboundView1;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView11;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView2;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView3;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView7;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView9;
    // variables
    // values
    // listeners
    private OnItemClickListenerImpl mNewRequestUiPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener;
    private OnItemClickListenerImpl1 mNewRequestUiUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener;
    private OnItemClickListenerImpl2 mNewRequestUiCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener;
    private OnClickListenerImpl mOnClickOnClickAndroidViewViewOnClickListener;
    private OnItemClickListenerImpl3 mNewRequestUiCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener;
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView11androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newRequestUi.address
            //         is newRequestUi.setAddress((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView11);
            // localize variables for thread safety
            // newRequestUi.address
            java.lang.String newRequestUiAddress = null;
            // newRequestUi != null
            boolean newRequestUiJavaLangObjectNull = false;
            // newRequestUi
            al.viki.model.NewRequestUi newRequestUi = mNewRequestUi;



            newRequestUiJavaLangObjectNull = (newRequestUi) != (null);
            if (newRequestUiJavaLangObjectNull) {




                newRequestUi.setAddress(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newRequestUi.title
            //         is newRequestUi.setTitle((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // newRequestUi != null
            boolean newRequestUiJavaLangObjectNull = false;
            // newRequestUi
            al.viki.model.NewRequestUi newRequestUi = mNewRequestUi;
            // newRequestUi.title
            java.lang.String newRequestUiTitle = null;



            newRequestUiJavaLangObjectNull = (newRequestUi) != (null);
            if (newRequestUiJavaLangObjectNull) {




                newRequestUi.setTitle(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newRequestUi.description
            //         is newRequestUi.setDescription((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView3);
            // localize variables for thread safety
            // newRequestUi.description
            java.lang.String newRequestUiDescription = null;
            // newRequestUi != null
            boolean newRequestUiJavaLangObjectNull = false;
            // newRequestUi
            al.viki.model.NewRequestUi newRequestUi = mNewRequestUi;



            newRequestUiJavaLangObjectNull = (newRequestUi) != (null);
            if (newRequestUiJavaLangObjectNull) {




                newRequestUi.setDescription(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView7androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newRequestUi.price
            //         is newRequestUi.setPrice((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView7);
            // localize variables for thread safety
            // newRequestUi != null
            boolean newRequestUiJavaLangObjectNull = false;
            // newRequestUi.price
            java.lang.String newRequestUiPrice = null;
            // newRequestUi
            al.viki.model.NewRequestUi newRequestUi = mNewRequestUi;



            newRequestUiJavaLangObjectNull = (newRequestUi) != (null);
            if (newRequestUiJavaLangObjectNull) {




                newRequestUi.setPrice(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView9androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newRequestUi.area
            //         is newRequestUi.setArea((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView9);
            // localize variables for thread safety
            // newRequestUi.area
            java.lang.String newRequestUiArea = null;
            // newRequestUi != null
            boolean newRequestUiJavaLangObjectNull = false;
            // newRequestUi
            al.viki.model.NewRequestUi newRequestUi = mNewRequestUi;



            newRequestUiJavaLangObjectNull = (newRequestUi) != (null);
            if (newRequestUiJavaLangObjectNull) {




                newRequestUi.setArea(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener newRequestFloorPlanItemandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of newRequestUi.floorPlan
            //         is newRequestUi.setFloorPlan((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(newRequestFloorPlanItem);
            // localize variables for thread safety
            // newRequestUi != null
            boolean newRequestUiJavaLangObjectNull = false;
            // newRequestUi.floorPlan
            java.lang.String newRequestUiFloorPlan = null;
            // newRequestUi
            al.viki.model.NewRequestUi newRequestUi = mNewRequestUi;



            newRequestUiJavaLangObjectNull = (newRequestUi) != (null);
            if (newRequestUiJavaLangObjectNull) {




                newRequestUi.setFloorPlan(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentNewRequestBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }
    private FragmentNewRequestBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.google.android.material.textfield.TextInputLayout) bindings[24]
            , (com.google.android.material.textfield.TextInputLayout) bindings[22]
            , (com.google.android.material.textfield.TextInputLayout) bindings[25]
            , (com.google.android.material.textfield.MaterialAutoCompleteTextView) bindings[13]
            , (com.google.android.material.textfield.TextInputLayout) bindings[21]
            , (com.google.android.material.textfield.MaterialAutoCompleteTextView) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[18]
            , (com.google.android.material.textfield.TextInputLayout) bindings[5]
            , (com.google.android.material.textfield.TextInputEditText) bindings[6]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[12]
            , (com.google.android.material.textfield.TextInputLayout) bindings[20]
            , (com.google.android.material.button.MaterialButton) bindings[14]
            , (androidx.core.widget.NestedScrollView) bindings[16]
            , (com.google.android.material.textfield.TextInputLayout) bindings[17]
            , (com.google.android.material.textfield.TextInputLayout) bindings[19]
            , (com.google.android.material.textfield.MaterialAutoCompleteTextView) bindings[4]
            , (com.google.android.material.textfield.TextInputLayout) bindings[23]
            , (com.google.android.material.textfield.MaterialAutoCompleteTextView) bindings[10]
            , (com.google.android.material.appbar.MaterialToolbar) bindings[15]
            );
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ProgressBar) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView11 = (com.google.android.material.textfield.TextInputEditText) bindings[11];
        this.mboundView11.setTag(null);
        this.mboundView2 = (com.google.android.material.textfield.TextInputEditText) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (com.google.android.material.textfield.TextInputEditText) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView7 = (com.google.android.material.textfield.TextInputEditText) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView9 = (com.google.android.material.textfield.TextInputEditText) bindings[9];
        this.mboundView9.setTag(null);
        this.newRequestCityItem.setTag(null);
        this.newRequestCurrencyItem.setTag(null);
        this.newRequestFloorPlan.setTag(null);
        this.newRequestFloorPlanItem.setTag(null);
        this.newRequestLocation.setTag(null);
        this.newRequestSave.setTag(null);
        this.newRequestTypeItem.setTag(null);
        this.newRequestUnitItem.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x200000L;
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
        if (BR.currencyAdapter == variableId) {
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
        else if (BR.requestViewModel == variableId) {
            setRequestViewModel((al.viki.ui.request.RequestViewModel) variable);
        }
        else if (BR.cityAdapter == variableId) {
            setCityAdapter((al.bruno.adapter.DropDownAdapter) variable);
        }
        else if (BR.newRequestUi == variableId) {
            setNewRequestUi((al.viki.model.NewRequestUi) variable);
        }
        else if (BR.onClick == variableId) {
            setOnClick((android.view.View.OnClickListener) variable);
        }
        else if (BR.unitAdapter == variableId) {
            setUnitAdapter((al.bruno.adapter.DropDownAdapter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCurrencyAdapter(@Nullable al.bruno.adapter.DropDownAdapter CurrencyAdapter) {
        this.mCurrencyAdapter = CurrencyAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.currencyAdapter);
        super.requestRebind();
    }
    public void setPropertyTypeAdapter(@Nullable al.bruno.adapter.DropDownAdapter PropertyTypeAdapter) {
        this.mPropertyTypeAdapter = PropertyTypeAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.propertyTypeAdapter);
        super.requestRebind();
    }
    public void setFloorPlanAdapter(@Nullable al.bruno.adapter.DropDownAdapter FloorPlanAdapter) {
        this.mFloorPlanAdapter = FloorPlanAdapter;
    }
    public void setOperationAdapter(@Nullable al.bruno.adapter.DropDownAdapter OperationAdapter) {
        this.mOperationAdapter = OperationAdapter;
    }
    public void setRequestViewModel(@Nullable al.viki.ui.request.RequestViewModel RequestViewModel) {
        this.mRequestViewModel = RequestViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x40L;
        }
        notifyPropertyChanged(BR.requestViewModel);
        super.requestRebind();
    }
    public void setCityAdapter(@Nullable al.bruno.adapter.DropDownAdapter CityAdapter) {
        this.mCityAdapter = CityAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x80L;
        }
        notifyPropertyChanged(BR.cityAdapter);
        super.requestRebind();
    }
    public void setNewRequestUi(@Nullable al.viki.model.NewRequestUi NewRequestUi) {
        updateRegistration(1, NewRequestUi);
        this.mNewRequestUi = NewRequestUi;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.newRequestUi);
        super.requestRebind();
    }
    public void setOnClick(@Nullable android.view.View.OnClickListener OnClick) {
        this.mOnClick = OnClick;
        synchronized(this) {
            mDirtyFlags |= 0x100L;
        }
        notifyPropertyChanged(BR.onClick);
        super.requestRebind();
    }
    public void setUnitAdapter(@Nullable al.bruno.adapter.DropDownAdapter UnitAdapter) {
        this.mUnitAdapter = UnitAdapter;
        synchronized(this) {
            mDirtyFlags |= 0x200L;
        }
        notifyPropertyChanged(BR.unitAdapter);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeRequestViewModelRequest((kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Integer>>) object, fieldId);
            case 1 :
                return onChangeNewRequestUi((al.viki.model.NewRequestUi) object, fieldId);
        }
        return false;
    }
    private boolean onChangeRequestViewModelRequest(kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Integer>> RequestViewModelRequest, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeNewRequestUi(al.viki.model.NewRequestUi NewRequestUi, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        else if (fieldId == BR.title) {
            synchronized(this) {
                    mDirtyFlags |= 0x400L;
            }
            return true;
        }
        else if (fieldId == BR.description) {
            synchronized(this) {
                    mDirtyFlags |= 0x800L;
            }
            return true;
        }
        else if (fieldId == BR.apartment) {
            synchronized(this) {
                    mDirtyFlags |= 0x1000L;
            }
            return true;
        }
        else if (fieldId == BR.price) {
            synchronized(this) {
                    mDirtyFlags |= 0x2000L;
            }
            return true;
        }
        else if (fieldId == BR.area) {
            synchronized(this) {
                    mDirtyFlags |= 0x4000L;
            }
            return true;
        }
        else if (fieldId == BR.address) {
            synchronized(this) {
                    mDirtyFlags |= 0x8000L;
            }
            return true;
        }
        else if (fieldId == BR.location) {
            synchronized(this) {
                    mDirtyFlags |= 0x10000L;
            }
            return true;
        }
        else if (fieldId == BR.propertyType) {
            synchronized(this) {
                    mDirtyFlags |= 0x20000L;
            }
            return true;
        }
        else if (fieldId == BR.currency) {
            synchronized(this) {
                    mDirtyFlags |= 0x40000L;
            }
            return true;
        }
        else if (fieldId == BR.unit) {
            synchronized(this) {
                    mDirtyFlags |= 0x80000L;
            }
            return true;
        }
        else if (fieldId == BR.city) {
            synchronized(this) {
                    mDirtyFlags |= 0x100000L;
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
        boolean newRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmpty = false;
        android.widget.AdapterView.OnItemClickListener newRequestUiPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = null;
        boolean newRequestUiAddressBlank = false;
        al.bruno.core.State<java.lang.Integer> requestViewModelRequestGetValue = null;
        boolean newRequestUiAreaEmpty = false;
        android.widget.AdapterView.OnItemClickListener newRequestUiUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = null;
        android.widget.AdapterView.OnItemClickListener newRequestUiCityListener = null;
        boolean newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmpty = false;
        kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Integer>> requestViewModelRequest = null;
        boolean newRequestUiLocationJavaLangObjectNull = false;
        boolean newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNullNewRequestUiUnitJavaLangObjectNullNewRequestUiCityJavaLangObjectNullNewRequestUiLocationJavaLangObjectNull = false;
        boolean newRequestUiCityJavaLangObjectNull = false;
        int newRequestUiApartmentViewVISIBLEViewGONE = 0;
        boolean newRequestUiAreaBlank = false;
        boolean newRequestUiDescriptionEmpty = false;
        java.lang.String newRequestUiTitle = null;
        android.widget.AdapterView.OnItemClickListener newRequestUiUnitListener = null;
        boolean newRequestUiUnitJavaLangObjectNull = false;
        boolean newRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmpty = false;
        android.widget.AdapterView.OnItemClickListener newRequestUiCurrencyListener = null;
        boolean newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNullNewRequestUiUnitJavaLangObjectNull = false;
        boolean requestViewModelRequestInstanceofStateLoading = false;
        boolean newRequestUiDescriptionBlank = false;
        al.viki.model.LocationUi newRequestUiLocation = null;
        boolean NewRequestUiAddressBlank1 = false;
        boolean newRequestUiAddressEmpty = false;
        boolean newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNull = false;
        boolean newRequestUiTitleEmpty = false;
        al.bruno.adapter.DropDownAdapter<? extends al.bruno.adapter.Selection,? extends androidx.databinding.ViewDataBinding> currencyAdapter = mCurrencyAdapter;
        boolean NewRequestUiAddressEmpty1 = false;
        boolean newRequestUiPriceEmpty = false;
        boolean newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmpty = false;
        boolean NewRequestUiPriceEmpty1 = false;
        al.bruno.adapter.DropDownAdapter<? extends al.bruno.adapter.Selection,? extends androidx.databinding.ViewDataBinding> propertyTypeAdapter = mPropertyTypeAdapter;
        java.lang.String newRequestUiAddress = null;
        al.viki.ui.request.RequestViewModel requestViewModel = mRequestViewModel;
        boolean newRequestUiTitleBlank = false;
        boolean NewRequestUiDescriptionEmpty1 = false;
        al.viki.model.UnitUi newRequestUiUnit = null;
        java.lang.String newRequestUiFloorPlan = null;
        al.bruno.adapter.DropDownAdapter<? extends al.bruno.adapter.Selection,? extends androidx.databinding.ViewDataBinding> cityAdapter = mCityAdapter;
        boolean newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmpty = false;
        int newRequestUiLocationJavaLangObjectNullNewRequestLocationAndroidColorVikiColorPrimaryNewRequestLocationAndroidColorSuccess = 0;
        android.widget.AdapterView.OnItemClickListener newRequestUiCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = null;
        al.viki.model.CurrencyUi newRequestUiCurrency = null;
        boolean NewRequestUiDescriptionBlank1 = false;
        android.widget.AdapterView.OnItemClickListener newRequestUiPropertyTypeListener = null;
        al.viki.model.NewRequestUi newRequestUi = mNewRequestUi;
        boolean newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmpty = false;
        boolean newRequestUiPropertyTypeJavaLangObjectNull = false;
        boolean newRequestUiPriceBlank = false;
        android.view.View.OnClickListener onClickOnClickAndroidViewViewOnClickListener = null;
        android.view.View.OnClickListener onClick = mOnClick;
        boolean newRequestUiApartment = false;
        al.viki.model.CityUi newRequestUiCity = null;
        al.viki.model.PropertyTypeUi newRequestUiPropertyType = null;
        int requestViewModelRequestInstanceofStateLoadingViewVISIBLEViewGONE = 0;
        al.bruno.adapter.DropDownAdapter<? extends al.bruno.adapter.Selection,? extends androidx.databinding.ViewDataBinding> unitAdapter = mUnitAdapter;
        android.widget.AdapterView.OnItemClickListener newRequestUiCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = null;
        boolean newRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmpty = false;
        boolean NewRequestUiAreaBlank1 = false;
        boolean newRequestUiCurrencyJavaLangObjectNull = false;
        java.lang.String newRequestUiArea = null;
        boolean NewRequestUiAreaEmpty1 = false;
        boolean newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmpty = false;
        boolean newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNull = false;
        java.lang.String newRequestUiDescription = null;
        boolean NewRequestUiTitleBlank1 = false;
        boolean newRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmpty = false;
        boolean newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNullNewRequestUiUnitJavaLangObjectNullNewRequestUiCityJavaLangObjectNull = false;
        boolean NewRequestUiPriceBlank1 = false;
        boolean NewRequestUiTitleEmpty1 = false;
        java.lang.String newRequestUiPrice = null;

        if ((dirtyFlags & 0x200004L) != 0) {
        }
        if ((dirtyFlags & 0x200008L) != 0) {
        }
        if ((dirtyFlags & 0x200041L) != 0) {



                if (requestViewModel != null) {
                    // read requestViewModel.request
                    requestViewModelRequest = requestViewModel.getRequest();
                }
                androidx.databinding.ViewDataBindingKtx.updateStateFlowRegistration(this, 0, requestViewModelRequest);


                if (requestViewModelRequest != null) {
                    // read requestViewModel.request.getValue()
                    requestViewModelRequestGetValue = requestViewModelRequest.getValue();
                }


                // read requestViewModel.request.getValue() instanceof State.Loading
                requestViewModelRequestInstanceofStateLoading = requestViewModelRequestGetValue instanceof al.bruno.core.State.Loading;
            if((dirtyFlags & 0x200041L) != 0) {
                if(requestViewModelRequestInstanceofStateLoading) {
                        dirtyFlags |= 0x200000000L;
                }
                else {
                        dirtyFlags |= 0x100000000L;
                }
            }


                // read requestViewModel.request.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
                requestViewModelRequestInstanceofStateLoadingViewVISIBLEViewGONE = ((requestViewModelRequestInstanceofStateLoading) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        if ((dirtyFlags & 0x200080L) != 0) {
        }
        if ((dirtyFlags & 0x3ffc02L) != 0) {


            if ((dirtyFlags & 0x200002L) != 0) {

                    if (newRequestUi != null) {
                        // read newRequestUi.cityListener
                        newRequestUiCityListener = newRequestUi.getCityListener();
                        // read newRequestUi.unitListener
                        newRequestUiUnitListener = newRequestUi.getUnitListener();
                        // read newRequestUi.currencyListener
                        newRequestUiCurrencyListener = newRequestUi.getCurrencyListener();
                        // read newRequestUi.floorPlan
                        newRequestUiFloorPlan = newRequestUi.getFloorPlan();
                        // read newRequestUi.propertyTypeListener
                        newRequestUiPropertyTypeListener = newRequestUi.getPropertyTypeListener();
                    }


                    if (newRequestUiCityListener != null) {
                        // read newRequestUi.cityListener::onItemClick
                        newRequestUiCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = (((mNewRequestUiCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener == null) ? (mNewRequestUiCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = new OnItemClickListenerImpl3()) : mNewRequestUiCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener).setValue(newRequestUiCityListener));
                    }
                    if (newRequestUiUnitListener != null) {
                        // read newRequestUi.unitListener::onItemClick
                        newRequestUiUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = (((mNewRequestUiUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener == null) ? (mNewRequestUiUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = new OnItemClickListenerImpl1()) : mNewRequestUiUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener).setValue(newRequestUiUnitListener));
                    }
                    if (newRequestUiCurrencyListener != null) {
                        // read newRequestUi.currencyListener::onItemClick
                        newRequestUiCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = (((mNewRequestUiCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener == null) ? (mNewRequestUiCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = new OnItemClickListenerImpl2()) : mNewRequestUiCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener).setValue(newRequestUiCurrencyListener));
                    }
                    if (newRequestUiPropertyTypeListener != null) {
                        // read newRequestUi.propertyTypeListener::onItemClick
                        newRequestUiPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = (((mNewRequestUiPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener == null) ? (mNewRequestUiPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener = new OnItemClickListenerImpl()) : mNewRequestUiPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener).setValue(newRequestUiPropertyTypeListener));
                    }
            }
            if ((dirtyFlags & 0x3fec02L) != 0) {

                    if (newRequestUi != null) {
                        // read newRequestUi.title
                        newRequestUiTitle = newRequestUi.getTitle();
                        // read newRequestUi.location
                        newRequestUiLocation = newRequestUi.getLocation();
                        // read newRequestUi.address
                        newRequestUiAddress = newRequestUi.getAddress();
                        // read newRequestUi.unit
                        newRequestUiUnit = newRequestUi.getUnit();
                        // read newRequestUi.currency
                        newRequestUiCurrency = newRequestUi.getCurrency();
                        // read newRequestUi.city
                        newRequestUiCity = newRequestUi.getCity();
                        // read newRequestUi.propertyType
                        newRequestUiPropertyType = newRequestUi.getPropertyType();
                        // read newRequestUi.area
                        newRequestUiArea = newRequestUi.getArea();
                        // read newRequestUi.description
                        newRequestUiDescription = newRequestUi.getDescription();
                        // read newRequestUi.price
                        newRequestUiPrice = newRequestUi.getPrice();
                    }


                    if (newRequestUiTitle != null) {
                        // read newRequestUi.title.blank
                        NewRequestUiTitleBlank1 = newRequestUiTitle.isBlank();
                    }
                    // read newRequestUi.location != null
                    newRequestUiLocationJavaLangObjectNull = (newRequestUiLocation) != (null);
                    // read newRequestUi.unit != null
                    newRequestUiUnitJavaLangObjectNull = (newRequestUiUnit) != (null);
                    // read newRequestUi.currency != null
                    newRequestUiCurrencyJavaLangObjectNull = (newRequestUiCurrency) != (null);
                    // read newRequestUi.city != null
                    newRequestUiCityJavaLangObjectNull = (newRequestUiCity) != (null);
                    // read newRequestUi.propertyType != null
                    newRequestUiPropertyTypeJavaLangObjectNull = (newRequestUiPropertyType) != (null);
                if((dirtyFlags & 0x210002L) != 0) {
                    if(newRequestUiLocationJavaLangObjectNull) {
                            dirtyFlags |= 0x20000000L;
                    }
                    else {
                            dirtyFlags |= 0x10000000L;
                    }
                }
                    if (newRequestUiAddress != null) {
                        // read newRequestUi.address.blank
                        NewRequestUiAddressBlank1 = newRequestUiAddress.isBlank();
                    }
                    if (newRequestUiArea != null) {
                        // read newRequestUi.area.blank
                        newRequestUiAreaBlank = newRequestUiArea.isBlank();
                    }
                    if (newRequestUiDescription != null) {
                        // read newRequestUi.description.blank
                        NewRequestUiDescriptionBlank1 = newRequestUiDescription.isBlank();
                    }
                    if (newRequestUiPrice != null) {
                        // read newRequestUi.price.blank
                        newRequestUiPriceBlank = newRequestUiPrice.isBlank();
                    }


                    // read !newRequestUi.title.blank
                    newRequestUiTitleBlank = !NewRequestUiTitleBlank1;
                    // read !newRequestUi.address.blank
                    newRequestUiAddressBlank = !NewRequestUiAddressBlank1;
                    // read !newRequestUi.area.blank
                    NewRequestUiAreaBlank1 = !newRequestUiAreaBlank;
                    // read !newRequestUi.description.blank
                    newRequestUiDescriptionBlank = !NewRequestUiDescriptionBlank1;
                    // read !newRequestUi.price.blank
                    NewRequestUiPriceBlank1 = !newRequestUiPriceBlank;
                if((dirtyFlags & 0x3fec02L) != 0) {
                    if(newRequestUiTitleBlank) {
                            dirtyFlags |= 0x80000000L;
                    }
                    else {
                            dirtyFlags |= 0x40000000L;
                    }
                }
                if((dirtyFlags & 0x3fec02L) != 0) {
                    if(newRequestUiAddressBlank) {
                            dirtyFlags |= 0x800000000L;
                    }
                    else {
                            dirtyFlags |= 0x400000000L;
                    }
                }
                if((dirtyFlags & 0x3fec02L) != 0) {
                    if(NewRequestUiAreaBlank1) {
                            dirtyFlags |= 0x2000000000L;
                    }
                    else {
                            dirtyFlags |= 0x1000000000L;
                    }
                }
                if((dirtyFlags & 0x3fec02L) != 0) {
                    if(newRequestUiDescriptionBlank) {
                            dirtyFlags |= 0x800000L;
                    }
                    else {
                            dirtyFlags |= 0x400000L;
                    }
                }
                if((dirtyFlags & 0x3fec02L) != 0) {
                    if(NewRequestUiPriceBlank1) {
                            dirtyFlags |= 0x8000000L;
                    }
                    else {
                            dirtyFlags |= 0x4000000L;
                    }
                }
                if ((dirtyFlags & 0x210002L) != 0) {

                        // read newRequestUi.location != null ? @android:color/vikiColorPrimary : @android:color/success
                        newRequestUiLocationJavaLangObjectNullNewRequestLocationAndroidColorVikiColorPrimaryNewRequestLocationAndroidColorSuccess = ((newRequestUiLocationJavaLangObjectNull) ? (getColorFromResource(newRequestLocation, R.color.vikiColorPrimary)) : (getColorFromResource(newRequestLocation, R.color.success)));
                }
            }
            if ((dirtyFlags & 0x201002L) != 0) {

                    if (newRequestUi != null) {
                        // read newRequestUi.apartment
                        newRequestUiApartment = newRequestUi.getApartment();
                    }
                if((dirtyFlags & 0x201002L) != 0) {
                    if(newRequestUiApartment) {
                            dirtyFlags |= 0x2000000L;
                    }
                    else {
                            dirtyFlags |= 0x1000000L;
                    }
                }


                    // read newRequestUi.apartment ? View.VISIBLE : View.GONE
                    newRequestUiApartmentViewVISIBLEViewGONE = ((newRequestUiApartment) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
            }
        }
        if ((dirtyFlags & 0x200100L) != 0) {



                if (onClick != null) {
                    // read onClick::onClick
                    onClickOnClickAndroidViewViewOnClickListener = (((mOnClickOnClickAndroidViewViewOnClickListener == null) ? (mOnClickOnClickAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mOnClickOnClickAndroidViewViewOnClickListener).setValue(onClick));
                }
        }
        if ((dirtyFlags & 0x200200L) != 0) {
        }
        // batch finished

        if ((dirtyFlags & 0x400000L) != 0) {

                if (newRequestUiDescription != null) {
                    // read newRequestUi.description.empty
                    newRequestUiDescriptionEmpty = newRequestUiDescription.isEmpty();
                }


                // read !newRequestUi.description.empty
                NewRequestUiDescriptionEmpty1 = !newRequestUiDescriptionEmpty;
        }
        if ((dirtyFlags & 0x400000000L) != 0) {

                if (newRequestUiAddress != null) {
                    // read newRequestUi.address.empty
                    NewRequestUiAddressEmpty1 = newRequestUiAddress.isEmpty();
                }


                // read !newRequestUi.address.empty
                newRequestUiAddressEmpty = !NewRequestUiAddressEmpty1;
        }
        if ((dirtyFlags & 0x4000000L) != 0) {

                if (newRequestUiPrice != null) {
                    // read newRequestUi.price.empty
                    newRequestUiPriceEmpty = newRequestUiPrice.isEmpty();
                }


                // read !newRequestUi.price.empty
                NewRequestUiPriceEmpty1 = !newRequestUiPriceEmpty;
        }
        if ((dirtyFlags & 0x1000000000L) != 0) {

                if (newRequestUiArea != null) {
                    // read newRequestUi.area.empty
                    NewRequestUiAreaEmpty1 = newRequestUiArea.isEmpty();
                }


                // read !newRequestUi.area.empty
                newRequestUiAreaEmpty = !NewRequestUiAreaEmpty1;
        }
        if ((dirtyFlags & 0x40000000L) != 0) {

                if (newRequestUiTitle != null) {
                    // read newRequestUi.title.empty
                    NewRequestUiTitleEmpty1 = newRequestUiTitle.isEmpty();
                }


                // read !newRequestUi.title.empty
                newRequestUiTitleEmpty = !NewRequestUiTitleEmpty1;
        }

        if ((dirtyFlags & 0x3fec02L) != 0) {

                // read !newRequestUi.description.blank ? true : !newRequestUi.description.empty
                newRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmpty = ((newRequestUiDescriptionBlank) ? (true) : (NewRequestUiDescriptionEmpty1));
                // read !newRequestUi.price.blank ? true : !newRequestUi.price.empty
                newRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmpty = ((NewRequestUiPriceBlank1) ? (true) : (NewRequestUiPriceEmpty1));
                // read !newRequestUi.title.blank ? true : !newRequestUi.title.empty
                newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmpty = ((newRequestUiTitleBlank) ? (true) : (newRequestUiTitleEmpty));
                // read !newRequestUi.address.blank ? true : !newRequestUi.address.empty
                newRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmpty = ((newRequestUiAddressBlank) ? (true) : (newRequestUiAddressEmpty));
                // read !newRequestUi.area.blank ? true : !newRequestUi.area.empty
                newRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmpty = ((NewRequestUiAreaBlank1) ? (true) : (newRequestUiAreaEmpty));


                // read (!newRequestUi.title.blank ? true : !newRequestUi.title.empty) & (!newRequestUi.description.blank ? true : !newRequestUi.description.empty)
                newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmpty = (newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmpty) & (newRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmpty);


                // read ((!newRequestUi.title.blank ? true : !newRequestUi.title.empty) & (!newRequestUi.description.blank ? true : !newRequestUi.description.empty)) & (!newRequestUi.price.blank ? true : !newRequestUi.price.empty)
                newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmpty = (newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmpty) & (newRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmpty);


                // read (((!newRequestUi.title.blank ? true : !newRequestUi.title.empty) & (!newRequestUi.description.blank ? true : !newRequestUi.description.empty)) & (!newRequestUi.price.blank ? true : !newRequestUi.price.empty)) & (!newRequestUi.address.blank ? true : !newRequestUi.address.empty)
                newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmpty = (newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmpty) & (newRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmpty);


                // read ((((!newRequestUi.title.blank ? true : !newRequestUi.title.empty) & (!newRequestUi.description.blank ? true : !newRequestUi.description.empty)) & (!newRequestUi.price.blank ? true : !newRequestUi.price.empty)) & (!newRequestUi.address.blank ? true : !newRequestUi.address.empty)) & (!newRequestUi.area.blank ? true : !newRequestUi.area.empty)
                newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmpty = (newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmpty) & (newRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmpty);


                // read (((((!newRequestUi.title.blank ? true : !newRequestUi.title.empty) & (!newRequestUi.description.blank ? true : !newRequestUi.description.empty)) & (!newRequestUi.price.blank ? true : !newRequestUi.price.empty)) & (!newRequestUi.address.blank ? true : !newRequestUi.address.empty)) & (!newRequestUi.area.blank ? true : !newRequestUi.area.empty)) & (newRequestUi.propertyType != null)
                newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNull = (newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmpty) & (newRequestUiPropertyTypeJavaLangObjectNull);


                // read ((((((!newRequestUi.title.blank ? true : !newRequestUi.title.empty) & (!newRequestUi.description.blank ? true : !newRequestUi.description.empty)) & (!newRequestUi.price.blank ? true : !newRequestUi.price.empty)) & (!newRequestUi.address.blank ? true : !newRequestUi.address.empty)) & (!newRequestUi.area.blank ? true : !newRequestUi.area.empty)) & (newRequestUi.propertyType != null)) & (newRequestUi.currency != null)
                newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNull = (newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNull) & (newRequestUiCurrencyJavaLangObjectNull);


                // read (((((((!newRequestUi.title.blank ? true : !newRequestUi.title.empty) & (!newRequestUi.description.blank ? true : !newRequestUi.description.empty)) & (!newRequestUi.price.blank ? true : !newRequestUi.price.empty)) & (!newRequestUi.address.blank ? true : !newRequestUi.address.empty)) & (!newRequestUi.area.blank ? true : !newRequestUi.area.empty)) & (newRequestUi.propertyType != null)) & (newRequestUi.currency != null)) & (newRequestUi.unit != null)
                newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNullNewRequestUiUnitJavaLangObjectNull = (newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNull) & (newRequestUiUnitJavaLangObjectNull);


                // read ((((((((!newRequestUi.title.blank ? true : !newRequestUi.title.empty) & (!newRequestUi.description.blank ? true : !newRequestUi.description.empty)) & (!newRequestUi.price.blank ? true : !newRequestUi.price.empty)) & (!newRequestUi.address.blank ? true : !newRequestUi.address.empty)) & (!newRequestUi.area.blank ? true : !newRequestUi.area.empty)) & (newRequestUi.propertyType != null)) & (newRequestUi.currency != null)) & (newRequestUi.unit != null)) & (newRequestUi.city != null)
                newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNullNewRequestUiUnitJavaLangObjectNullNewRequestUiCityJavaLangObjectNull = (newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNullNewRequestUiUnitJavaLangObjectNull) & (newRequestUiCityJavaLangObjectNull);


                // read (((((((((!newRequestUi.title.blank ? true : !newRequestUi.title.empty) & (!newRequestUi.description.blank ? true : !newRequestUi.description.empty)) & (!newRequestUi.price.blank ? true : !newRequestUi.price.empty)) & (!newRequestUi.address.blank ? true : !newRequestUi.address.empty)) & (!newRequestUi.area.blank ? true : !newRequestUi.area.empty)) & (newRequestUi.propertyType != null)) & (newRequestUi.currency != null)) & (newRequestUi.unit != null)) & (newRequestUi.city != null)) & (newRequestUi.location != null)
                newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNullNewRequestUiUnitJavaLangObjectNullNewRequestUiCityJavaLangObjectNullNewRequestUiLocationJavaLangObjectNull = (newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNullNewRequestUiUnitJavaLangObjectNullNewRequestUiCityJavaLangObjectNull) & (newRequestUiLocationJavaLangObjectNull);
        }
        // batch finished
        if ((dirtyFlags & 0x200041L) != 0) {
            // api target 1

            this.mboundView1.setVisibility(requestViewModelRequestInstanceofStateLoadingViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x208002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView11, newRequestUiAddress);
        }
        if ((dirtyFlags & 0x200000L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView11, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView11androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView3androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView7, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView7androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView9, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView9androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.newRequestFloorPlanItem, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, newRequestFloorPlanItemandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x200402L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, newRequestUiTitle);
        }
        if ((dirtyFlags & 0x200802L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, newRequestUiDescription);
        }
        if ((dirtyFlags & 0x202002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, newRequestUiPrice);
        }
        if ((dirtyFlags & 0x204002L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView9, newRequestUiArea);
        }
        if ((dirtyFlags & 0x200080L) != 0) {
            // api target 1

            this.newRequestCityItem.setAdapter(cityAdapter);
        }
        if ((dirtyFlags & 0x200002L) != 0) {
            // api target 1

            al.viki.foundation.binding.util.Adapter.adapter(this.newRequestCityItem, newRequestUiCityListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener);
            al.viki.foundation.binding.util.Adapter.adapter(this.newRequestCurrencyItem, newRequestUiCurrencyListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.newRequestFloorPlanItem, newRequestUiFloorPlan);
            al.viki.foundation.binding.util.Adapter.adapter(this.newRequestTypeItem, newRequestUiPropertyTypeListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener);
            al.viki.foundation.binding.util.Adapter.adapter(this.newRequestUnitItem, newRequestUiUnitListenerOnItemClickAndroidWidgetAdapterViewOnItemClickListener);
        }
        if ((dirtyFlags & 0x200004L) != 0) {
            // api target 1

            this.newRequestCurrencyItem.setAdapter(currencyAdapter);
        }
        if ((dirtyFlags & 0x201002L) != 0) {
            // api target 1

            this.newRequestFloorPlan.setVisibility(newRequestUiApartmentViewVISIBLEViewGONE);
        }
        if ((dirtyFlags & 0x200100L) != 0) {
            // api target 1

            this.newRequestLocation.setOnClickListener(onClickOnClickAndroidViewViewOnClickListener);
            this.newRequestSave.setOnClickListener(onClickOnClickAndroidViewViewOnClickListener);
        }
        if ((dirtyFlags & 0x210002L) != 0) {
            // api target 21
            if(getBuildSdkInt() >= 21) {

                this.newRequestLocation.setImageTintList(androidx.databinding.adapters.Converters.convertColorToColorStateList(newRequestUiLocationJavaLangObjectNullNewRequestLocationAndroidColorVikiColorPrimaryNewRequestLocationAndroidColorSuccess));
            }
        }
        if ((dirtyFlags & 0x3fec02L) != 0) {
            // api target 1

            this.newRequestSave.setEnabled(newRequestUiTitleBlankBooleanTrueNewRequestUiTitleEmptyNewRequestUiDescriptionBlankBooleanTrueNewRequestUiDescriptionEmptyNewRequestUiPriceBlankBooleanTrueNewRequestUiPriceEmptyNewRequestUiAddressBlankBooleanTrueNewRequestUiAddressEmptyNewRequestUiAreaBlankBooleanTrueNewRequestUiAreaEmptyNewRequestUiPropertyTypeJavaLangObjectNullNewRequestUiCurrencyJavaLangObjectNullNewRequestUiUnitJavaLangObjectNullNewRequestUiCityJavaLangObjectNullNewRequestUiLocationJavaLangObjectNull);
        }
        if ((dirtyFlags & 0x200008L) != 0) {
            // api target 1

            this.newRequestTypeItem.setAdapter(propertyTypeAdapter);
        }
        if ((dirtyFlags & 0x200200L) != 0) {
            // api target 1

            this.newRequestUnitItem.setAdapter(unitAdapter);
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
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): requestViewModel.request
        flag 1 (0x2L): newRequestUi
        flag 2 (0x3L): currencyAdapter
        flag 3 (0x4L): propertyTypeAdapter
        flag 4 (0x5L): floorPlanAdapter
        flag 5 (0x6L): operationAdapter
        flag 6 (0x7L): requestViewModel
        flag 7 (0x8L): cityAdapter
        flag 8 (0x9L): onClick
        flag 9 (0xaL): unitAdapter
        flag 10 (0xbL): newRequestUi.title
        flag 11 (0xcL): newRequestUi.description
        flag 12 (0xdL): newRequestUi.apartment
        flag 13 (0xeL): newRequestUi.price
        flag 14 (0xfL): newRequestUi.area
        flag 15 (0x10L): newRequestUi.address
        flag 16 (0x11L): newRequestUi.location
        flag 17 (0x12L): newRequestUi.propertyType
        flag 18 (0x13L): newRequestUi.currency
        flag 19 (0x14L): newRequestUi.unit
        flag 20 (0x15L): newRequestUi.city
        flag 21 (0x16L): null
        flag 22 (0x17L): !newRequestUi.description.blank ? true : !newRequestUi.description.empty
        flag 23 (0x18L): !newRequestUi.description.blank ? true : !newRequestUi.description.empty
        flag 24 (0x19L): newRequestUi.apartment ? View.VISIBLE : View.GONE
        flag 25 (0x1aL): newRequestUi.apartment ? View.VISIBLE : View.GONE
        flag 26 (0x1bL): !newRequestUi.price.blank ? true : !newRequestUi.price.empty
        flag 27 (0x1cL): !newRequestUi.price.blank ? true : !newRequestUi.price.empty
        flag 28 (0x1dL): newRequestUi.location != null ? @android:color/vikiColorPrimary : @android:color/success
        flag 29 (0x1eL): newRequestUi.location != null ? @android:color/vikiColorPrimary : @android:color/success
        flag 30 (0x1fL): !newRequestUi.title.blank ? true : !newRequestUi.title.empty
        flag 31 (0x20L): !newRequestUi.title.blank ? true : !newRequestUi.title.empty
        flag 32 (0x21L): requestViewModel.request.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
        flag 33 (0x22L): requestViewModel.request.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
        flag 34 (0x23L): !newRequestUi.address.blank ? true : !newRequestUi.address.empty
        flag 35 (0x24L): !newRequestUi.address.blank ? true : !newRequestUi.address.empty
        flag 36 (0x25L): !newRequestUi.area.blank ? true : !newRequestUi.area.empty
        flag 37 (0x26L): !newRequestUi.area.blank ? true : !newRequestUi.area.empty
    flag mapping end*/
    //end
}