package al.viki.ui.request

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.*
import al.bruno.core.data.source.model.*
import al.bruno.core.data.source.model.Unit
import al.bruno.core.data.source.model.request.RequestRequest
import al.viki.model.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class RequestViewModel @Inject constructor(
    private val cityRepository: CityRepository,
    private val currencyRepository: CurrencyRepository,
    private val propertyTypeRepository: PropertyTypeRepository,
    private val unitRepository: UnitRepository,
    private val requestRepository: RequestRepository
) : ViewModel() {
    // Backing property to avoid state updates from other classes
    private val _cities = MutableStateFlow<State<List<CityUi>?>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val cities: StateFlow<State<List<CityUi>?>> = _cities

    // Backing property to avoid state updates from other classes
    private val _currencies = MutableStateFlow<State<List<CurrencyUi>?>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val currencies: StateFlow<State<List<CurrencyUi>?>> = _currencies

    // Backing property to avoid state updates from other classes
    private val _propertyTypes = MutableStateFlow<State<List<PropertyTypeUi>?>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val propertyTypes: StateFlow<State<List<PropertyTypeUi>?>> = _propertyTypes

    // Backing property to avoid state updates from other classes
    private val _units = MutableStateFlow<State<List<UnitUi>?>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val units: StateFlow<State<List<UnitUi>?>> = _units

    // Backing property to avoid state updates from other classes
    private val _request = MutableStateFlow<State<Int>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val request: StateFlow<State<Int>> = _request

    init {
        viewModelScope.launch(Dispatchers.IO) {
            coroutineScope {
                val (cities, currencies, propertyTypes, units) = awaitAll(
                    async { cityRepository.cities() },
                    async { currencyRepository.currencies() },
                    async { propertyTypeRepository.propertyTypes() },
                    async { unitRepository.units() }
                )

                when (cities) {
                    is Result.Error -> {
                        _cities.value = State.Error(cities.error)
                    }
                    is Result.Success -> {
                        _cities.value = State.Success((cities.data as List<City>).map {
                            CityUi(
                                it.id ?: 0,
                                it.city ?: "",
                                it.zipCode ?: "",
                                CountryUi(
                                    it.country.id ?: 0,
                                    it.country.country ?: "",
                                    it.country.countryCode ?: ""
                                )
                            )
                        })
                    }
                }
                when (currencies) {
                    is Result.Error -> {
                        _currencies.value = State.Error(currencies.error)
                    }
                    is Result.Success -> {
                        _currencies.value = State.Success(
                            (currencies.data as List<Currency>).map {
                                CurrencyUi(
                                    it.id ?: 0,
                                    it.currency ?: "",
                                    it.symbol ?: "",
                                    it.code ?: "",
                                    it.decimalMark ?: ""
                                )
                            }
                        )
                    }
                }
                when (propertyTypes) {
                    is Result.Error -> {
                        _propertyTypes.value = State.Error(propertyTypes.error)
                    }
                    is Result.Success -> {
                        _propertyTypes.value = State.Success(
                            (propertyTypes.data as List<PropertyType>).map {
                                PropertyTypeUi(
                                    it.id ?: 0,
                                    it.type ?: ""
                                )
                            }
                        )
                    }
                }
                when (units) {
                    is Result.Error -> {
                        _units.value = State.Error(units.error)
                    }
                    is Result.Success -> {
                        _units.value = State.Success(
                            (units.data as List<Unit>).map {
                                UnitUi(
                                    it.id ?: 0,
                                    it.unit ?: ""
                                )
                            }
                        )
                    }
                }
            }
        }
    }

    fun save(newRequestUi: NewRequestUi) {
        viewModelScope.launch(Dispatchers.IO) {
            _request.value = State.Loading
            when (val response = requestRepository.request(
                RequestRequest(
                    newRequestUi.title,
                    newRequestUi.description,
                    newRequestUi.floorPlan,
                    PropertyType(
                        newRequestUi.propertyType?.id,
                        newRequestUi.propertyType?.propertyType
                    ),
                    Attribute(
                        newRequestUi.price,
                        newRequestUi.area,
                        Currency(
                            newRequestUi.currency?.id,
                            newRequestUi.currency?.currency,
                            newRequestUi.currency?.symbol,
                            newRequestUi.currency?.code,
                            newRequestUi.currency?.decimalMark
                        ),
                        Unit(
                            newRequestUi.unit?.id,
                            newRequestUi.unit?.unit
                        ),
                    ),
                    Address(
                        newRequestUi.address,
                        "TODO-This going to be defined in the future",
                        City(
                            newRequestUi.city?.id,
                            newRequestUi.city?.city,
                            newRequestUi.city?.zipCode,
                            Country(
                                newRequestUi.city?.countryUi?.id,
                                newRequestUi.city?.countryUi?.country,
                                newRequestUi.city?.countryUi?.countryCode
                            )
                        ),
                        Country(
                            newRequestUi.city?.countryUi?.id,
                            newRequestUi.city?.countryUi?.country,
                            newRequestUi.city?.countryUi?.countryCode
                        )
                    ),
                    Location(
                        newRequestUi.location?.longitude ?: 0.0,
                        newRequestUi.location?.latitude ?: 0.0
                    )
                )
            )) {
                is Result.Error -> _request.value = State.Error(response.error)
                is Result.Success -> _request.value = State.Success(response.data)
            }
        }
    }
}