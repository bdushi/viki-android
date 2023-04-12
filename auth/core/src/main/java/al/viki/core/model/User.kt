package al.viki.core.model

data class User(
    val id: Long,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val address: String,
    val authorities: List<Long>
)