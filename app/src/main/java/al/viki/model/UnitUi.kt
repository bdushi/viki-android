package al.viki.model

import al.bruno.adapter.Selection

data class UnitUi(
    val id: Long,
    val unit: String,
    var selection: Boolean = false
    ) : Selection {
    override fun selection(selection: Boolean) {
        this.selection = selection
    }

    override fun searchCriteria(): String {
        return unit
    }

    override fun selection(): Boolean {
        return selection
    }

    override fun toString(): String {
        return unit
    }
}