package al.viki.authentication.register

import al.bruno.core.Result
import al.bruno.core.State
import al.viki.core.RegistrationRepository
import al.bruno.core.data.source.model.response.ValidationResponse
import al.viki.core.model.request.UserRegister
import al.viki.core.model.response.AuthResponse
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registrationRepository: RegistrationRepository) :
    ViewModel() {

    val photo = MutableStateFlow<Uri?>(null)

    private val _register = MutableStateFlow<State<AuthResponse>>(State.Success(null))
    val register: StateFlow<State<AuthResponse>>
        get() = _register

    private val _validate = MutableStateFlow<State<ValidationResponse>>(State.Success(null))
    val validate: StateFlow<State<ValidationResponse>>
        get() = _validate

    fun register(userRegister: UserRegister, token: String) {
        _register.value = State.Loading
        viewModelScope.launch {
            when (val response = registrationRepository.register(
                user = userRegister, token = token
            )) {
                is Result.Error -> {
                    _register.value = State.Error(response.error)
                }
                is Result.Success -> {
                    _register.value = State.Success(response.data)
                }
            }
        }
    }

    fun validateToken(token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _validate.value = State.Loading
            when (val response = registrationRepository.validateToken(token = token)) {
                is Result.Error -> {
                    _validate.value = State.Error(response.error)
                }
                is Result.Success -> {
                    _validate.value = State.Success(response.data)
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