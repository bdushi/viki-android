package al.viki.ui.home

import al.bruno.core.data.source.PropertyRepository
import al.bruno.core.data.source.model.response.PropertyResponse
import al.viki.PropertiesPageSource
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class VikiViewModel @Inject constructor(private val propertyRepository: PropertyRepository): ViewModel() {
    val pagedProperties: Flow<PagingData<PropertyResponse>> = Pager(
        PagingConfig(
            pageSize = NETWORK_PAGE_SIZE,
            enablePlaceholders = true
        )
    ) {
        PropertiesPageSource(leaveRepository = propertyRepository)
    }.flow
}

const val NETWORK_PAGE_SIZE = 10