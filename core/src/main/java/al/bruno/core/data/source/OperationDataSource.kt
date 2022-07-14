package al.bruno.core.data.source

import al.bruno.core.data.source.model.Operation
import retrofit2.Response

interface OperationDataSource {
    suspend fun operations() : Response<List<Operation>>
}