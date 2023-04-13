package al.viki.ui.home

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.*
import al.viki.BuildConfig
import al.viki.common.NETWORK_PAGE_SIZE
import al.viki.model.ClusterItemUi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bumptech.glide.RequestManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModel @Inject constructor(
    private val propertyRepository: PropertyRepository,
    private val requestRepository: RequestRepository,
    private val propertiesRepository: PropertiesRepository,
    private val imageRepository: ImageRepository,
    private val requestManager: RequestManager,
) : ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _delete = MutableStateFlow<State<Boolean>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val delete: StateFlow<State<Boolean>> = _delete

    val query = MutableStateFlow<Map<String, String>>(emptyMap())

    val propertiesCollectionPagedList = query.flatMapLatest {
        Pager(
            config = PagingConfig(
                initialLoadSize = NETWORK_PAGE_SIZE,
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                PropertiesPagingSource(
                    propertiesRepository = propertiesRepository,
                    query = it
                )
            }
        ).flow
            .cachedIn(viewModelScope)
            .stateIn(
                viewModelScope + Dispatchers.IO,
                SharingStarted.WhileSubscribed(5_000),
                PagingData.empty()
            )
    }

    val clusterProperties = query.flatMapLatest {
        propertiesRepository.properties(it)
    }.map {
        when (it) {
            is Result.Error -> State.Error(it.error)
            is Result.Success -> {
                State.Success(
                    it.data.map { response ->
                        val item = ClusterItemUi(
                            response.id,
                            response.title,
                            response.description,
                            response.longitude,
                            response.latitude,
                            response.isRequest()
                        )
                        item.drawable(requestManager)
                        item
                    }
                )
            }
        }
    }
        .stateIn(
            viewModelScope + Dispatchers.IO,
            SharingStarted.WhileSubscribed(5_000),
            State.Loading
        )

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
                                State.Success((property.data as Boolean))
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

