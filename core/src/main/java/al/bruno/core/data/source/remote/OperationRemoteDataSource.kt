package al.bruno.core.data.source.remote

import al.bruno.core.data.source.OperationDataSource
import al.bruno.core.data.source.model.Operation
import al.bruno.core.data.source.remote.service.OperationService
import retrofit2.Response
import javax.inject.Inject

class OperationRemoteDataSource @Inject constructor(private val operationService: OperationService): OperationDataSource {
    override suspend fun operations(): Response<List<Operation>> {
        return operationService.operations()
    }
}