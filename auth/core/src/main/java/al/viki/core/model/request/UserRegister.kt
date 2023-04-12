package al.viki.core.model.request

class UserRegister(
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    val phone: String,
    val address: String,
    val authorities: List<Long>
)