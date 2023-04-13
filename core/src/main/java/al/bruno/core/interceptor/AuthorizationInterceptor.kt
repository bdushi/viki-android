package al.bruno.core.interceptor

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
    private var tokenState: (() -> Unit)? = null

    @Throws(Exception::class)
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
            tokenState?.invoke()
        }
        return mainResponse
    }
    fun setOnSessionListen(tokenState: () -> Unit) {
        this.tokenState = tokenState
    }
}

sealed class TokenState {
    object ValidToken : TokenState()
    object ExpiredToken : TokenState()
}