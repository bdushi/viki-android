package al.viki.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImagesUi(
    val photo: String
) : Parcelable