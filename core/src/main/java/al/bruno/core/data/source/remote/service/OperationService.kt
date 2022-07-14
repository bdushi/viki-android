package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.Operation
import retrofit2.Response
import retrofit2.http.GET

interface OperationService {
    @GET("api/operations")
    suspend fun operations() : Response<List<Operation>>
}