package al.viki.ui.home

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.*
import al.bruno.core.data.source.model.response.PropertiesResponse
import al.viki.BuildConfig
import al.viki.common.NETWORK_PAGE_SIZE
import al.viki.model.ClusterItemUi
import al.viki.model.UserUi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
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
    private val _clusterProperties = MutableStateFlow<State<List<ClusterItemUi>>>(State.Loading)

    // The UI collects from this StateFlow to get its state updates
    val clusterProperties: StateFlow<State<List<ClusterItemUi>>> = _clusterProperties

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

    fun clusterProperties(query: Map<String, String>) {
        viewModelScope.launch(start = CoroutineStart.UNDISPATCHED) {
            _clusterProperties.value = propertiesRepository.properties(
                query = query
            )
                .onStart {
                    State.Loading
                }
                .map {
                    when (it) {
                        is Result.Error -> State.Error(it.error)
                        is Result.Success -> {
                            State.Success(
                                it.data.map { response ->
                                    ClusterItemUi(
                                        response.id,
                                        response.title,
                                        response.description,
                                        response.longitude,
                                        response.latitude,
                                        response.isRequest()
                                    )
                                }
                            )
                        }
                    }
                }.stateIn(viewModelScope).value
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

