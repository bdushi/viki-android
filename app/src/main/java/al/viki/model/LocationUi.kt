package al.viki.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationUi(
    val longitude: Double,
    val latitude: Double
) : Parcelable