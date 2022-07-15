package al.viki.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationUi(
    val longitude: Double = 0.0,
    val latitude: Double = 0.0
) : Parcelable