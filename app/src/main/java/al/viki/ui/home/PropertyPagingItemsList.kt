package al.viki.ui.home

import al.bruno.core.data.source.model.response.PropertyResponse
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import kotlinx.coroutines.flow.Flow

@Composable
fun PropertyPagingItemsList(propertyResponse: Flow<PagingData<PropertyResponse>>) {
    val propertyResponseUiLazyPagingItems = propertyResponse.collectAsLazyPagingItems()
    LazyColumn {
        items(items = propertyResponseUiLazyPagingItems) { property ->
            property?.let{
                PropertyItem(it)
            } ?: run {

            }
//            propertyResponseUiLazyPagingItems.apply {
//                when {
//                    // Data is loading for the first time
//                    loadState.refresh is LoadState.Loading -> {
//                        item { LoadingView() }
//                    }
//                    loadState.append is LoadState.Loading -> {
//                        item { LoadingItem() }
//                    }
//                    loadState.refresh is LoadState.Error -> {
//                        val e = loadState.refresh as LoadState.Error
//                        item {
//                            ErrorItem(
//                                message = e.error.localizedMessage,
//                                onClickRetry = { retry() }
//                            )
//                        }
//                    }
//                    loadState.append is LoadState.Error -> {
//                        val e = loadState.append as LoadState.Error
//                        item {
//                            ErrorItem(
//                                message = e.error.localizedMessage,
//                                onClickRetry = { retry() }
//                            )
//                        }
//                    }
//                }
//            }
        }
    }
}

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun LoadingItem() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorItem(message: String?, onClickRetry: () -> Unit) {
    Snackbar(
        content = { Text(text = message.toString()) },
        action = {
            TextButton(onClick = onClickRetry) {
                Text("Refresh", color = Color.Red)
            }
        }
    )
}