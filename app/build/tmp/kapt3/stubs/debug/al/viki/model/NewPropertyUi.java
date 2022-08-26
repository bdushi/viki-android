package al.viki.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0012\u0010U\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR*\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00138G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR*\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001d8G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR&\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b\'\u0010\tR\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR*\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\u0003\u001a\u0004\u0018\u00010+8G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R*\u00102\u001a\u0004\u0018\u0001012\b\u0010\u0003\u001a\u0004\u0018\u0001018G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0011\u00107\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001cR&\u00109\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0007\"\u0004\b;\u0010\tR\u000e\u0010<\u001a\u00020=X\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010?\u001a\u0004\u0018\u00010>2\b\u0010\u0003\u001a\u0004\u0018\u00010>8G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0011\u0010D\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010\u001cR&\u0010F\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tR*\u0010J\u001a\u0004\u0018\u00010I2\b\u0010\u0003\u001a\u0004\u0018\u00010I8G@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0011\u0010O\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010\u001c\u00a8\u0006V"}, d2 = {"Lal/viki/model/NewPropertyUi;", "Landroidx/databinding/Observable;", "()V", "value", "", "address", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "", "apartment", "getApartment", "()Z", "setApartment", "(Z)V", "area", "getArea", "setArea", "Lal/viki/model/CityUi;", "city", "getCity", "()Lal/viki/model/CityUi;", "setCity", "(Lal/viki/model/CityUi;)V", "cityListener", "Landroid/widget/AdapterView$OnItemClickListener;", "getCityListener", "()Landroid/widget/AdapterView$OnItemClickListener;", "Lal/viki/model/CurrencyUi;", "currency", "getCurrency", "()Lal/viki/model/CurrencyUi;", "setCurrency", "(Lal/viki/model/CurrencyUi;)V", "currencyListener", "getCurrencyListener", "description", "getDescription", "setDescription", "floorPlan", "getFloorPlan", "setFloorPlan", "Lal/viki/model/LocationUi;", "location", "getLocation", "()Lal/viki/model/LocationUi;", "setLocation", "(Lal/viki/model/LocationUi;)V", "Lal/viki/model/OperationUi;", "operation", "getOperation", "()Lal/viki/model/OperationUi;", "setOperation", "(Lal/viki/model/OperationUi;)V", "operationListener", "getOperationListener", "price", "getPrice", "setPrice", "propertyChangeRegistry", "Landroidx/databinding/PropertyChangeRegistry;", "Lal/viki/model/PropertyTypeUi;", "propertyType", "getPropertyType", "()Lal/viki/model/PropertyTypeUi;", "setPropertyType", "(Lal/viki/model/PropertyTypeUi;)V", "propertyTypeListener", "getPropertyTypeListener", "title", "getTitle", "setTitle", "Lal/viki/model/UnitUi;", "unit", "getUnit", "()Lal/viki/model/UnitUi;", "setUnit", "(Lal/viki/model/UnitUi;)V", "unitListener", "getUnitListener", "addOnPropertyChangedCallback", "", "callback", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "removeOnPropertyChangedCallback", "app_debug"})
public final class NewPropertyUi implements androidx.databinding.Observable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String title = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String description = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String floorPlan = "";
    @org.jetbrains.annotations.Nullable()
    private al.viki.model.CityUi city;
    @org.jetbrains.annotations.Nullable()
    private al.viki.model.OperationUi operation;
    @org.jetbrains.annotations.Nullable()
    private al.viki.model.PropertyTypeUi propertyType;
    @org.jetbrains.annotations.Nullable()
    private al.viki.model.CurrencyUi currency;
    @org.jetbrains.annotations.Nullable()
    private al.viki.model.UnitUi unit;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String address = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String area = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String price = "";
    @org.jetbrains.annotations.Nullable()
    private al.viki.model.LocationUi location;
    private boolean apartment = false;
    private androidx.databinding.PropertyChangeRegistry propertyChangeRegistry;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.AdapterView.OnItemClickListener propertyTypeListener = null;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.AdapterView.OnItemClickListener operationListener = null;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.AdapterView.OnItemClickListener currencyListener = null;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.AdapterView.OnItemClickListener unitListener = null;
    @org.jetbrains.annotations.NotNull()
    private final android.widget.AdapterView.OnItemClickListener cityListener = null;
    
    public NewPropertyUi() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.databinding.Bindable()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.databinding.Bindable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFloorPlan() {
        return null;
    }
    
    public final void setFloorPlan(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.databinding.Bindable()
    public final al.viki.model.CityUi getCity() {
        return null;
    }
    
    public final void setCity(@org.jetbrains.annotations.Nullable()
    al.viki.model.CityUi value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.databinding.Bindable()
    public final al.viki.model.OperationUi getOperation() {
        return null;
    }
    
    public final void setOperation(@org.jetbrains.annotations.Nullable()
    al.viki.model.OperationUi value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.databinding.Bindable()
    public final al.viki.model.PropertyTypeUi getPropertyType() {
        return null;
    }
    
    public final void setPropertyType(@org.jetbrains.annotations.Nullable()
    al.viki.model.PropertyTypeUi value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.databinding.Bindable()
    public final al.viki.model.CurrencyUi getCurrency() {
        return null;
    }
    
    public final void setCurrency(@org.jetbrains.annotations.Nullable()
    al.viki.model.CurrencyUi value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.databinding.Bindable()
    public final al.viki.model.UnitUi getUnit() {
        return null;
    }
    
    public final void setUnit(@org.jetbrains.annotations.Nullable()
    al.viki.model.UnitUi value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.databinding.Bindable()
    public final java.lang.String getAddress() {
        return null;
    }
    
    public final void setAddress(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.databinding.Bindable()
    public final java.lang.String getArea() {
        return null;
    }
    
    public final void setArea(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.databinding.Bindable()
    public final java.lang.String getPrice() {
        return null;
    }
    
    public final void setPrice(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.databinding.Bindable()
    public final al.viki.model.LocationUi getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.Nullable()
    al.viki.model.LocationUi value) {
    }
    
    @androidx.databinding.Bindable()
    public final boolean getApartment() {
        return false;
    }
    
    public final void setApartment(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.AdapterView.OnItemClickListener getPropertyTypeListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.AdapterView.OnItemClickListener getOperationListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.AdapterView.OnItemClickListener getCurrencyListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.AdapterView.OnItemClickListener getUnitListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.AdapterView.OnItemClickListener getCityListener() {
        return null;
    }
    
    @java.lang.Override()
    public void removeOnPropertyChangedCallback(@org.jetbrains.annotations.Nullable()
    androidx.databinding.Observable.OnPropertyChangedCallback callback) {
    }
    
    @java.lang.Override()
    public void addOnPropertyChangedCallback(@org.jetbrains.annotations.Nullable()
    androidx.databinding.Observable.OnPropertyChangedCallback callback) {
    }
}