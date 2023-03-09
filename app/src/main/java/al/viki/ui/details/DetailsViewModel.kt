package al.viki.ui.details

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.ImageRepository
import al.bruno.core.data.source.PropertiesRepository
import al.bruno.core.data.source.PropertyRepository
import al.bruno.core.data.source.RequestRepository
import al.bruno.core.data.source.model.response.PropertiesResponse
import al.viki.BuildConfig
import al.viki.model.ImagesUi
import al.viki.model.PropertiesUi
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
    private val propertiesRepository: PropertiesRepository,
    private val imageRepository: ImageRepository
) :
    ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _properties = MutableStateFlow<State<PropertiesUi>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val properties: StateFlow<State<PropertiesUi>> = _properties

    fun property(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _properties.value = State.Loading
            coroutineScope {
                val (property, images) = awaitAll(
                    async { propertiesRepository.properties(id) },
                    async { imageRepository.images("${BuildConfig.FILE_HOST_NAME}/resources/${id}") }
                )
                when (property) {
                    is Result.Error -> _properties.value = State.Error(property.error)
                    is Result.Success -> {
                        when (images) {
                            is Result.Error -> {
                                _properties.value = State.Success(
                                    PropertiesUi
                                        .toPropertyUi(
                                            (property.data as PropertiesResponse)
                                        )
                                )
                            }
                            is Result.Success -> {
                                _properties.value = State.Success(
                                    PropertiesUi
                                        .toPropertyUi(
                                            (property.data as PropertiesResponse),
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
            _properties.value = State.Loading
            when (val response = propertiesRepository.properties(id)) {
                is Result.Error -> _properties.value = State.Error(response.error)
                is Result.Success -> _properties.value = State.Success(PropertiesUi.toPropertyUi(response.data))
            }
        }
    }
}