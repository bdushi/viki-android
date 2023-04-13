package al.viki.authentication.auth

import al.bruno.core.Result
import al.bruno.core.State
import al.viki.core.AuthRepository
import al.viki.core.UserRepository
import al.viki.core.di.UserProvider
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
) :
    ViewModel() {
    val username = MutableStateFlow<String?>(null)
    val password = MutableStateFlow<String?>(null)

    // Backing property to avoid state updates from other classes
    private val _authentication = MutableStateFlow<State<AuthResponse>>(State.Success(null))

    // The UI collects from this StateFlow to get its state updates
    val authentication: StateFlow<State<AuthResponse>> = _authentication

    fun auth() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = authRepository.auth(
                AuthRequest(
                    username.value,
                    password.value
                )
            )) {
                is Result.Success -> _authentication.value = State.Success(response.data)
                is Result.Error -> _authentication.value = State.Error(response.error)
            }
        }

    }
}