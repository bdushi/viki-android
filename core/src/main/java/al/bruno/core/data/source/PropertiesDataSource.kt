package al.bruno.core.data.source

import al.bruno.core.data.source.model.response.PageResponse
import al.bruno.core.data.source.model.response.PropertiesResponse
import retrofit2.Response

interface PropertiesDataSource {
    suspend fun properties(page: Int, size: Int, query: Map<String, String>) : Response<PageResponse<List<PropertiesResponse>>>

    suspend fun properties(query: Map<String, String>): Response<List<PropertiesResponse>>

    suspend fun properties(id: Long) : Response<PropertiesResponse>
}