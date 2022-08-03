package al.viki.authentication.register

import al.bruno.core.State
import al.viki.core.response.model.AuthResponse
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegisterViewModel : ViewModel() {

    val username = MutableStateFlow<String?>(null)
    val email = MutableStateFlow<String?>(null)
    val firstName = MutableStateFlow<String?>(null)
    val lastName = MutableStateFlow<String?>(null)
    val address = MutableStateFlow<String?>(null)
    val phone = MutableStateFlow<String?>(null)

    // Backing property to avoid state updates from other classes
    private val _register = MutableStateFlow<State<AuthResponse>?>(null)

    // The UI collects from this StateFlow to get its state updates
    val register: StateFlow<State<AuthResponse>?> = _register

    fun register() {

    }
}