package al.bruno.core.data.source.remote

import al.bruno.core.data.source.UnitDataSource
import al.bruno.core.data.source.model.Unit
import al.bruno.core.data.source.remote.service.UnitService
import retrofit2.Response
import javax.inject.Inject

class UnitRemoteDataSource @Inject constructor(private val unitService: UnitService):
    UnitDataSource {
    override suspend fun units(): Response<List<Unit>> {
        return unitService.units()
    }
}