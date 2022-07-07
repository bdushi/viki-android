package al.viki.ui.home

import al.bruno.core.data.source.PropertyRepository
import al.bruno.core.data.source.model.response.PropertyResponse
import al.viki.common.NETWORK_PAGE_SIZE
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val propertyRepository: PropertyRepository): ViewModel() {
    fun collectionPagedList(): Flow<PagingData<PropertyResponse>> = Pager(
        config = PagingConfig(
            pageSize = NETWORK_PAGE_SIZE,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            PropertiesPagingSource(
                propertyRepository = propertyRepository
            )
        }
    ).flow
}

