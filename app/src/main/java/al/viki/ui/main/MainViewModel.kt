package al.viki.ui.main

import al.bruno.analytics.AnalyticsServiceProviders
import al.bruno.analytics.events.APP_BUILD_TYPE
import al.bruno.analytics.events.APP_PACKAGE_NAME
import al.bruno.analytics.events.APP_VERSION_NAME
import al.bruno.core.Result
import al.bruno.core.interceptor.AuthorizationInterceptor
import al.viki.BuildConfig
import al.viki.core.AuthRepository
import al.viki.core.UserRepository
import al.viki.core.di.UserProvider
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
    private val userProvider: UserProvider,
    private val analyticsServiceProviders: AnalyticsServiceProviders
) : ViewModel() {

    init {
        logDefaultEventParameters()
    }

    fun clear() {
        viewModelScope.launch {
            authRepository.clear()
        }
    }

    suspend fun token() = authRepository
        .token()
        .flatMapMerge {
            if (it != null) {
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
        .stateIn(
            viewModelScope + Dispatchers.IO
        )

    private fun logDefaultEventParameters() {
        analyticsServiceProviders
            .setDefaultEventParameters(
                Pair(APP_PACKAGE_NAME, BuildConfig.APPLICATION_ID),
                Pair(APP_VERSION_NAME, BuildConfig.VERSION_NAME),
                Pair(APP_BUILD_TYPE, BuildConfig.BUILD_TYPE),
            )
    }
}