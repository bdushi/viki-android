package al.viki.ui.home

import al.viki.R
import al.viki.common.menus
import al.viki.foundation.component.Header
import al.viki.foundation.component.SearchBox
import al.viki.foundation.ui.model.Header
import al.viki.foundation.ui.model.Profile
import al.viki.foundation.ui.model.SearchMenu
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Home(
    vikiViewModel: VikiViewModel,
    menuCallback: (index: Int) -> Unit,
    profile: () -> Unit,
) {
    var query by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(10.dp)
    ) {
        SearchBox(
            searchMenu = SearchMenu(
                menuItems = menus,
                Profile(
                    icon = R.drawable.ic_launcher_background,
                    title = R.string.app_name,
                    subTitle = R.string.visit_your_profile
                )
            ),
            menuCallback = {
                menuCallback(it)
            },
            viewYourProfileCallback = profile,
            onQueryChanged = {
                query = it
            },
            query
        )
        Header(
            Header(
                R.drawable.ic_outlined_swap_vert,
                R.string.app_name,
                R.string.map_view,
                R.string.properties
            )
        )
        PropertyPagingItemsList(vikiViewModel.pagedProperties)
    }
}