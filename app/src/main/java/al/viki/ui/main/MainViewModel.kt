package al.viki.ui.main

import al.bruno.core.Result
import al.bruno.core.interceptor.AuthorizationInterceptor
import al.bruno.core.interceptor.TokenState
import al.viki.core.AuthRepository
import al.viki.core.UserRepository
import al.viki.core.di.UserProvider
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val authorizationInterceptor: AuthorizationInterceptor,
    private val userRepository: UserRepository,
    private val userProvider: UserProvider
) : ViewModel() {
    fun clear() {
        viewModelScope.launch {
            authRepository.clear()
        }
    }

    suspend fun token() = authRepository
        .token()
        .flatMapMerge {
            Log.d("TAG", "MainViewModel -> $it")
            if(it != null) {
                authorizationInterceptor.token = it
                userRepository.user().map { user ->
                    when (user) {
                        is Result.Error -> false
                        is Result.Success -> {
                            userProvider.user = user.data
                            true
                        }
                    }
                }
            } else {
                flowOf(false)
            }
        }
        .distinctUntilChanged()
        .combine(authorizationInterceptor.tokenState) { userRetrieved, tokenState ->
            tokenState != TokenState.ExpiredToken && userRetrieved
        }
        .stateIn(
            viewModelScope + Dispatchers.IO
        )
}