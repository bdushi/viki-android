package al.viki.common

import al.viki.R
import al.viki.foundation.ui.model.MenuItem


val menus = arrayListOf(
    MenuItem(
        icon = R.drawable.ic_outlined_arrow_right,
        title = R.string.new_order,
        contentDescription = R.string.new_order
    ),
    MenuItem(
        icon = R.drawable.ic_outlined_arrow_left,
        title = R.string.new_request,
        contentDescription = R.string.new_request
    ),
    MenuItem(
        icon = R.drawable.ic_outlined_arrow_left,
        title = R.string.new_request,
        contentDescription = R.string.new_request
    ),
    MenuItem(
        icon = R.drawable.ic_outlined_arrow_left,
        title = R.string.new_request,
        contentDescription = R.string.new_request
    ),
    MenuItem(
        icon = R.drawable.ic_outlined_share,
        title = R.string.share,
        contentDescription = R.string.share
    ),
    MenuItem(
        icon = R.drawable.ic_outlined_settings,
        title = R.string.settings,
        contentDescription = R.string.settings
    ),
    MenuItem(
        icon = R.drawable.ic_logout,
        title = R.string.logout,
        contentDescription = R.string.logout
    )
)