package al.viki.model

import al.viki.BR
import android.widget.AdapterView
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry

class NewRequestUi : Observable {
    @get:Bindable
    var title: String = ""
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.title)
        }
    @get:Bindable
    var description: String = ""
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.description)
        }
    var floorPlan: String = ""
    @get:Bindable
    var city: CityUi? = null
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.city)
        }
    @get:Bindable
    var propertyType: PropertyTypeUi? = null
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.propertyType)
        }
    @get:Bindable
    var currency: CurrencyUi? = null
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.currency)
        }
    @get:Bindable
    var unit: UnitUi? = null
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.unit)
        }
    @get:Bindable
    var address: String = ""
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.address)
        }
    @get:Bindable
    var area: String = ""
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.area)
        }
    @get:Bindable
    var price: String = ""
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.price)
        }
    @get:Bindable
    var location: LocationUi? = null
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.price)
        }
    @get:Bindable
    var apartment = false
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.apartment)
        }

    private var propertyChangeRegistry = PropertyChangeRegistry()

    val propertyTypeListener = AdapterView.OnItemClickListener { adapterView, _, position, _ ->
        propertyType = adapterView?.getItemAtPosition(position) as PropertyTypeUi?
        apartment = propertyType?.propertyType == "Apartament" || propertyType?.propertyType == "Apartment"
    }
    val currencyListener = AdapterView.OnItemClickListener { adapterView, _, position, _ ->
        currency = adapterView?.getItemAtPosition(position) as CurrencyUi?
    }
    val unitListener = AdapterView.OnItemClickListener { adapterView, _, position, _ ->
        unit = adapterView?.getItemAtPosition(position) as UnitUi?
    }
    val cityListener = AdapterView.OnItemClickListener { adapterView, _, position, _ ->
        city = adapterView?.getItemAtPosition(position) as CityUi?
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }
}