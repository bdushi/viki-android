package al.viki.foundation.component

import al.viki.foundation.ui.model.SearchMenu
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.compose.ui.window.SecureFlagPolicy

@Composable
fun SearchBox(
    searchMenu: SearchMenu,
    menuCallback: (Int) -> Unit
) {
    var searchValue by remember { mutableStateOf("") }
    var showMenu by remember { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = searchValue,
            onValueChange = {
                searchValue = it
            },
            modifier = Modifier
                .weight(8F, true),
            shape = RoundedCornerShape(16.dp)
        )
        Box(
            modifier = Modifier.weight(1F)
        ) {
            IconButton(
                onClick = {
                    showMenu = true
                }
            ) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            }
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                properties = PopupProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true,
                    securePolicy = SecureFlagPolicy.SecureOn
                ),
                offset = DpOffset(0.dp, 10.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = searchMenu.profile.icon),
                        contentDescription = stringResource(
                            id = searchMenu.profile.title
                        ),
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(64.dp)
                            .clip(CircleShape)
                    )
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Text(
                            text = stringResource(id = searchMenu.profile.title)
                        )
                        Text(
                            text = stringResource(id = searchMenu.profile.subTitle),
                            fontSize = 12.sp
                        )
                    }
                }
                Divider()
                searchMenu.menuItems.forEachIndexed { index, element ->
                    if(index == 2 || index == 4 || index == 5 || index == 6) {
                        Divider()
                    }
                    DropdownMenuItem(
                        contentPadding = PaddingValues(0.dp),
                        text = {
                            Row {
                                Text(
                                    text = stringResource(id = element.title),
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }, onClick = {
                            menuCallback.invoke(index)
                        }, leadingIcon = {
                            Icon(
                                painterResource(id = element.icon),
                                contentDescription = stringResource(id = element.contentDescription),
                                modifier = Modifier
                                    .padding(4.dp)
                            )
                        }
                    )
                }
            }
        }
    }
}