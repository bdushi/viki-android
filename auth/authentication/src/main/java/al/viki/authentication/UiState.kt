package al.viki.authentication

/**
 * SateFlow Generic Response Class which
 * Represents different states for the screens
 */
sealed class UiState<out T> {
    object Unauthorized : UiState<Nothing>()
    object Success: UiState<Nothing>()
    data class Error(val error: String?): UiState<Nothing>()
}