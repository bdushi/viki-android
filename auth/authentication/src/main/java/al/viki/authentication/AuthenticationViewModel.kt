package al.viki.authentication

import al.viki.core.AuthRepository
import al.viki.core.request.model.AuthRequest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() {
    val username = MutableStateFlow<String?>(null)
    val password = MutableStateFlow<String?>(null)

    // Backing property to avoid state updates from other classes
    private val _authentication = MutableStateFlow<UiState<Nothing>?>(null)
    // The UI collects from this StateFlow to get its state updates
    val authentication: StateFlow<UiState<Nothing>?> = _authentication

    private val _progress = MutableStateFlow(false)
    val progress: StateFlow<Boolean> = _progress

    fun auth() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val response = authRepository.auth(
                AuthRequest(
                    username.value,
                    password.value
                )
            )) {
                is al.bruno.core.Result.Loading -> {
                    _progress.value = true
                }
                is al.bruno.core.Result.Unauthorized -> {
                   _authentication.value = UiState.Unauthorized
                    _progress.value = false
                }
                is al.bruno.core.Result.Success -> {
                    _authentication.value = UiState.Success
                    _progress.value = false
                }
                is al.bruno.core.Result.Error -> {
                    _authentication.value = UiState.Error(response.error)
                    _progress.value = false
                }
            }
        }

    }
}