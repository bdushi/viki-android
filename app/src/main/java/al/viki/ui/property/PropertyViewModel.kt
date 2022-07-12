package al.viki.ui.property

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.CityRepository
import al.viki.model.CityUi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyViewModel @Inject constructor(private val cityRepository: CityRepository): ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _cities = MutableStateFlow<State<List<CityUi>>>(State.Success<List<CityUi>>(arrayListOf()))

    // The UI collects from this StateFlow to get its state updates
    val cities: StateFlow<State<List<CityUi>>> = _cities

//    var citiesUi: List<CityUi> by mutableStateOf(listOf())
//        private set

    private val _progress = MutableStateFlow(false)
    val progress: StateFlow<Boolean> = _progress

    init {
        cities()
    }

    private fun cities() {
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = cityRepository.cities()) {
                is Result.Loading -> {
                    _progress.value = true
                }
                is Result.Unauthorized -> {
                    _cities.value = State.Unauthorized
                }
                is Result.Success -> {
//                    cities.value = response.data.map {
//                        CityUi(
//                            it.id,
//                            it.city,
//                            it.zipCode,
//                            CountryUi(
//                                it.countryResponse.id,
//                                it.countryResponse.country,
//                                it.countryResponse.countryCode
//                            )
//                        )
//                    }
                    _progress.value = false
                }
                is Result.Error -> {
                    _cities.value = State.Error(response.error)
                    _progress.value = false
                }
            }
        }
    }
}