package al.viki.ui.model.response

data class PropertyResponseUi(
    val id: Long,
    val title: String,
    val description: String,
    val city: String,
    val zipCode: String,
    val country: String,
    val countryCode: String,
    val street: String,
    val address: String,
    val currency: String,
    val type: String,
    val area: String,
    val price: Double,
    val florPlan: String,
    val longitude: Double,
    val latitude: Double
)