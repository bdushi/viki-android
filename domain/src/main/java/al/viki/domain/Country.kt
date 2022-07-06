package al.viki.domain

data class Country (
    val id: Long,
    val country: String,
    val countryCode: String,
    val city: List<City>
)