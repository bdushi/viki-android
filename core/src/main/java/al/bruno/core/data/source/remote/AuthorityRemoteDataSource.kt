package al.bruno.core.data.source.remote

import al.bruno.core.data.source.AuthorityDataSource
import al.bruno.core.data.source.model.Authority
import al.bruno.core.data.source.remote.service.AuthorityService
import retrofit2.Response
import javax.inject.Inject

class AuthorityRemoteDataSource @Inject constructor(
    private val authorityService: AuthorityService
    ): AuthorityDataSource {
    override suspend fun authorities(): Response<List<Authority>> {
        return authorityService.authorities()
    }
}