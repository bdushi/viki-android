package al.bruno.core.data.source.remote

import al.bruno.core.data.source.RequestAccountDataSource
import al.bruno.core.data.source.model.Authority
import al.bruno.core.data.source.model.request.RequestAccount
import al.bruno.core.data.source.remote.service.RequestAccountService
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class RequestAccountRemoteDataSource @Inject constructor(private val requestAccountService: RequestAccountService): RequestAccountDataSource {
    override suspend fun requestAccount(
        requestAccount: RequestAccount
    ): Response<ResponseBody> {
        return requestAccountService.requestAccount(requestAccount)
    }
}