package al.viki.ui.property

import al.bruno.analytics.AnalyticsServiceProviders
import al.bruno.analytics.events.*
import al.bruno.core.Result
import al.bruno.core.State
import al.bruno.core.data.source.*
import al.bruno.core.data.source.model.*
import al.bruno.core.data.source.model.Operation
import al.bruno.core.data.source.model.request.PropertyRequest
import al.viki.core.di.UserProvider
import al.viki.model.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class PropertyViewModel @Inject constructor(
    private val cityRepository: CityRepository,
    private val currencyRepository: CurrencyRepository,
    private val operationRepository: OperationRepository,
    private val propertyTypeRepository: PropertyTypeRepository,
    private val unitRepository: UnitRepository,
    private val propertyRepository: PropertyRepository,
    private val workManager: WorkManager,
    private val analyticsServiceProviders: AnalyticsServiceProviders,
    private val userProvider: UserProvider
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

    val saveProperties = MutableStateFlow(NewPropertyUi())

    private val photoList: MutableList<GalleryUi> = mutableListOf()

    private val _photo = MutableStateFlow<List<GalleryUi>>(photoList)
    val photo: StateFlow<List<GalleryUi>> = _photo

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

    fun addImage(galleryUi: GalleryUi) {
        photoList.add(galleryUi)
        _photo.value = photoList
    }

    fun removeImage(galleryUi: GalleryUi) {
        photoList.remove(galleryUi)
        _photo.value = photoList
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    val properties = saveProperties.flatMapLatest { newProperty ->
        propertyRepository.property(
            save(newProperty)
        ).map {
            when (it) {
                is Result.Error -> State.Error(it.error)
                is Result.Success -> {
                    analyticsServiceProviders
                        .logEvent(
                            CREATE_NEW_PROPERTY_EVENT,
                            Pair(USERNAME, userProvider.user?.username),
                            Pair(PROPERTY_ID, it.data.toString()),
                            Pair(FLOOR_PLAN, newProperty.floorPlan),
                            Pair(OPERATION, newProperty.operation),
                            Pair(PROPERTY_TYPE, newProperty.propertyType),
                            Pair(CURRENCY, newProperty.currency),
                            Pair(UNIT, newProperty.unit),
                            Pair(AREA, newProperty.area),
                            Pair(PRICE, newProperty.price),
                            Pair(LONGITUDE, newProperty.location?.longitude),
                            Pair(LATITUDE, newProperty.location?.latitude)
                        )
                    analyticsServiceProviders
                        .setUserProperty(USERNAME, "skashuta")
                    workManager
                        .enqueue(
                            OneTimeWorkRequestBuilder<UploadWorker>()
                                .setInputData(
                                    Data
                                        .Builder()
                                        .putInt("ID", it.data)
                                        .putStringArray(
                                            "PHOTO_UI",
                                            photo.value.map { photoUi ->
                                                photoUi.uri.toString()
                                            }.toTypedArray()
                                        )
                                        .build()
                                )
                                .build()
                        )
                    State.Success(it.data)
                }
            }
        }.stateIn(
            viewModelScope + Dispatchers.IO,
            SharingStarted.WhileSubscribed(2_000),
            State.Loading
        )
    }

    private fun save(newPropertyUi: NewPropertyUi) = PropertyRequest(
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
            "TODO-This going to be defined in the future",
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
}