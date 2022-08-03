package al.viki.model

import al.bruno.adapter.Selection

data class AuthorityUi(
    val id: Long,
    val authority: String,
    val description: String,
    var selection: Boolean = false
) : Selection {
    override fun selection(selection: Boolean) {
        this.selection = selection
    }

    override fun selection(): Boolean {
        return selection
    }

    override fun searchCriteria(): String {
        return description
    }


    override fun toString(): String {
        return description
    }
}
