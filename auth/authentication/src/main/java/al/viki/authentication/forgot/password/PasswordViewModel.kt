package al.viki.authentication.forgot.password

import al.bruno.core.Result
import al.bruno.core.State
import al.viki.core.AuthRepository
import al.viki.core.TokeRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasswordViewModel @Inject constructor(
    private val tokenRepository: TokeRepository,
    private val authRepository: AuthRepository
    ): ViewModel() {

    val email = MutableStateFlow("")

    val newPassword = MutableStateFlow("")
    val retypeNewPassword = MutableStateFlow("")


    // Backing property to avoid state updates from other classes
    private val _reset = MutableStateFlow<State<Boolean>>(State.Success(false))

    // The UI collects from this StateFlow to get its state updates
    val reset: StateFlow<State<Boolean>> = _reset

    // Backing property to avoid state updates from other classes
    private val _validate = MutableStateFlow<State<String?>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val validate: StateFlow<State<String?>> = _validate

    // Backing property to avoid state updates from other classes
    private val _change = MutableStateFlow<State<Boolean>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val change: StateFlow<State<Boolean>> = _change

    fun resetPassword() {
        viewModelScope.launch(Dispatchers.IO) {
            _reset.value = State.Loading
            when(val response = tokenRepository.resetPassword(email = email.value)) {
                is Result.Error -> _reset.value = State.Error(response.error)
                is Result.Success -> _reset.value = State.Success(response.data)
                is Result.Unauthorized -> _reset.value = State.Unauthorized
            }
        }
    }

    fun validateToken(token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _validate.value = State.Loading
            when(val response = tokenRepository.validateToken(token = token)) {
                is Result.Error -> _validate.value = State.Error(response.error)
                is Result.Success -> _validate.value = State.Success(response.data.accessToken)
                is Result.Unauthorized -> _validate.value = State.Unauthorized
            }
        }
    }

    fun changePassword() {
        viewModelScope.launch(Dispatchers.IO) {
            _change.value = State.Loading
            when(val response = authRepository.changePassword(newPassword = newPassword.value)) {
                is Result.Error -> _change.value = State.Error(response.error)
                is Result.Success -> _change.value = State.Success(response.data)
                is Result.Unauthorized -> _change.value = State.Unauthorized
            }
        }
    }

    fun newPassword() {
        viewModelScope.launch(Dispatchers.IO) {
            _change.value = State.Loading
            when(val response = authRepository.newPassword(password = newPassword.value)) {
                is Result.Error -> _change.value = State.Error(response.error)
                is Result.Success -> _change.value = State.Success(response.data)
                is Result.Unauthorized -> _change.value = State.Unauthorized
            }
        }
    }
}