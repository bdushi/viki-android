package al.bruno.core.data.source.model

data class Address(
    val address: String?,
    val province: String,
    val city: City,
    val country: Country
)