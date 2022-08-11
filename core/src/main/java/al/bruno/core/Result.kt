package al.bruno.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: String?) : Result<Nothing>()
    object Unauthorized : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
            is Unauthorized -> "Unauthorized"
        }
    }
}

/**
 *
 */
fun <T> Flow<T>.asResult(){
    map<T,Result<T>> {
        Result.Success(it)
    }.onStart {
        emit(Result.Unauthorized)
    }.catch { emit(Result.Error("")) }
}