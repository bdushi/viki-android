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
                is Result.Unauthorized -> {
                    _user.value = State.Unauthorized
                }
            }
        }
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

