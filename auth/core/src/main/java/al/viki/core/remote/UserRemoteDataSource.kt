package al.viki.core.remote

import al.viki.core.UserDataSource
import al.viki.core.remote.service.UserService
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val userService: UserService): UserDataSource {
    override suspend fun user() = userService.user()
}