package al.viki.ui.main

import al.viki.common.ACCESS_TOKEN
import al.viki.core.AuthRepository
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    fun clear() {
        viewModelScope.launch {
            authRepository.clear()
        }
    }

    suspend fun token(): StateFlow<String?> {
        return authRepository.token().map {
            it[stringPreferencesKey(ACCESS_TOKEN)]
        }.stateIn(viewModelScope)
    }
}