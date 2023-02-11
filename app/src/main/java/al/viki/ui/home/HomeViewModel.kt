package al.viki.ui.home

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.*
import al.bruno.core.data.source.model.response.PropertiesResponse
import al.bruno.core.data.source.model.response.RequestResponse
import al.viki.BuildConfig
import al.viki.common.NETWORK_PAGE_SIZE
import al.viki.model.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val propertyRepository: PropertyRepository,
    private val requestRepository: RequestRepository,
    private val propertiesRepository: PropertiesRepository,
    private val userRepository: UserRepository,
    private val imageRepository: ImageRepository
) : ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _user = MutableStateFlow<State<UserUi>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val user: StateFlow<State<UserUi>> = _user

    // Backing property to avoid state updates from other classes
    private val _delete = MutableStateFlow<State<Boolean>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val delete: StateFlow<State<Boolean>> = _delete

    // Backing property to avoid state updates from other classes
    private val _clusterItem = MutableStateFlow<State<List<ClusterItemUi>>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val clusterItem: StateFlow<State<List<ClusterItemUi>>> = _clusterItem

    init {
        user()
    }

    private fun user() {
        _user.value = State.Loading
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = userRepository.user()) {
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
        query: Map<String, String>
    ): Flow<PagingData<PropertiesResponse>> = Pager(
        config = PagingConfig(
            initialLoadSize = NETWORK_PAGE_SIZE,
            pageSize = NETWORK_PAGE_SIZE,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            PropertiesPagingSource(
                propertiesRepository = propertiesRepository,
                query = query
            )
        }
    ).flow

    fun properties(query: Map<String, String>) {
        viewModelScope.launch(Dispatchers.IO) {
            _clusterItem.value = State.Loading
            when (val response = propertiesRepository.properties(
                query = query
            )) {
                is Result.Error -> _clusterItem.value = State.Error(response.error)
                is Result.Success -> {
                    _clusterItem.value = State.Success(
                        response.data.map {
                            ClusterItemUi(
                                it.id,
                                it.title,
                                it.description,
                                it.longitude,
                                it.latitude,
                                it.isRequest()
                            )
                        }
                    )
                }
            }
        }
    }

    fun deleteProperty(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _delete.value = State.Loading
            val (property, images) = awaitAll(
                async { propertyRepository.deleteProperty(id) },
                async { imageRepository.delete("${BuildConfig.FILE_HOST_NAME}/resources/delete/${id}") }
            )
            when (property) {
                is Result.Error -> _delete.value = State.Error(property.error)
                is Result.Success -> {
                    when (images) {
                        is Result.Error -> {
                            _delete.value = State.Error(images.error)
                        }
                        is Result.Success -> {
                            _delete.value =
                                State.Success((property.data as Boolean) && (images.data as Int) == 200)
                        }
                    }
                }
            }
        }
    }

    fun deleteRequest(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _delete.value = State.Loading
            when (val response = requestRepository.deleteRequest(id)) {
                is Result.Error -> _delete.value = State.Error(response.error)
                is Result.Success -> _delete.value = State.Success(response.data)
            }
        }
    }
}

