package al.viki.model

import al.bruno.adapter.Selection

data class CurrencyUi(
    val id: Long?,
    val currency: String,
    var selection: Boolean = false
    ) : Selection {
    override fun selection(selection: Boolean) {
        this.selection = selection
    }

    override fun searchCriteria(): String {
        return currency
    }

    override fun selection(): Boolean {
        return selection
    }

    override fun toString(): String {
        return currency
    }
}