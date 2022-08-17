package al.bruno.core.interceptor

import okhttp3.*
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RefreshTokenInterceptor @Inject constructor() : Interceptor {
    private var session: (() -> Unit)? = null
    override fun intercept(chain: Interceptor.Chain): Response {
        val mainResponse: Response = chain.proceed(chain.request())
        if (mainResponse.code == 401) {
            session?.invoke()
        }
        return mainResponse
    }

    fun setOnSessionListen(session: () -> Unit) {
        this.session = session
    }
}