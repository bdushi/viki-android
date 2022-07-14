package al.viki.model

import al.bruno.adapter.Selection

data class OperationUi(
    val id: Long,
    val operation: String,
    var selection: Boolean = false
) : Selection {
    override fun selection(selection: Boolean) {
        this.selection = selection
    }

    override fun searchCriteria(): String {
        return operation
    }

    override fun selection(): Boolean {
        return selection
    }

    override fun toString(): String {
        return operation
    }
}