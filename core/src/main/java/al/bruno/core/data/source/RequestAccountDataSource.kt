package al.bruno.core.data.source

import al.bruno.core.data.source.model.Authority
import al.bruno.core.data.source.model.request.RequestAccount
import okhttp3.ResponseBody
import retrofit2.Response

interface RequestAccountDataSource {
    suspend fun requestAccount(
        requestAccount: RequestAccount
    ) : Response<ResponseBody>
}