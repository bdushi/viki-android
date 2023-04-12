package al.viki.core

import al.viki.core.model.User
import retrofit2.Response

interface UserDataSource {
    suspend fun user() : Response<User>
}