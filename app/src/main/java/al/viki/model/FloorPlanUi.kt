package al.viki.model

import al.bruno.adapter.Selection

data class FloorPlanUi(
    val id: Long,
    val floorPlan: String,
    var selection: Boolean = false
    )  : Selection {
    override fun selection(selection: Boolean) {
        this.selection = selection
    }

    override fun searchCriteria(): String {
        return floorPlan
    }

    override fun selection(): Boolean {
        return selection
    }

    override fun toString(): String {
        return floorPlan
    }
}