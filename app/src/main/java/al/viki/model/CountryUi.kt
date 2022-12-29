package al.viki.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryUi(
    val id: Long,
    val country: String,
    val countryCode: String
) : Parcelable