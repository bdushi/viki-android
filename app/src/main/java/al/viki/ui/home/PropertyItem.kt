@file:OptIn(ExperimentalMaterial3Api::class)

package al.viki.ui.home

import al.bruno.core.data.source.model.response.PropertyResponse
import al.viki.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PropertyItem(propertyResponse: PropertyResponse) {
    ElevatedCard(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = propertyResponse.title)
            Text(text = propertyResponse.price.toString())
            Text(text = propertyResponse.address)
            Row {
                Text(text = propertyResponse.florPlan)
                Text(text = propertyResponse.area)
                Text(text = propertyResponse.price.toString())
                Text(text = propertyResponse.type)
            }
        }
    }
}

