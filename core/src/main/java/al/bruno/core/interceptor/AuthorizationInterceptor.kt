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
    private var session: (() -> Unit)? = null
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder: Request.Builder = chain.request().newBuilder()
        token?.let {
            requestBuilder.addHeader("Authorization", " Bearer $it")
        }
        val mainResponse: Response = chain.proceed(requestBuilder.build())
        if (mainResponse.code == 401 || mainResponse.code == 403) {
            session?.invoke()
        }
        return mainResponse
    }
    fun setOnSessionListen(session: () -> Unit) {
        this.session = session
    }
}