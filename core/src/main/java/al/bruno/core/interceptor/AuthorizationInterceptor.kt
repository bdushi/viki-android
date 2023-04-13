package al.bruno.core.interceptor

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * !chain.request().url.encodedPath.contains("security/authenticate")
 * chain.proceed(requestBuilder.build())
 * chain.proceed(chain.request())
 */

@Singleton
class AuthorizationInterceptor @Inject constructor() : Interceptor {
    var token: String? = null
    private val _tokenState = MutableStateFlow<TokenState>(TokenState.ValidToken)
    val tokenState: StateFlow<TokenState>
        get() = _tokenState

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder: Request.Builder = chain.request().newBuilder()
        token?.let {
            requestBuilder.addHeader("Authorization", " Bearer $it")
        }
        val mainResponse: Response = chain.proceed(requestBuilder.build())
        if (
            (mainResponse.code == 401 || mainResponse.code == 403)
            && !chain.request().url.encodedPath.contains("/login")
        ) {
            _tokenState.value = TokenState.ExpiredToken
        }
        return mainResponse
    }
}

sealed class TokenState {
    object ValidToken : TokenState()
    object ExpiredToken : TokenState()
}