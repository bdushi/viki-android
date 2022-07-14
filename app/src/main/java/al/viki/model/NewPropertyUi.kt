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
    var title: String? = null
    var description: String? = null
    var floorPlan: String? = null
    var city: CityUi? = null
    var operation: OperationUi? = null
        @Bindable
        get
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.operation)
        }
    var propertyType: PropertyTypeUi? = null
        @Bindable
        get
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.propertyType)
        }
    var currency: CurrencyUi? = null
    var unit: UnitUi? = null
    var address: String? = null
    var area: String? = null
    var price: String? = null
    var location: LocationUi? = null

    var enable = true
        @Bindable
        get
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.enable)
        }
//        title != null &&
//                description != null &&
//                city != null &&
//                operation != null &&
//                propertyType != null &&
//                floorPlan != null &&
//                currency != null &&
//                unit != null &&
//                area != null &&
//                price != null &&
//                address != null

    var apartment = propertyType?.propertyType == "Apartament" || propertyType?.propertyType == "Apartment"
        @Bindable
        get
        set(value) {
            field = value
            propertyChangeRegistry.notifyChange(this, BR.apartment)
        }

    private var propertyChangeRegistry = PropertyChangeRegistry()

    val propertyTypeListener = AdapterView.OnItemClickListener { adapterView, _, position, _ ->
        propertyType = adapterView?.getItemAtPosition(position) as PropertyTypeUi?
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