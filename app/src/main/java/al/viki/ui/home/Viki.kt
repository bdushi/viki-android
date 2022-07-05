package al.viki.ui.home

import al.viki.R
import al.viki.foundation.component.Header
import al.viki.foundation.component.SearchBox
import al.viki.foundation.ui.model.MenuItem
import al.viki.foundation.ui.model.Profile
import al.viki.foundation.ui.model.SearchMenu
import al.viki.ui.theme.VikiTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Viki(vikiViewModel: VikiViewModel) {
    VikiTheme {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(10.dp)
        ) {
            SearchBox(
                searchMenu = SearchMenu(
                    menuItems = arrayListOf(
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
                        )
                    ),
                    Profile(
                        icon = R.drawable.ic_launcher_background,
                        title = R.string.app_name,
                        subTitle = R.string.visit_your_profile
                    )
                ),
                menuCallback = {
                    when(it) {
                        0 -> {

                        }
                    }
                })
            Header(
                al.viki.foundation.ui.model.Header(
                    R.drawable.ic_outlined_swap_vert,
                    R.string.app_name,
                    R.string.map_view,
                    R.string.properties
                )
            )
            PropertyPagingItemsList(vikiViewModel.pagedProperties)
        }
    }
}
