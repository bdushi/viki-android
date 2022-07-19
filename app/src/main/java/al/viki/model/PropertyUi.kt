package al.viki.model

import al.bruno.core.data.source.model.response.PropertyResponse
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PropertyUi(
    val id: Long,
    val title: String,
    val description: String,
    val operation: String,
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
) : Parcelable {
    companion object {
        fun toPropertyUi(t: PropertyResponse) = PropertyUi(
            t.id,
            t.title,
            t.description,
            t.operation,
            t.username,
            t.email,
            t.firstName,
            t.lastName,
            t.city,
            t.zipCode,
            t.country,
            t.countryCode,
            t.address,
            t.currency,
            t.symbol,
            t.code,
            t.decimalMark,
            t.type,
            t.area,
            t.price,
            t.floorPlan,
            t.unit,
            t.longitude,
            t.latitude
        )
    }
}