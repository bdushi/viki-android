package al.viki.domain

data class Address(
    val id: Long,
    val city: City,
    val country: Country,
    val street: Street,
    val province: String,
    val address: String
)