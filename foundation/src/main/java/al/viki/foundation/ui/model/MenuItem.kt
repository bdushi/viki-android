package al.viki.foundation.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MenuItem(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    @StringRes val contentDescription: Int
)