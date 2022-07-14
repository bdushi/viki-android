package al.bruno.core.data.source.model

import com.google.gson.annotations.SerializedName

data class City(
    val id: Long?,
    val city: String?,
    val zipCode: String?,
    @SerializedName("country") val country: Country
)