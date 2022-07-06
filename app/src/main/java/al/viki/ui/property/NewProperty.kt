@file:OptIn(ExperimentalMaterial3Api::class)

package al.viki.ui.property

import al.viki.R
import al.viki.foundation.component.autocomplete.AutoComplete
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * https://www.devbitsandbytes.com/jetpack-compose-a-simple-opiniated-autocompletetextview/
 */

@Composable
fun NewProperty(
    propertyViewModel: PropertyViewModel,
    navigateUp: () -> Unit,
    success: () -> Unit,
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(text = stringResource(id = R.string.new_request)) },
                navigationIcon = {
                    IconButton(onClick = navigateUp, content = {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = "Back to Home"
                        )
                    })
                }
            )
        },

        content = {
            it.calculateBottomPadding()
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                TextField(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    value = title,
                    onValueChange = {
                        title = it
                    },
                    label = { Text(text = stringResource(id = R.string.title)) }
                )

                TextField(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    value = description,
                    onValueChange = {
                        description = it
                    },
                    label = { Text(text = stringResource(id = R.string.description)) }
                )

                Row {
                    TextField(
                        modifier = Modifier
                            .padding(4.dp)
                            .clickable {  }
                            .fillMaxWidth(),
                        value = city,
                        onValueChange = {
                            city = it
                        },
                        label = { Text(text = stringResource(id = R.string.city)) },
                        readOnly = true
                    )
                    TextField(
                        modifier = Modifier
                            .padding(4.dp)
                            .clickable {  }
                            .fillMaxWidth(),
                        value = city,
                        onValueChange = {
                            city = it
                        },
                        label = { Text(text = stringResource(id = R.string.city)) },
                        readOnly = true
                    )
                }

                Button(
                    enabled = description.isNotEmpty() && title.isNotEmpty(),
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.End),
                    onClick = {
                        success.invoke()
                    }) {
                    Text(text = stringResource(id = R.string.save))
                }
            }
        }
    )
}