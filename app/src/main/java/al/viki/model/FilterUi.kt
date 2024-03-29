package al.viki.model

import al.viki.R
import al.viki.common.Entry
import android.os.Parcelable
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
class FilterUi(
    var properties: Boolean = true,
    var type: String? = null,
    var city: String? = null,
    var operation: String? = null,
    var unit: String? = null,
    var currency: String? = null,
    var price: String? = null,
    var area: String? = null,
    private var entry: Entry = Entry.PROPERTY
) : OnItemSelectedListener, OnCheckedChangeListener, Parcelable {
    @IgnoredOnParcel
    private var query: HashMap<String, String> = HashMap()
    @IgnoredOnParcel
    val isProperties = MutableStateFlow(true)
    override fun onItemSelected(adapter: AdapterView<*>, view: View, position: Int, id: Long) {
        when(adapter.id) {
            R.id.filter_property_type -> {
                type = (adapter.selectedItem as PropertyTypeUi).propertyType
            }
            R.id.filter_operation -> {
                operation = (adapter.selectedItem as OperationUi).operation
            }
            R.id.filter_city -> {
                city = (adapter.selectedItem as CityUi).city
            }
            R.id.filter_currency -> {
                currency = (adapter.selectedItem as CurrencyUi).currency
            }
            R.id.filter_unit -> {
                unit = (adapter.selectedItem as UnitUi).unit
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        properties = isChecked
        isProperties.value = isChecked
        if(!isChecked) {
            operation = null
            entry = Entry.REQUEST
        } else {
            entry = Entry.PROPERTY
        }
    }

    fun getQuery() : Map<String, String> {
        query = HashMap()
        type?.let {
            query["type"] = it
        }
        city?.let {
            query["city"] = it
        }
        operation?.let {
            query["operation"] = it
        }
        unit?.let {
            query["unit"] = it
        }
        currency?.let {
            query["currency"] = it
        }
        price?.let {
            query["currency"] = it
        }
        area?.let {
            query["currency"] = it
        }
        query["label"] = entry.name
        return query
    }

    fun getQuery(searchQuery: String) : Map<String, String> {
        query = HashMap()
        type?.let {
            query["type"] = it
        }
        city?.let {
            query["city"] = it
        }
        operation?.let {
            query["operation"] = it
        }
        unit?.let {
            query["unit"] = it
        }
        currency?.let {
            query["currency"] = it
        }
        price?.let {
            query["currency"] = it
        }
        area?.let {
            query["currency"] = it
        }
        query["searchQuery"] = searchQuery
        query["label"] = entry.name
        return query
    }
}