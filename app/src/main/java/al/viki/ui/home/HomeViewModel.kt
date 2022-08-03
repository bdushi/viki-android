package al.viki.ui.home

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.PropertyRepository
import al.bruno.core.data.source.PropertyTypeRepository
import al.bruno.core.data.source.model.response.PropertyResponse
import al.bruno.core.data.source.model.response.RequestResponse
import al.viki.common.NETWORK_PAGE_SIZE
import al.viki.model.PropertyTypeUi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val propertyRepository: PropertyRepository,
    private val propertyTypeRepository: PropertyTypeRepository
    ): ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _propertyTypes = MutableStateFlow<State<List<PropertyTypeUi>>>(State.Success(listOf()))
    // The UI collects from this StateFlow to get its state updates
    val propertyTypes: StateFlow<State<List<PropertyTypeUi>>> = _propertyTypes

    init {
        propertyTypes()
    }

    fun propertiesCollectionPagedList(): Flow<PagingData<PropertyResponse>> = Pager(
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

    fun requestCollectionPagedList(): Flow<PagingData<RequestResponse>> = Pager(
        config = PagingConfig(
            pageSize = NETWORK_PAGE_SIZE,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            RequestPagingSource(
                propertyRepository = propertyRepository
            )
        }
    ).flow

    private fun propertyTypes() {
        _propertyTypes.value = State.Loading
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = propertyTypeRepository.propertyTypes()) {
                is Result.Unauthorized -> {
                    _propertyTypes.value = State.Unauthorized
                }
                is Result.Success -> {
                    _propertyTypes.value = State.Success(
                        response.data.map {
                            PropertyTypeUi(
                                it.id ?: 0,
                                it.type ?: ""
                            )
                        }
                    )
                }
                is Result.Error -> {
                    _propertyTypes.value = State.Error(response.error)
                }
            }
        }
    }
}

