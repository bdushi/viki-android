package al.viki.foundation.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SearchMenu(
    val menuItems: List<MenuItem>,
    val profile: Profile
)