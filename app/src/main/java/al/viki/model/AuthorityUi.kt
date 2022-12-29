package al.viki.model

import al.bruno.adapter.Selection
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthorityUi(
    val id: Long,
    val authority: String,
    val description: String,
    var selection: Boolean = false
) : Selection, Parcelable {
    override fun setSelected(selection: Boolean) {
        this.selection = selection
    }

    override fun isSelected(): Boolean {
        return selection
    }

    override fun searchCriteria(): String {
        return description
    }

    override fun title(): String {
        return authority
    }


    override fun toString(): String {
        return description
    }
}
