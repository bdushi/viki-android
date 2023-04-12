package al.viki.core.remote.service

import al.viki.core.model.User
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("/api/users/user")
    suspend fun user() : Response<User>
}