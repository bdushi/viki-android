package al.viki.core

import al.bruno.core.asResponse
import al.viki.core.remote.UserRemoteDataSource
import javax.inject.Inject

class UserRepository @Inject constructor(private val userRemoteDataSource: UserRemoteDataSource) {
    suspend fun user() = userRemoteDataSource.user().asResponse()
}