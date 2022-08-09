package al.viki.authentication.register

import al.bruno.core.Result
import al.bruno.core.State
import al.viki.core.RegistrationRepository
import al.viki.core.model.User
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registrationRepository: RegistrationRepository) :
    ViewModel() {

    val photo = MutableStateFlow<Uri?>(null)
    val username = MutableStateFlow("")
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
    val reTypePassword = MutableStateFlow("")
    val firstName = MutableStateFlow("")
    val lastName = MutableStateFlow("")
    val address = MutableStateFlow("")
    val phone = MutableStateFlow("")

    // Backing property to avoid state updates from other classes
    private val _register = MutableStateFlow<State<User>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val register: StateFlow<State<User>> = _register

    fun register(authority: Long) {
        _register.value = State.Loading
        viewModelScope.launch {
            when (val response = registrationRepository.register(
                User(
                    username = username.value,
                    email = email.value,
                    firstName = firstName.value,
                    lastName = lastName.value,
                    password = password.value,
                    phone = phone.value,
                    address = address.value,
                    authorities = listOf(authority)
                )
            )) {
                is Result.Error -> {
                    _register.value = State.Error(response.error)
                }
                is Result.Success -> {
                    _register.value = State.Success(response.data)
                }
                is Result.Unauthorized -> {
                    _register.value = State.Unauthorized
                }
            }
        }
    }

    /**
     *
     * https://developer.android.com/training/data-storage/shared/media
     *
     * content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F13/ORIGINAL/NONE/13139981
     *
     * /storage/emulated/0/DCIM/Camera/IMG_20220805_165739.jpg
     *
     * https://developer.android.com/training/data-storage/use-cases
     *
     */
    fun setPhotoUi(uri: Uri?) {
        photo.value = uri
    }
}