package al.viki.core.response.model

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    val username: String,
    val roles: List<String>,
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expiresIn: String,
)