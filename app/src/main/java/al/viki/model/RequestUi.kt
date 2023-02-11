package al.viki.model

import al.bruno.core.data.source.model.response.RequestResponse
import android.os.Bundle
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RequestUi(
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
) : Parcelable {
    companion object {
        fun toRequestUi(t: RequestResponse) = RequestUi(
            t.id,
            t.title,
            t.description,
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
        fun mapToRequestUi(map: Map<String, String>): RequestUi {
            return RequestUi(
                map.getValue("id").toLong(),
                map.getValue("title"),
                map.getValue("description"),
                map.getValue("username"),
                map.getValue("email"),
                map.getValue("firstName"),
                map.getValue("lastName"),
                map.getValue("city"),
                map.getValue("zipCode"),
                map.getValue("country"),
                map.getValue("countryCode"),
                map.getValue("address"),
                map.getValue("currency"),
                map.getValue("symbol"),
                map.getValue("code"),
                map.getValue("decimalMark"),
                map.getValue("type"),
                map.getValue("area").toDouble(),
                map.getValue("price").toDouble(),
                map.getValue("floorPlan"),
                map.getValue("unit"),
                map.getValue("longitude").toDouble(),
                map.getValue("latitude").toDouble(),
            )
        }

        fun bundleToRequestUi(bundle: Bundle): RequestUi {
            return RequestUi(
                bundle.getLong("id"),
                bundle.getString("title", ""),
                bundle.getString("description", ""),
                bundle.getString("username", ""),
                bundle.getString("email", ""),
                bundle.getString("firstName", ""),
                bundle.getString("lastName", ""),
                bundle.getString("city", ""),
                bundle.getString("zipCode", ""),
                bundle.getString("country", ""),
                bundle.getString("countryCode", ""),
                bundle.getString("address", ""),
                bundle.getString("currency", ""),
                bundle.getString("symbol", ""),
                bundle.getString("code", ""),
                bundle.getString("decimalMark", ""),
                bundle.getString("type", ""),
                bundle.getDouble("area"),
                bundle.getDouble("price"),
                bundle.getString("floorPlan", ""),
                bundle.getString("unit", ""),
                bundle.getDouble("longitude"),
                bundle.getDouble("latitude"),
            )
        }
    }
}