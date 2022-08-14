package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("/api/users/user")
    suspend fun user() : Response<User>
}