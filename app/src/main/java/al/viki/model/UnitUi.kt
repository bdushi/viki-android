package al.viki.model

import al.bruno.adapter.Selection
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UnitUi(
    val id: Long,
    val unit: String,
    var selection: Boolean = false
    ) : Selection, Parcelable {
    override fun setSelected(selection: Boolean) {
        this.selection = selection
    }

    override fun searchCriteria(): String {
        return unit
    }

    override fun title(): String {
        return unit
    }

    override fun isSelected(): Boolean {
        return selection
    }

    override fun toString(): String {
        return unit
    }
}