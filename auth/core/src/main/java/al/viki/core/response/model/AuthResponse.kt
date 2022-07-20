package al.viki.core.response.model

import com.squareup.moshi.Json

data class AuthResponse(
    val username: String,
    val roles: List<String>,
    @field:Json(name = "access_token")
    val accessToken: String,
    @field:Json(name = "token_type")
    val tokenType: String,
    @field:Json(name = "expires_in")
    val expiresIn: String,
)