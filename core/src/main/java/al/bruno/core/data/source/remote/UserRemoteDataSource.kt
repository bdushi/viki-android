package al.bruno.core.data.source.remote

import al.bruno.core.data.source.UserDataSource
import al.bruno.core.data.source.remote.service.UserService
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val userService: UserService): UserDataSource {
    override suspend fun user() = userService.user()
}