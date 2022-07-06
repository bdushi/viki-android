package al.bruno.core.data.source.model.response

import com.google.gson.annotations.SerializedName

data class CityResponse(
    val id: Long,
    val city: String,
    val zipCode: String,
    @SerializedName("country") val countryResponse: CountryResponse
)