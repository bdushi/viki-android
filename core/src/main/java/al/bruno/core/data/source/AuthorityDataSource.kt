package al.bruno.core.data.source

import al.bruno.core.data.source.model.Authority
import retrofit2.Response

interface AuthorityDataSource {
    suspend fun authorities() : Response<List<Authority>>
}