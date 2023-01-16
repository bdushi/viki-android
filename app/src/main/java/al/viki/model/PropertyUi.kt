package al.viki.model

import al.bruno.core.data.source.model.response.PropertyResponse
import android.os.Bundle
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PropertyUi(
    private val id: Long,
    private val title: String,
    private val description: String,
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
    private val longitude: Double,
    private val latitude: Double
) : Parcelable, ClusterItem {
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
        fun mapToPropertyUi(map: Map<String, String>): PropertyUi {
            return PropertyUi(
                map.getValue("id").toLong(),
                map.getValue("title"),
                map.getValue("description"),
                map.getValue("operation"),
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

        fun bundleToPropertyUi(bundle: Bundle): PropertyUi {
            return PropertyUi(
                bundle.getLong("id"),
                bundle.getString("title", ""),
                bundle.getString("description", ""),
                bundle.getString("operation", ""),
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

    override fun getTitle(): String {
        return title
    }

    override fun getId(): Long {
        return id
    }

    override fun getLongitude(): Double {
        return longitude
    }

    override fun getLatitude(): Double {
        return latitude
    }

    override fun getDescription(): String {
        return description
    }
}