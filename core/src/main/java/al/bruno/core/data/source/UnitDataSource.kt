package al.bruno.core.data.source

import al.bruno.core.data.source.model.Unit
import retrofit2.Response

interface UnitDataSource {
    suspend fun units() : Response<List<Unit>>
}