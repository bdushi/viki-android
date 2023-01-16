package al.viki.ui.home

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.ImageRepository
import al.bruno.core.data.source.PropertyRepository
import al.bruno.core.data.source.PropertyTypeRepository
import al.bruno.core.data.source.UserRepository
import al.bruno.core.data.source.model.response.PropertyResponse
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
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val propertyRepository: PropertyRepository,
    private val propertyTypeRepository: PropertyTypeRepository,
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
    private val _items = MutableStateFlow<State<List<ClusterItem>>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val items: StateFlow<State<List<ClusterItem>>> = _items

    // Backing property to avoid state updates from other classes
    private val _images = MutableStateFlow<State<List<ImagesUi>>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val images: StateFlow<State<List<ImagesUi>>> = _images

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
    ): Flow<PagingData<PropertyResponse>> = Pager(
        config = PagingConfig(
            initialLoadSize = NETWORK_PAGE_SIZE,
            pageSize = NETWORK_PAGE_SIZE,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            PropertiesPagingSource(
                propertyRepository = propertyRepository,
                query = query
            )
        }
    ).flow

    fun requestCollectionPagedList(
        query: Map<String, String>
    ): Flow<PagingData<RequestResponse>> = Pager(
        config = PagingConfig(
            initialLoadSize = NETWORK_PAGE_SIZE,
            pageSize = NETWORK_PAGE_SIZE,
            enablePlaceholders = true
        ),
        pagingSourceFactory = {
            RequestPagingSource(
                propertyRepository = propertyRepository,
                query = query
            )
        }
    ).flow

    fun items(query: Map<String, String>, properties: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            if (properties) {
                when (val response = propertyRepository.properties(
                    page = 0,
                    size = 100,
                    query = query
                )) {
                    is Result.Error -> _delete.value = State.Error(response.error)
                    is Result.Success -> {
                        _items.value = State.Success(
                            response.data.pageResponse?.map {
                                PropertyUi.toPropertyUi(it)
                            }
                        )
                    }
                }
            } else {
                when (val response = propertyRepository.requests(
                    page = 0,
                    size = 100,
                    query = query
                )) {
                    is Result.Error -> _delete.value = State.Error(response.error)
                    is Result.Success -> {
                        _items.value = State.Success(
                            response.data.pageResponse?.map {
                                RequestUi.toRequestUi(it)
                            }
                        )
                    }
                }
            }
        }
    }

    fun deleteProperty(id: Long) {
        _delete.value = State.Loading
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = propertyRepository.deleteProperty(id)) {
                is Result.Error -> _delete.value = State.Error(response.error)
                is Result.Success -> {
                    when (val delete =
                        imageRepository.delete("${BuildConfig.FILE_HOST_NAME}/resources/delete/${id}")) {
                        is Result.Error -> {
                            _delete.value = State.Error(delete.error)
                        }
                        is Result.Success -> {
                            _delete.value = State.Success(delete.data == 200)
                        }
                    }
                }
            }
        }
    }

    fun deleteRequest(id: Long) {
        _delete.value = State.Loading
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = propertyRepository.deleteRequest(id)) {
                is Result.Error -> _delete.value = State.Error(response.error)
                is Result.Success -> _delete.value = State.Success(response.data)
            }
        }
    }

    fun images(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response =
                imageRepository.images("${BuildConfig.FILE_HOST_NAME}/resources/${id}")) {
                is Result.Error -> _images.value = State.Error(response.error)
                is Result.Success -> _images.value = State.Success(
                    response.data.map { s ->
                        ImagesUi("${BuildConfig.FILE_HOST_NAME}/resources/$id/$s")
                    }
                )
            }
        }
    }
}

