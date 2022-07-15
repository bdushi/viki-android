package al.bruno.core

/**
 * SateFlow Generic Response Class which
 * Represents different states for the screens
 */
sealed class State<out T> {
    object Unauthorized : State<Nothing>()
    object Loading : State<Nothing>()
    data class Success<out T>(val t: T?): State<T>()
    data class Error(val error: String?): State<Nothing>()
}