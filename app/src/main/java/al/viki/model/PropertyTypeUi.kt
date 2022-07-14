package al.viki.model

import al.bruno.adapter.Selection

data class PropertyTypeUi(
    val id: Long,
    var propertyType: String,
    var selection: Boolean = false
    ) : Selection {
    override fun selection(selection: Boolean) {
        this.selection = selection
    }

    override fun searchCriteria(): String {
        return propertyType
    }

    override fun selection(): Boolean {
        return selection
    }

    override fun toString(): String {
        return propertyType
    }
}