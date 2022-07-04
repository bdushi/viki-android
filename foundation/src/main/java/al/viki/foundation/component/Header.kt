package al.viki.foundation.component

import al.viki.foundation.ui.model.Header
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Header(
    header: Header
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = stringResource(id = header.propertiesTitle))
        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedButton(
                onClick = {},
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = stringResource(id = header.mapViewTitle))
            }
            OutlinedButton(
                onClick = {},
                modifier = Modifier.padding(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = header.icon),
                    contentDescription = ""
                )
            }
        }
    }
}