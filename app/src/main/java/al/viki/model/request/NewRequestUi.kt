package al.viki.model.request

import al.viki.OnItemSelectedListener
import al.viki.model.CityUi
import android.view.View
import android.widget.AdapterView

class NewRequestUi {
    var title: String? = null
    var description: String? = null
    var cityUi: CityUi? = null
    var city: String? = null
    var operationUi: OperationUi? = null
    var operation: String? = null
    var address: String? = null
    var apartment: String? = null
    val citySelectedListener = object : OnItemSelectedListener {
        override fun onItemSelected(
            p0: AdapterView<*>,
            p1: View,
            p2: Int,
            p3: Long
        ) {
            cityUi = p0.selectedItem as CityUi?
        }
    }

    val operationSelectedListener = object : OnItemSelectedListener {
        override fun onItemSelected(
            p0: AdapterView<*>,
            p1: View,
            p2: Int,
            p3: Long
        ) {
            operationUi = p0.selectedItem as OperationUi?
        }
    }

}