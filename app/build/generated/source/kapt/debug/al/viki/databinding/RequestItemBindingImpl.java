package al.viki.databinding;
import al.viki.R;
import al.viki.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RequestItemBindingImpl extends RequestItemBinding implements al.viki.generated.callback.OnClickListener.Listener {

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
    private final com.google.android.material.textview.MaterialTextView mboundView1;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView4;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView5;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView6;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView7;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView8;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RequestItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private RequestItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatImageView) bindings[3]
            , (androidx.appcompat.widget.AppCompatImageView) bindings[2]
            , (com.google.android.material.card.MaterialCardView) bindings[0]
            );
        this.mboundView1 = (com.google.android.material.textview.MaterialTextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView4 = (com.google.android.material.textview.MaterialTextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (com.google.android.material.textview.MaterialTextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (com.google.android.material.textview.MaterialTextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (com.google.android.material.textview.MaterialTextView) bindings[7];
        this.mboundView7.setTag(null);
        this.mboundView8 = (com.google.android.material.textview.MaterialTextView) bindings[8];
        this.mboundView8.setTag(null);
        this.requestDeleteItem.setTag(null);
        this.requestShareItem.setTag(null);
        this.requests.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new al.viki.generated.callback.OnClickListener(this, 2);
        mCallback3 = new al.viki.generated.callback.OnClickListener(this, 3);
        mCallback1 = new al.viki.generated.callback.OnClickListener(this, 1);
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
        if (BR.request == variableId) {
            setRequest((al.bruno.core.data.source.model.response.RequestResponse) variable);
        }
        else if (BR.onClick == variableId) {
            setOnClick((al.bruno.adapter.OnClickListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRequest(@Nullable al.bruno.core.data.source.model.response.RequestResponse Request) {
        this.mRequest = Request;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.request);
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
        double requestPrice = 0.0;
        java.lang.String requestTitle = null;
        java.lang.String mboundView7AndroidStringAreaItemRequestAreaRequestUnit = null;
        double requestPriceRequestArea = 0.0;
        java.lang.String mboundView4AndroidStringPriceItemRequestPriceRequestAreaRequestCode = null;
        boolean requestFloorPlanJavaLangObjectNull = false;
        java.lang.String requestCode = null;
        java.lang.String requestUnit = null;
        al.bruno.core.data.source.model.response.RequestResponse request = mRequest;
        java.lang.String requestAddress = null;
        int requestFloorPlanJavaLangObjectNullViewVISIBLEViewGONE = 0;
        java.lang.String requestFloorPlan = null;
        java.lang.String mboundView8AndroidStringPriceItemPerUnitRequestPriceRequestCodeRequestUnit = null;
        double requestArea = 0.0;
        al.bruno.adapter.OnClickListener<?> onClick = mOnClick;

        if ((dirtyFlags & 0x5L) != 0) {



                if (request != null) {
                    // read request.price
                    requestPrice = request.getPrice();
                    // read request.title
                    requestTitle = request.getTitle();
                    // read request.code
                    requestCode = request.getCode();
                    // read request.unit
                    requestUnit = request.getUnit();
                    // read request.address
                    requestAddress = request.getAddress();
                    // read request.floorPlan
                    requestFloorPlan = request.getFloorPlan();
                    // read request.area
                    requestArea = request.getArea();
                }


                // read @android:string/price_item_per_unit
                mboundView8AndroidStringPriceItemPerUnitRequestPriceRequestCodeRequestUnit = mboundView8.getResources().getString(R.string.price_item_per_unit, requestPrice, requestCode, requestUnit);
                // read request.floorPlan != null
                requestFloorPlanJavaLangObjectNull = (requestFloorPlan) != (null);
                // read @android:string/area_item
                mboundView7AndroidStringAreaItemRequestAreaRequestUnit = mboundView7.getResources().getString(R.string.area_item, requestArea, requestUnit);
                // read (request.price) * (request.area)
                requestPriceRequestArea = (requestPrice) * (requestArea);
            if((dirtyFlags & 0x5L) != 0) {
                if(requestFloorPlanJavaLangObjectNull) {
                        dirtyFlags |= 0x10L;
                }
                else {
                        dirtyFlags |= 0x8L;
                }
            }


                // read request.floorPlan != null ? View.VISIBLE : View.GONE
                requestFloorPlanJavaLangObjectNullViewVISIBLEViewGONE = ((requestFloorPlanJavaLangObjectNull) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                // read @android:string/price_item
                mboundView4AndroidStringPriceItemRequestPriceRequestAreaRequestCode = mboundView4.getResources().getString(R.string.price_item, requestPriceRequestArea, requestCode);
        }
        // batch finished
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, requestTitle);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, mboundView4AndroidStringPriceItemRequestPriceRequestAreaRequestCode);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, requestAddress);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, requestFloorPlan);
            this.mboundView6.setVisibility(requestFloorPlanJavaLangObjectNullViewVISIBLEViewGONE);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, mboundView7AndroidStringAreaItemRequestAreaRequestUnit);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView8, mboundView8AndroidStringPriceItemPerUnitRequestPriceRequestCodeRequestUnit);
        }
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.requestDeleteItem.setOnClickListener(mCallback3);
            this.requestShareItem.setOnClickListener(mCallback2);
            this.requests.setOnClickListener(mCallback1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // onClick != null
                boolean onClickJavaLangObjectNull = false;
                // onClick
                al.bruno.adapter.OnClickListener onClick = mOnClick;
                // request
                al.bruno.core.data.source.model.response.RequestResponse request = mRequest;



                onClickJavaLangObjectNull = (onClick) != (null);
                if (onClickJavaLangObjectNull) {




                    onClick.onClick(callbackArg_0, request);
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // onClick != null
                boolean onClickJavaLangObjectNull = false;
                // onClick
                al.bruno.adapter.OnClickListener onClick = mOnClick;
                // request
                al.bruno.core.data.source.model.response.RequestResponse request = mRequest;



                onClickJavaLangObjectNull = (onClick) != (null);
                if (onClickJavaLangObjectNull) {




                    onClick.onClick(callbackArg_0, request);
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // onClick != null
                boolean onClickJavaLangObjectNull = false;
                // onClick
                al.bruno.adapter.OnClickListener onClick = mOnClick;
                // request
                al.bruno.core.data.source.model.response.RequestResponse request = mRequest;



                onClickJavaLangObjectNull = (onClick) != (null);
                if (onClickJavaLangObjectNull) {




                    onClick.onClick(callbackArg_0, request);
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): request
        flag 1 (0x2L): onClick
        flag 2 (0x3L): null
        flag 3 (0x4L): request.floorPlan != null ? View.VISIBLE : View.GONE
        flag 4 (0x5L): request.floorPlan != null ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}