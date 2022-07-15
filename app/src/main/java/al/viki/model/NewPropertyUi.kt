package al.viki.model

import al.viki.BR
import al.viki.R
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry

class NewPropertyUi : Observable {
    @get:Bindable
    var title: String? = null
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.title)
        }
    @get:Bindable
    var description: String? = null
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.description)
        }
    var floorPlan: String? = null
    @get:Bindable
    var city: CityUi? = null
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.city)
        }
    @get:Bindable
    var operation: OperationUi? = null
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.operation)
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
    var address: String? = null
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.address)
        }
    @get:Bindable
    var area: String? = null
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.area)
        }
    @get:Bindable
    var price: String? = null
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
    val operationListener = AdapterView.OnItemClickListener { adapterView, _, position, _ ->
        operation = adapterView?.getItemAtPosition(position) as OperationUi?
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