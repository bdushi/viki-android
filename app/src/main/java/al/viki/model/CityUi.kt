package al.viki.model

import al.bruno.adapter.Selection
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityUi(
    val id: Long,
    val city: String,
    val zipCode: String,
    val countryUi: CountryUi,
    var selection: Boolean = false
) : Selection, Parcelable {
    override fun setSelected(selection: Boolean) {
        this.selection = selection
    }

    override fun isSelected(): Boolean {
        return selection
    }

    override fun searchCriteria(): String {
        return city
    }

    override fun title(): String {
        return city
    }


    override fun toString(): String {
        return city
    }
}