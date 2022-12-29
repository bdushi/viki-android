package al.viki.model

import al.bruno.adapter.Selection
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OperationUi(
    val id: Long,
    val operation: String,
    var selection: Boolean = false
) : Selection, Parcelable {
    override fun setSelected(selection: Boolean) {
        this.selection = selection
    }

    override fun searchCriteria(): String {
        return operation
    }

    override fun title(): String {
        return operation
    }

    override fun isSelected(): Boolean {
        return selection
    }

    override fun toString(): String {
        return operation
    }
}