package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.model.Operation
import al.bruno.core.data.source.remote.OperationRemoteDataSource
import javax.inject.Inject

class OperationRepository @Inject constructor(private val operationDataSource: OperationRemoteDataSource) {
    suspend fun operations() : Result<List<Operation>> {
        return try {
            val response = operationDataSource.operations()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.Success(body)
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }
}