package al.viki.model

import al.bruno.adapter.Selection
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FloorPlanUi(
    val id: Long,
    val floorPlan: String,
    var selection: Boolean = false
) : Selection, Parcelable {
    override fun setSelected(selection: Boolean) {
        this.selection = selection
    }

    override fun searchCriteria(): String {
        return floorPlan
    }

    override fun title(): String {
        return floorPlan
    }

    override fun isSelected(): Boolean {
        return selection
    }

    override fun toString(): String {
        return floorPlan
    }
}