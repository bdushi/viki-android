package al.viki

import android.view.View
import android.widget.Adapter
import android.widget.AdapterView

interface OnItemSelectedListener {
    fun onItemSelected(adapter: AdapterView<*>, view: View, position: Int, id: Long)
}