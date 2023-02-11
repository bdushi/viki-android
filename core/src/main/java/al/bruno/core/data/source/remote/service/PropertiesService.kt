package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.response.PageResponse
import al.bruno.core.data.source.model.response.PropertiesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface PropertiesService {
    @GET("api/properties/page")
    suspend fun properties(@Query("page") page: Int, @Query("size") size: Int, @QueryMap query: Map<String, String>) : Response<PageResponse<List<PropertiesResponse>>>

    @GET("api/properties")
    suspend fun properties(@Query("id") id: Long) : Response<PropertiesResponse>

    @GET("api/properties/filter")
    suspend fun properties(@QueryMap query: Map<String, String>) : Response<List<PropertiesResponse>>

}