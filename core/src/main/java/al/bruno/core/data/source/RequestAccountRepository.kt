package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.model.request.RequestAccount
import al.bruno.core.data.source.remote.RequestAccountRemoteDataSource
import al.bruno.core.error.ErrorHandler
import javax.inject.Inject

class RequestAccountRepository @Inject constructor(
    private val requestAccountDataSource: RequestAccountRemoteDataSource,
    private val errorHandler: ErrorHandler
    ) {
    suspend fun requestAccount(
        requestAccount: RequestAccount
    ) : Result<Boolean> {
        return try {
            val response = requestAccountDataSource.requestAccount(requestAccount)
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.Success(response.isSuccessful)
            } else {
                errorHandler.customError(response)
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }
}