package al.viki.foundation.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Profile(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    @StringRes val subTitle: Int,
)