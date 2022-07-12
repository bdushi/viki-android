package al.viki.model.request

import al.bruno.adapter.Selection

data class OperationUi(
    val id: Long,
    val operation: String
) : Selection {
    override fun selection(selection: Boolean) {
        TODO("Not yet implemented")
    }

}