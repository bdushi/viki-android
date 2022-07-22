package al.bruno.core.data.source.model.response

data class RequestResponse(
    val id: Long,
    val title: String,
    val description: String,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val city: String,
    val zipCode: String,
    val country: String,
    val countryCode: String,
    val address: String,
    val currency: String,
    val symbol: String,
    val code: String,
    val decimalMark: String,
    val type: String,
    val area: Double,
    val price: Double,
    val floorPlan: String?,
    val unit: String,
    val longitude: Double,
    val latitude: Double
)