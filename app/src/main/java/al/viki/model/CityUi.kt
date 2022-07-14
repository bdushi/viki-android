package al.viki.model

import al.bruno.adapter.Selection

data class CityUi(
    val id: Long,
    val city: String,
    val zipCode: String,
    val countryUi: CountryUi,
    var selection: Boolean = false
) : Selection{
    override fun selection(selection: Boolean) {
        this.selection = selection
    }

    override fun selection(): Boolean {
        return selection
    }

    override fun searchCriteria(): String {
        return city
    }


    override fun toString(): String {
        return city
    }
}