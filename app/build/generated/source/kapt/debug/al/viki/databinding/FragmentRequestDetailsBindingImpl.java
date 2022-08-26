package al.viki.databinding;
import al.viki.R;
import al.viki.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentRequestDetailsBindingImpl extends FragmentRequestDetailsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.top_app_bar, 5);
        sViewsWithIds.put(R.id.details_property_agent_label, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView1;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView2;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentRequestDetailsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentRequestDetailsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.textview.MaterialTextView) bindings[4]
            , (com.google.android.material.textview.MaterialTextView) bindings[6]
            , (com.google.android.material.appbar.MaterialToolbar) bindings[5]
            );
        this.detailsPropertyAgent.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (com.google.android.material.textview.MaterialTextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (com.google.android.material.textview.MaterialTextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (com.google.android.material.textview.MaterialTextView) bindings[3];
        this.mboundView3.setTag(null);
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
        if (BR.request == variableId) {
            setRequest((al.viki.model.RequestUi) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setRequest(@Nullable al.viki.model.RequestUi Request) {
        this.mRequest = Request;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.request);
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
        java.lang.String detailsPropertyAgentAndroidStringAgentItemRequestFirstNameRequestLastName = null;
        java.lang.String requestDescription = null;
        java.lang.String requestLastName = null;
        java.lang.String requestFirstName = null;
        java.lang.String mboundView2AndroidStringPriceItemPerUnitRequestPriceRequestCodeRequestUnit = null;
        double requestPriceRequestArea = 0.0;
        double requestArea = 0.0;
        java.lang.String requestCode = null;
        java.lang.String requestUnit = null;
        java.lang.String mboundView1AndroidStringPriceItemRequestPriceRequestAreaRequestCode = null;
        al.viki.model.RequestUi request = mRequest;

        if ((dirtyFlags & 0x3L) != 0) {



                if (request != null) {
                    // read request.price
                    requestPrice = request.getPrice();
                    // read request.description
                    requestDescription = request.getDescription();
                    // read request.lastName
                    requestLastName = request.getLastName();
                    // read request.firstName
                    requestFirstName = request.getFirstName();
                    // read request.area
                    requestArea = request.getArea();
                    // read request.code
                    requestCode = request.getCode();
                    // read request.unit
                    requestUnit = request.getUnit();
                }


                // read @android:string/agent_item
                detailsPropertyAgentAndroidStringAgentItemRequestFirstNameRequestLastName = detailsPropertyAgent.getResources().getString(R.string.agent_item, requestFirstName, requestLastName);
                // read (request.price) * (request.area)
                requestPriceRequestArea = (requestPrice) * (requestArea);
                // read @android:string/price_item_per_unit
                mboundView2AndroidStringPriceItemPerUnitRequestPriceRequestCodeRequestUnit = mboundView2.getResources().getString(R.string.price_item_per_unit, requestPrice, requestCode, requestUnit);


                // read @android:string/price_item
                mboundView1AndroidStringPriceItemRequestPriceRequestAreaRequestCode = mboundView1.getResources().getString(R.string.price_item, requestPriceRequestArea, requestCode);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.detailsPropertyAgent, detailsPropertyAgentAndroidStringAgentItemRequestFirstNameRequestLastName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, mboundView1AndroidStringPriceItemRequestPriceRequestAreaRequestCode);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, mboundView2AndroidStringPriceItemPerUnitRequestPriceRequestCodeRequestUnit);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, requestDescription);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): request
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}