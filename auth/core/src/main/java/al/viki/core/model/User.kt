package al.viki.core.model

data class User(
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    val address: String,
    val phone: String,
    val authorities: List<Long>
)