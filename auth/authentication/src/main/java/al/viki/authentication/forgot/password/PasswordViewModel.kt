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

    private val _reset = MutableStateFlow<State<Boolean>>(State.Success(false))
    val reset: StateFlow<State<Boolean>>
        get() = _reset

    private val _validate = MutableStateFlow<State<String?>>(State.Success(null))
    val validate: StateFlow<State<String?>>
        get() = _validate

    private val _change = MutableStateFlow<State<Boolean>>(State.Success(null))
    val change: StateFlow<State<Boolean>>
        get() = _change

    fun resetPassword(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _reset.value = State.Loading
            when(val response = tokenRepository.resetPassword(email = email)) {
                is Result.Error -> _reset.value = State.Error(response.error)
                is Result.Success -> _reset.value = State.Success(response.data)
            }
        }
    }

    fun validateToken(token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _validate.value = State.Loading
            when(val response = tokenRepository.validateToken(token = token)) {
                is Result.Error -> _validate.value = State.Error(response.error)
                is Result.Success -> _validate.value = State.Success(response.data.accessToken)
            }
        }
    }

    fun changePassword(newPassword: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _change.value = State.Loading
            when(val response = authRepository.changePassword(newPassword = newPassword)) {
                is Result.Error -> _change.value = State.Error(response.error)
                is Result.Success -> _change.value = State.Success(response.data)
            }
        }
    }

    fun newPassword(newPassword: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _change.value = State.Loading
            when(val response = authRepository.newPassword(password = newPassword)) {
                is Result.Error -> _change.value = State.Error(response.error)
                is Result.Success -> _change.value = State.Success(response.data)
            }
        }
    }
}