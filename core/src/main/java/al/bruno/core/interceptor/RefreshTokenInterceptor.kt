package al.bruno.core.interceptor

import okhttp3.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RefreshTokenInterceptor @Inject constructor() : Interceptor {
    private var session: (() -> Unit)? = null
    override fun intercept(chain: Interceptor.Chain): Response {
        val mainResponse = chain.proceed(chain.request())
        if (!chain.request().url.encodedPath.contains("security/authenticate") &&
            !chain.request().url.encodedPath.contains("security/checkTokenStatus") &&
            mainResponse.code == 401) {
            session?.invoke()
        }
        return mainResponse
    }
    fun setSession(session: () -> Unit) {
        this.session = session
    }
}