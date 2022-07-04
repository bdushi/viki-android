package al.bruno.core.interceptor

import al.bruno.foodies.interceptor.Session
import okhttp3.*

class AuthorizationInterceptor : Interceptor {
    private lateinit var session: Session
    override fun intercept(chain: Interceptor.Chain): Response {
        val mainResponse = chain.proceed(chain.request())
        if (!chain.request().url.encodedPath.contains("security/authenticate") &&
            !chain.request().url.encodedPath.contains("security/checkTokenStatus") &&
            mainResponse.code == 401) {
            session.invalidate()
        }
        return mainResponse
    }

    fun setSession(session: Session) {
        this.session = session
    }
}