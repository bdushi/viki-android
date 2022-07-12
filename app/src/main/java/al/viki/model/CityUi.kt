package al.viki.model

import al.bruno.adapter.Selection
import al.viki.model.response.CountryUi

data class CityUi(
    val id: Long,
    val city: String,
    val zipCode: String,
    val countryUi: CountryUi
) : Selection {
    override fun selection(selection: Boolean) {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return city
    }
}