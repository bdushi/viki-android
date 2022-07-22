package al.bruno.core.data.source.model.request

import al.bruno.core.data.source.model.*

data class RequestRequest(
    val title: String,
    val description: String,
    val floorPlan: String,
    val propertyType: PropertyType,
    val attribute: Attribute,
    val address: Address,
    val location: Location
)