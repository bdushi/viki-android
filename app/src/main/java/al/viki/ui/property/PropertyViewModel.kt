package al.viki.ui.property

import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.*
import al.bruno.core.data.source.model.*
import al.bruno.core.data.source.model.request.*
import al.viki.model.*
import al.viki.model.CountryUi
import al.viki.model.NewPropertyUi
import android.database.Cursor
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyViewModel @Inject constructor(
    private val cityRepository: CityRepository,
    private val currencyRepository: CurrencyRepository,
    private val floorPlanRepository: FloorPlanRepository,
    private val operationRepository: OperationRepository,
    private val propertyTypeRepository: PropertyTypeRepository,
    private val unitRepository: UnitRepository,
    private val propertyRepository: PropertyRepository
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
    private val _operations = MutableStateFlow<State<List<OperationUi>?>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val operations: StateFlow<State<List<OperationUi>?>> = _operations

    // Backing property to avoid state updates from other classes
    private val _propertyTypes = MutableStateFlow<State<List<PropertyTypeUi>?>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val propertyTypes: StateFlow<State<List<PropertyTypeUi>?>> = _propertyTypes

    // Backing property to avoid state updates from other classes
    private val _units = MutableStateFlow<State<List<UnitUi>?>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val units: StateFlow<State<List<UnitUi>?>> = _units

    // Backing property to avoid state updates from other classes
    private val _properties = MutableStateFlow<State<Int>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val properties: StateFlow<State<Int>> = _properties

    private val photoList: MutableList<PhotoUi> = mutableListOf()

    private val _photo = MutableStateFlow<List<PhotoUi>>(photoList)
    val photo: StateFlow<List<PhotoUi>> = _photo

//    var citiesUi: List<CityUi> by mutableStateOf(listOf())
//        private set

    init {
        cities()
        currencies()
        operations()
        propertyTypes()
        units()
    }

    private fun units() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = unitRepository.units()) {
                is Result.Unauthorized -> {
                    _units.value = State.Unauthorized
                }
                is Result.Success -> {
                    _units.value = State.Success(
                        response.data.map {
                            UnitUi(
                                it.id ?: 0,
                                it.unit ?: ""
                            )
                        }
                    )
                }
                is Result.Error -> {
                    _units.value = State.Error(response.error)
                }
            }
        }
    }

    private fun propertyTypes() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = propertyTypeRepository.propertyTypes()) {
                is Result.Unauthorized -> {
                    _propertyTypes.value = State.Unauthorized
                }
                is Result.Success -> {
                    _propertyTypes.value = State.Success(
                        response.data.map {
                            PropertyTypeUi(
                                it.id ?: 0,
                                it.type ?: ""
                            )
                        }
                    )
                }
                is Result.Error -> {
                    _propertyTypes.value = State.Error(response.error)
                }
            }
        }
    }

    private fun operations() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = operationRepository.operations()) {
                is Result.Unauthorized -> {
                    _operations.value = State.Unauthorized
                }
                is Result.Success -> {
                    _operations.value = State.Success(
                        response.data.map {
                            OperationUi(
                                it.id ?: 0,
                                it.operation ?: ""
                            )
                        }
                    )
                }
                is Result.Error -> {
                    _operations.value = State.Error(response.error)
                }
            }
        }
    }

    private fun currencies() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = currencyRepository.currencies()) {
                is Result.Unauthorized -> {
                    _currencies.value = State.Unauthorized
                }
                is Result.Success -> {
                    _currencies.value = State.Success(
                        response.data.map {
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
                is Result.Error -> {
                    _currencies.value = State.Error(response.error)
                }
            }
        }
    }

    private fun cities() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = cityRepository.cities()) {
                is Result.Unauthorized -> {
                    _cities.value = State.Unauthorized
                }
                is Result.Success -> {
                    _cities.value = State.Success(
                        response.data.map {
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
                        }
                    )
                }
                is Result.Error -> {
                    _cities.value = State.Error(response.error)
                }
            }
        }
    }

    fun photoUi(cursor: Cursor, filePathColumn: Array<String>) {
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            photoList.add(PhotoUi(cursor.getString(cursor.getColumnIndex(filePathColumn[0]))))
            cursor.moveToNext()
        }
        cursor.close()
    }

    fun photoUi(photoUi: PhotoUi) {
        photoList.remove(photoUi)
    }

    fun save(newPropertyUi: NewPropertyUi) {
        viewModelScope.launch(Dispatchers.IO) {
            _properties.value = State.Loading
            when(val response = propertyRepository.property(
                PropertyRequest(
                    newPropertyUi.title,
                    newPropertyUi.description,
                    newPropertyUi.floorPlan,
                    PropertyType(
                        newPropertyUi.propertyType?.id,
                        newPropertyUi.propertyType?.propertyType
                    ),
                    Operation(
                        newPropertyUi.operation?.id,
                        newPropertyUi.operation?.operation
                    ),
                    Attribute(
                        newPropertyUi.price,
                        newPropertyUi.area,
                        Currency(
                            newPropertyUi.currency?.id,
                            newPropertyUi.currency?.currency,
                            newPropertyUi.currency?.symbol,
                            newPropertyUi.currency?.code,
                            newPropertyUi.currency?.decimalMark
                        ),
                        Unit(
                            newPropertyUi.unit?.id,
                            newPropertyUi.unit?.unit
                        ),
                    ),
                    Address(
                        newPropertyUi.address,
                        City(
                            newPropertyUi.city?.id,
                            newPropertyUi.city?.city,
                            newPropertyUi.city?.zipCode,
                            Country(
                                newPropertyUi.city?.countryUi?.id,
                                newPropertyUi.city?.countryUi?.country,
                                newPropertyUi.city?.countryUi?.countryCode
                            )
                        ),
                        Country(
                            newPropertyUi.city?.countryUi?.id,
                            newPropertyUi.city?.countryUi?.country,
                            newPropertyUi.city?.countryUi?.countryCode
                        )
                    ),
                    Location(
                        newPropertyUi.location?.longitude ?: 0.0,
                        newPropertyUi.location?.latitude ?: 0.0
                    )
                )
            )) {
                is Result.Error -> _properties.value = State.Error(response.error)
                is Result.Success -> _properties.value = State.Success(response.data)
                is Result.Unauthorized -> _properties.value = State.Unauthorized
            }
        }
    }
}