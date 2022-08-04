package al.viki.ui.main

import al.viki.core.AuthRepository
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val authRepository: AuthRepository) : ViewModel() {
    fun clear() {
        viewModelScope.launch {
            authRepository.clear()
        }
    }

    suspend fun token(): Flow<Preferences> {
        return authRepository.token()
    }
}