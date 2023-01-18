package al.viki.ui.details

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.ImageRepository
import al.bruno.core.data.source.PropertyRepository
import al.bruno.core.data.source.model.response.PropertyResponse
import al.viki.BuildConfig
import al.viki.model.ImagesUi
import al.viki.model.PropertyUi
import al.viki.model.RequestUi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val propertyRepository: PropertyRepository,
    private val imageRepository: ImageRepository
) :
    ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _property = MutableStateFlow<State<PropertyUi>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val property: StateFlow<State<PropertyUi>> = _property

    // Backing property to avoid state updates from other classes
    private val _request = MutableStateFlow<State<RequestUi>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val request: StateFlow<State<RequestUi>> = _request

    fun property(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _property.value = State.Loading
            coroutineScope {
                val (property, images) = awaitAll(
                    async { propertyRepository.property(id) },
                    async { imageRepository.images("${BuildConfig.FILE_HOST_NAME}/resources/${id}") }
                )
                when (property) {
                    is Result.Error -> _property.value = State.Error(property.error)
                    is Result.Success -> {
                        when (images) {
                            is Result.Error -> {
                                _property.value = State.Success(
                                    PropertyUi
                                        .toPropertyUi(
                                            (property.data as PropertyResponse)
                                        )
                                )
                            }
                            is Result.Success -> {
                                _property.value = State.Success(
                                    PropertyUi
                                        .toPropertyUi(
                                            (property.data as PropertyResponse),
                                            (images.data as Set<String>).map { s ->
                                                ImagesUi("${BuildConfig.FILE_HOST_NAME}/resources/$id/$s")
                                            }
                                        )
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    fun request(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _request.value = State.Loading
            when (val response = propertyRepository.request(id)) {
                is Result.Error -> _request.value = State.Error(response.error)
                is Result.Success -> _request.value =
                    State.Success(RequestUi.toRequestUi(response.data))
            }
        }
    }
}