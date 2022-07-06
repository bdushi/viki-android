package al.viki.model.response

data class CityUi(
    val id: Long,
    val city: String,
    val zipCode: String,
    val countryUi: CountryUi
)