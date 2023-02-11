package al.bruno.core.data.source.remote

import al.bruno.core.data.source.PropertiesDataSource
import al.bruno.core.data.source.model.response.PageResponse
import al.bruno.core.data.source.model.response.PropertiesResponse
import al.bruno.core.data.source.remote.service.PropertiesService
import retrofit2.Response
import javax.inject.Inject

class PropertiesRemoteDataSource @Inject constructor(private val propertiesService: PropertiesService): PropertiesDataSource {
    override suspend fun properties(
        page: Int,
        size: Int,
        query: Map<String, String>
    ): Response<PageResponse<List<PropertiesResponse>>> {
        return propertiesService.properties(page = page, size = size, query = query)
    }

    override suspend fun properties(id: Long): Response<PropertiesResponse> {
        return propertiesService.properties(id)
    }

    override suspend fun properties(
        query: Map<String, String>
    ): Response<List<PropertiesResponse>> {
        return propertiesService.properties(query = query)
    }
}