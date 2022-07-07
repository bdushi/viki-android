package al.bruno.core.data.source.model.response

data class PropertyResponse(
    val id: Long,
    val title: String,
    val description: String,
    val operation: String,
    val city: String,
    val zipCode: String,
    val country: String,
    val countryCode: String,
    val street: String,
    val address: String,
    val currency: String,
    val type: String,
    val area: Double,
    val price: Double,
    val florPlan: String,
    val unit: String,
    val longitude: Double,
    val latitude: Double
    )