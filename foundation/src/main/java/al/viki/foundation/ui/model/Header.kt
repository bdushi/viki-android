package al.viki.foundation.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Header(
    @DrawableRes val icon: Int,
    // ToDo
    @StringRes val iconContentDescription: Int,
    @StringRes val mapViewTitle: Int,
    @StringRes val propertiesTitle: Int
)