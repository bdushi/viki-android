package al.viki.ui.details

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.ImageRepository
import al.bruno.core.data.source.PropertyRepository
import al.viki.BuildConfig
import al.viki.model.ImagesUi
import al.viki.model.PropertyUi
import al.viki.model.RequestUi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
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

    // Backing property to avoid state updates from other classes
    private val _images = MutableStateFlow<State<List<ImagesUi>>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val images: StateFlow<State<List<ImagesUi>>> = _images

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

    fun property(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _property.value = State.Loading
            when (val response = propertyRepository.property(id)) {
                is Result.Error -> _property.value = State.Error(response.error)
                is Result.Success -> _property.value = State.Success(PropertyUi.toPropertyUi(response.data))
            }
        }
    }

    fun request(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _request.value = State.Loading
            when (val response = propertyRepository.request(id)) {
                is Result.Error -> _request.value = State.Error(response.error)
                is Result.Success -> _request.value = State.Success(RequestUi.toRequestUi(response.data))
            }
        }
    }
}