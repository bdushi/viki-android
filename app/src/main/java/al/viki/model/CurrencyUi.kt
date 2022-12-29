package al.viki.model

import al.bruno.adapter.Selection
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyUi(
    val id: Long,
    val currency: String,
    val symbol: String,
    val code: String,
    val decimalMark: String,
    var selection: Boolean = false
    ) : Selection, Parcelable {
    override fun setSelected(selection: Boolean) {
        this.selection = selection
    }

    override fun searchCriteria(): String {
        return currency
    }

    override fun title(): String {
        return currency
    }

    override fun isSelected(): Boolean {
        return selection
    }

    override fun toString(): String {
        return currency
    }
}