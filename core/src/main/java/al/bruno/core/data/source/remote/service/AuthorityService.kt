package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.Authority
import retrofit2.Response
import retrofit2.http.GET

interface AuthorityService {
    @GET("/api/authorities")
    suspend fun authorities() : Response<List<Authority>>
}