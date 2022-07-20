package al.bruno.core.data.source.model

import com.squareup.moshi.Json

data class City(
    val id: Long?,
    val city: String?,
    val zipCode: String?,
    @field:Json(name = "country") val country: Country
)