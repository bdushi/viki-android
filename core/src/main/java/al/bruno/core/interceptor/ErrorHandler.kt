package al.bruno.core.interceptor

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import al.viki.common.Error

class ErrorHandler constructor(private val retrofit: Retrofit) {
    fun customError(response: Response<*>): Error {
        val converter: Converter<ResponseBody, Error> = retrofit.responseBodyConverter(Error::class.java, arrayOfNulls(0))
        return try {
            response.errorBody()?.let {
                converter.convert(it)
            } ?: run {
                Error(400, "Error Body is Null")
            }
        } catch (e: Exception) {
            Error(400, e.message)
        }
    }
}