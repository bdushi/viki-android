package al.viki.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserUi(
    val id: Long,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val address: String,
    val authorities: List<Long>
) : Parcelable