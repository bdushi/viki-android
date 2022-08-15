package al.bruno.core.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthorizationInterceptor @Inject constructor() : Interceptor {
    var token: String? = null
    override fun intercept(chain: Interceptor.Chain): Response {

        val builder = chain.request().newBuilder()
        token?.let {
            builder.addHeader("Authorization", " Bearer $it")
        }
        return chain.proceed(builder.build())
    }
}