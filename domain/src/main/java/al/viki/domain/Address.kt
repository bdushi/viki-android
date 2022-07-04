package al.viki.domain

import java.time.OffsetDateTime

data class Address(
    val id: Long,
    val city: City,
    val country: Country,
    val street: Street,
    val address: String,
    val dateCreated: OffsetDateTime,
    val lastUpdated: OffsetDateTime
)