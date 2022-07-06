package al.viki.domain

import java.time.OffsetDateTime

data class Property(
    val id: Long,
    val title: String,
    val description: String,
    val destination: String,
    val address: Address,
    val currency: Currency,
    val propertyType: PropertyType,
    val area: Area,
    val price: Price,
    val florPlan: FlorPlan,
    val location: Location
)