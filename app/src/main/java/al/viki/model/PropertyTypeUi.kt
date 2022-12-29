package al.viki.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import al.bruno.adapter.Selection

@Parcelize
data class PropertyTypeUi(
    val id: Long,
    var propertyType: String,
    var selection: Boolean = false
    ) : Selection, Parcelable {
    override fun setSelected(selection: Boolean) {
        this.selection = selection
    }

    override fun searchCriteria(): String {
        return propertyType
    }

    override fun title(): String {
        return propertyType
    }

    override fun isSelected(): Boolean {
        return selection
    }

    override fun toString(): String {
        return propertyType
    }
}