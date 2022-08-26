package al.viki.databinding;
import al.viki.R;
import al.viki.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRequestNewAccountBindingImpl extends FragmentRequestNewAccountBinding implements al.viki.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.request_new_account_app_bar_layout, 7);
        sViewsWithIds.put(R.id.forgot_password_top_app_bar, 8);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final android.widget.ProgressBar mboundView1;
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView2;
    @NonNull
    private final com.google.android.material.textfield.TextInputLayout mboundView3;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView4;
    @NonNull
    private final androidx.appcompat.widget.AppCompatSpinner mboundView5;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback7;
    // values
    // listeners
    private OnItemSelectedImpl mRequestNewAccountViewModelOnItemSelectedAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected;
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of requestNewAccountViewModel.email.getValue()
            //         is requestNewAccountViewModel.email.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // requestNewAccountViewModel.email
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> requestNewAccountViewModelEmail = null;
            // requestNewAccountViewModel
            al.viki.ui.account.RequestNewAccountViewModel requestNewAccountViewModel = mRequestNewAccountViewModel;
            // requestNewAccountViewModel.email.getValue()
            java.lang.String requestNewAccountViewModelEmailGetValue = null;
            // requestNewAccountViewModel.email != null
            boolean requestNewAccountViewModelEmailJavaLangObjectNull = false;
            // requestNewAccountViewModel != null
            boolean requestNewAccountViewModelJavaLangObjectNull = false;



            requestNewAccountViewModelJavaLangObjectNull = (requestNewAccountViewModel) != (null);
            if (requestNewAccountViewModelJavaLangObjectNull) {


                requestNewAccountViewModelEmail = requestNewAccountViewModel.getEmail();

                requestNewAccountViewModelEmailJavaLangObjectNull = (requestNewAccountViewModelEmail) != (null);
                if (requestNewAccountViewModelEmailJavaLangObjectNull) {




                    requestNewAccountViewModelEmail.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentRequestNewAccountBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentRequestNewAccountBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.google.android.material.button.MaterialButton) bindings[6]
            , (com.google.android.material.appbar.MaterialToolbar) bindings[8]
            , (com.google.android.material.appbar.AppBarLayout) bindings[7]
            );
        this.btForgotPassword.setTag(null);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ProgressBar) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (androidx.core.widget.NestedScrollView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (com.google.android.material.textfield.TextInputLayout) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (com.google.android.material.textfield.TextInputEditText) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (androidx.appcompat.widget.AppCompatSpinner) bindings[5];
        this.mboundView5.setTag(null);
        setRootTag(root);
        // listeners
        mCallback7 = new al.viki.generated.callback.OnClickListener(this, 1);
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
        if (BR.requestNewAccountViewModel == variableId) {
            setRequestNewAccountViewModel((al.viki.ui.account.RequestNewAccountViewModel) variable);
        }
        else if (BR.adapter == variableId) {
            setAdapter((al.bruno.adapter.DropDownAdapter) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRequestNewAccountViewModel(@Nullable al.viki.ui.account.RequestNewAccountViewModel RequestNewAccountViewModel) {
        this.mRequestNewAccountViewModel = RequestNewAccountViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.requestNewAccountViewModel);
        super.requestRebind();
    }
    public void setAdapter(@Nullable al.bruno.adapter.DropDownAdapter Adapter) {
        this.mAdapter = Adapter;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeRequestNewAccountViewModelEmail((kotlinx.coroutines.flow.MutableStateFlow<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeRequestNewAccountViewModelRequest((kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Boolean>>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeRequestNewAccountViewModelEmail(kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> RequestNewAccountViewModelEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeRequestNewAccountViewModelRequest(kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Boolean>> RequestNewAccountViewModelRequest, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        boolean androidxDatabindingViewDataBindingSafeUnboxValidationKtIsValidEmailRequestNewAccountViewModelEmail = false;
        al.viki.ui.account.RequestNewAccountViewModel requestNewAccountViewModel = mRequestNewAccountViewModel;
        boolean AndroidxDatabindingViewDataBindingSafeUnboxValidationKtIsValidEmailRequestNewAccountViewModelEmail1 = false;
        boolean requestNewAccountViewModelRequestInstanceofStateLoading = false;
        androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected requestNewAccountViewModelOnItemSelectedAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected = null;
        java.lang.String requestNewAccountViewModelEmailGetValue = null;
        java.lang.String validationKtIsValidEmailRequestNewAccountViewModelEmailMboundView3AndroidStringInvalidEmailJavaLangObjectNull = null;
        int requestNewAccountViewModelRequestInstanceofStateLoadingViewVISIBLEViewGONE = 0;
        java.lang.Boolean validationKtIsValidEmailRequestNewAccountViewModelEmail = null;
        kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> requestNewAccountViewModelEmail = null;
        al.bruno.adapter.DropDownAdapter<? extends al.bruno.adapter.Selection,? extends androidx.databinding.ViewDataBinding> adapter = mAdapter;
        kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Boolean>> requestNewAccountViewModelRequest = null;
        int requestNewAccountViewModelRequestInstanceofStateLoadingViewGONEViewVISIBLE = 0;
        boolean ValidationKtIsValidEmailRequestNewAccountViewModelEmail1 = false;
        al.bruno.core.State<java.lang.Boolean> requestNewAccountViewModelRequestGetValue = null;

        if ((dirtyFlags & 0x17L) != 0) {


            if ((dirtyFlags & 0x14L) != 0) {

                    if (requestNewAccountViewModel != null) {
                        // read requestNewAccountViewModel::onItemSelected
                        requestNewAccountViewModelOnItemSelectedAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected = (((mRequestNewAccountViewModelOnItemSelectedAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected == null) ? (mRequestNewAccountViewModelOnItemSelectedAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected = new OnItemSelectedImpl()) : mRequestNewAccountViewModelOnItemSelectedAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected).setValue(requestNewAccountViewModel));
                    }
            }
            if ((dirtyFlags & 0x15L) != 0) {

                    if (requestNewAccountViewModel != null) {
                        // read requestNewAccountViewModel.email
                        requestNewAccountViewModelEmail = requestNewAccountViewModel.getEmail();
                    }
                    androidx.databinding.ViewDataBindingKtx.updateStateFlowRegistration(this, 0, requestNewAccountViewModelEmail);


                    if (requestNewAccountViewModelEmail != null) {
                        // read requestNewAccountViewModel.email.getValue()
                        requestNewAccountViewModelEmailGetValue = requestNewAccountViewModelEmail.getValue();
                    }


                    // read ValidationKt.isValidEmail(requestNewAccountViewModel.email.getValue())
                    validationKtIsValidEmailRequestNewAccountViewModelEmail = al.viki.foundation.ui.utils.ValidationKt.isValidEmail(requestNewAccountViewModelEmailGetValue);


                    // read androidx.databinding.ViewDataBinding.safeUnbox(ValidationKt.isValidEmail(requestNewAccountViewModel.email.getValue()))
                    androidxDatabindingViewDataBindingSafeUnboxValidationKtIsValidEmailRequestNewAccountViewModelEmail = androidx.databinding.ViewDataBinding.safeUnbox(validationKtIsValidEmailRequestNewAccountViewModelEmail);
                if((dirtyFlags & 0x15L) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxValidationKtIsValidEmailRequestNewAccountViewModelEmail) {
                            dirtyFlags |= 0x40L;
                    }
                    else {
                            dirtyFlags |= 0x20L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(ValidationKt.isValidEmail(requestNewAccountViewModel.email.getValue())) ? @android:string/invalid_email : null
                    validationKtIsValidEmailRequestNewAccountViewModelEmailMboundView3AndroidStringInvalidEmailJavaLangObjectNull = ((androidxDatabindingViewDataBindingSafeUnboxValidationKtIsValidEmailRequestNewAccountViewModelEmail) ? (mboundView3.getResources().getString(al.viki.authentication.R.string.invalid_email)) : (null));
                    // read !androidx.databinding.ViewDataBinding.safeUnbox(ValidationKt.isValidEmail(requestNewAccountViewModel.email.getValue()))
                    ValidationKtIsValidEmailRequestNewAccountViewModelEmail1 = !androidxDatabindingViewDataBindingSafeUnboxValidationKtIsValidEmailRequestNewAccountViewModelEmail;


                    // read androidx.databinding.ViewDataBinding.safeUnbox(!androidx.databinding.ViewDataBinding.safeUnbox(ValidationKt.isValidEmail(requestNewAccountViewModel.email.getValue())))
                    AndroidxDatabindingViewDataBindingSafeUnboxValidationKtIsValidEmailRequestNewAccountViewModelEmail1 = androidx.databinding.ViewDataBinding.safeUnbox(ValidationKtIsValidEmailRequestNewAccountViewModelEmail1);
            }
            if ((dirtyFlags & 0x16L) != 0) {

                    if (requestNewAccountViewModel != null) {
                        // read requestNewAccountViewModel.request
                        requestNewAccountViewModelRequest = requestNewAccountViewModel.getRequest();
                    }
                    androidx.databinding.ViewDataBindingKtx.updateStateFlowRegistration(this, 1, requestNewAccountViewModelRequest);


                    if (requestNewAccountViewModelRequest != null) {
                        // read requestNewAccountViewModel.request.getValue()
                        requestNewAccountViewModelRequestGetValue = requestNewAccountViewModelRequest.getValue();
                    }


                    // read requestNewAccountViewModel.request.getValue() instanceof State.Loading
                    requestNewAccountViewModelRequestInstanceofStateLoading = requestNewAccountViewModelRequestGetValue instanceof al.bruno.core.State.Loading;
                if((dirtyFlags & 0x16L) != 0) {
                    if(requestNewAccountViewModelRequestInstanceofStateLoading) {
                            dirtyFlags |= 0x100L;
                            dirtyFlags |= 0x400L;
                    }
                    else {
                            dirtyFlags |= 0x80L;
                            dirtyFlags |= 0x200L;
                    }
                }


                    // read requestNewAccountViewModel.request.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
                    requestNewAccountViewModelRequestInstanceofStateLoadingViewVISIBLEViewGONE = ((requestNewAccountViewModelRequestInstanceofStateLoading) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                    // read requestNewAccountViewModel.request.getValue() instanceof State.Loading ? View.GONE : View.VISIBLE
                    requestNewAccountViewModelRequestInstanceofStateLoadingViewGONEViewVISIBLE = ((requestNewAccountViewModelRequestInstanceofStateLoading) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
            }
        }
        if ((dirtyFlags & 0x18L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            this.btForgotPassword.setEnabled(AndroidxDatabindingViewDataBindingSafeUnboxValidationKtIsValidEmailRequestNewAccountViewModelEmail1);
            this.mboundView3.setError(validationKtIsValidEmailRequestNewAccountViewModelEmailMboundView3AndroidStringInvalidEmailJavaLangObjectNull);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, requestNewAccountViewModelEmailGetValue);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.btForgotPassword.setOnClickListener(mCallback7);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x16L) != 0) {
            // api target 1

            this.mboundView1.setVisibility(requestNewAccountViewModelRequestInstanceofStateLoadingViewVISIBLEViewGONE);
            this.mboundView2.setVisibility(requestNewAccountViewModelRequestInstanceofStateLoadingViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            this.mboundView5.setAdapter(adapter);
        }
        if ((dirtyFlags & 0x14L) != 0) {
            // api target 1

            androidx.databinding.adapters.AdapterViewBindingAdapter.setOnItemSelectedListener(this.mboundView5, (androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected)requestNewAccountViewModelOnItemSelectedAndroidxDatabindingAdaptersAdapterViewBindingAdapterOnItemSelected, (androidx.databinding.adapters.AdapterViewBindingAdapter.OnNothingSelected)null, (androidx.databinding.InverseBindingListener)null);
        }
    }
    // Listener Stub Implementations
    public static class OnItemSelectedImpl implements androidx.databinding.adapters.AdapterViewBindingAdapter.OnItemSelected{
        private al.viki.ui.account.RequestNewAccountViewModel value;
        public OnItemSelectedImpl setValue(al.viki.ui.account.RequestNewAccountViewModel value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onItemSelected(android.widget.AdapterView arg0, android.view.View arg1, int arg2, long arg3) {
            this.value.onItemSelected(arg0, arg1, arg2, arg3); 
        }
    }
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // requestNewAccountViewModel
        al.viki.ui.account.RequestNewAccountViewModel requestNewAccountViewModel = mRequestNewAccountViewModel;
        // requestNewAccountViewModel != null
        boolean requestNewAccountViewModelJavaLangObjectNull = false;



        requestNewAccountViewModelJavaLangObjectNull = (requestNewAccountViewModel) != (null);
        if (requestNewAccountViewModelJavaLangObjectNull) {


            requestNewAccountViewModel.requestNewAccount();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): requestNewAccountViewModel.email
        flag 1 (0x2L): requestNewAccountViewModel.request
        flag 2 (0x3L): requestNewAccountViewModel
        flag 3 (0x4L): adapter
        flag 4 (0x5L): null
        flag 5 (0x6L): androidx.databinding.ViewDataBinding.safeUnbox(ValidationKt.isValidEmail(requestNewAccountViewModel.email.getValue())) ? @android:string/invalid_email : null
        flag 6 (0x7L): androidx.databinding.ViewDataBinding.safeUnbox(ValidationKt.isValidEmail(requestNewAccountViewModel.email.getValue())) ? @android:string/invalid_email : null
        flag 7 (0x8L): requestNewAccountViewModel.request.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
        flag 8 (0x9L): requestNewAccountViewModel.request.getValue() instanceof State.Loading ? View.VISIBLE : View.GONE
        flag 9 (0xaL): requestNewAccountViewModel.request.getValue() instanceof State.Loading ? View.GONE : View.VISIBLE
        flag 10 (0xbL): requestNewAccountViewModel.request.getValue() instanceof State.Loading ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}