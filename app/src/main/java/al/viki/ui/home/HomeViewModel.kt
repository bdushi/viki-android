package al.viki.ui.home

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.PropertyRepository
import al.bruno.core.data.source.PropertyTypeRepository
import al.bruno.core.data.source.UserRepository
import al.bruno.core.data.source.model.response.PropertyResponse
import al.bruno.core.data.source.model.response.RequestResponse
import al.viki.common.NETWORK_PAGE_SIZE
import al.viki.model.PropertyTypeUi
import al.viki.model.UserUi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val propertyRepository: PropertyRepository,
    private val propertyTypeRepository: PropertyTypeRepository,
    private val userRepository: UserRepository
    ): ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _propertyTypes = MutableStateFlow<State<List<PropertyTypeUi>>>(State.Success(listOf()))
    // The UI collects from this StateFlow to get its state updates
    val propertyTypes: StateFlow<State<List<PropertyTypeUi>>> = _propertyTypes


    // Backing property to avoid state updates from other classes
    private val _user = MutableStateFlow<State<UserUi>>(State.Success(null))
    // The UI collects from this StateFlow to get its state updates
    val user: StateFlow<State<UserUi>> = _user

    // Backing property to avoid state updates from other classes
    private val _delete = MutableStateFlow<State<Boolean>>(State.Success(null))
    // The UI collects from this StateFlow to get its state updates
    val delete: StateFlow<State<Boolean>> = _delete

    init {
        propertyTypes()
        user()
    }

    private fun user() {
        _user.value = State.Loading
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = userRepository.user()) {
                is Result.Error -> {
                    _user.value = State.Error(response.error)
                }
                is Result.Success -> {
                    _user.value = State.Success(
                        UserUi(
                            response.data.id,
                            response.data.username,
                            response.data.email,
                            response.data.firstName,
                            response.data.lastName,
                            response.data.phone,
                            response.data.address,
                            response.data.authorities,
                        )
                    )
                }
            }
        }
    }

    fun propertiesCollectionPagedList(
        type: String? = null,
        searchQuery: CharSequence? = null
    ): Flow<PagingData<PropertyResponse>> = Pager(
        config = PagingConfig(
            initialLoadSize = NETWORK_PAGE_SIZE,
            pageSize = NETWORK_PAGE_SIZE,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            PropertiesPagingSource(
                propertyRepository = propertyRepository,
                type = type,
                searchQuery = searchQuery
            )
        }
    ).flow

    fun requestCollectionPagedList(
        type: String? = null,
        searchQuery: CharSequence? = null
    ): Flow<PagingData<RequestResponse>> = Pager(
        config = PagingConfig(
            initialLoadSize = NETWORK_PAGE_SIZE,
            pageSize = NETWORK_PAGE_SIZE,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            RequestPagingSource(
                propertyRepository = propertyRepository,
                type = type,
                searchQuery = searchQuery
            )
        }
    ).flow

    private fun propertyTypes() {
        _propertyTypes.value = State.Loading
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = propertyTypeRepository.propertyTypes()) {
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
                is Result.Error -> _propertyTypes.value = State.Error(response.error)
            }
        }
    }


    fun deleteProperty(id: Long) {
        _delete.value = State.Loading
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = propertyRepository.deleteProperty(id)) {
                is Result.Error -> _delete.value = State.Error(response.error)
                is Result.Success -> _delete.value = State.Success(response.data)
            }
        }
    }

    fun deleteRequest(id: Long) {
        _delete.value = State.Loading
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = propertyRepository.deleteRequest(id)) {
                is Result.Error -> _delete.value = State.Error(response.error)
                is Result.Success -> _delete.value = State.Success(response.data)
            }
        }
    }
}

