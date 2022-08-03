package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.request.RequestAccount
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestAccountService {
    @POST("/api/requestAccount")
    suspend fun requestAccount(@Body requestAccount: RequestAccount) : Response<ResponseBody>
}