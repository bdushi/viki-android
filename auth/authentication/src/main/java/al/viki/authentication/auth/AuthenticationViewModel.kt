package al.viki.authentication.auth

import al.bruno.core.Result
import al.bruno.core.State
import al.viki.core.AuthRepository
import al.viki.core.model.request.AuthRequest
import al.viki.core.model.response.AuthResponse
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _authentication = MutableStateFlow<State<AuthResponse>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val authentication: StateFlow<State<AuthResponse>>
        get() = _authentication

    fun auth(authRequest: AuthRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            _authentication.value = State.Loading
            when (val response = authRepository.auth(authRequest)) {
                is Result.Success -> _authentication.value = State.Success(response.data)
                is Result.Error -> _authentication.value = State.Error(response.error)
            }
        }
    }
}