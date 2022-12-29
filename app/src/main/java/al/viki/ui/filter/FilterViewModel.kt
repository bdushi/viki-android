package al.viki.ui.filter

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.*
import al.bruno.core.data.source.model.*
import al.bruno.core.data.source.model.Unit
import al.viki.model.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
    private val cityRepository: CityRepository,
    private val currencyRepository: CurrencyRepository,
    private val operationRepository: OperationRepository,
    private val propertyTypeRepository: PropertyTypeRepository,
    private val unitRepository: UnitRepository,
    private val propertyRepository: PropertyRepository
    ): ViewModel() {
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

    // Backing property to avoid state updates from other classes
    private val _operations = MutableStateFlow<State<List<OperationUi>?>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val operations: StateFlow<State<List<OperationUi>?>> = _operations

    init {
        viewModelScope.launch(Dispatchers.IO) {
            coroutineScope {
                val (cities, currencies, propertyTypes, units, operations) = awaitAll(
                    async { cityRepository.cities() },
                    async { currencyRepository.currencies() },
                    async { propertyTypeRepository.propertyTypes() },
                    async { unitRepository.units() },
                    async { operationRepository.operations() }
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

                when (operations) {
                    is Result.Error -> {
                        _operations.value = State.Error(operations.error)
                    }
                    is Result.Success -> {
                        _operations.value = State.Success(
                            (operations.data as List<Operation>).map {
                                OperationUi(
                                    it.id ?: 0,
                                    it.operation ?: ""
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}