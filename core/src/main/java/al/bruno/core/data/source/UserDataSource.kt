package al.bruno.core.data.source

import al.bruno.core.data.source.model.User
import retrofit2.Response

interface UserDataSource {
    suspend fun user() : Response<User>
}