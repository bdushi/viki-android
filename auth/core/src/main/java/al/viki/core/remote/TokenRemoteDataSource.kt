package al.viki.core.remote

import al.viki.core.TokenDataSource
import al.viki.core.remote.service.TokenService
import al.viki.core.model.response.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class TokenRemoteDataSource @Inject constructor(private val tokenService: TokenService) : TokenDataSource {
    override suspend fun resetPassword(email: String): Response<ResponseBody> {
        return tokenService.resetPassword(email)
    }

    override suspend fun validateToken(token: String): Response<AuthResponse> {
        return tokenService.validateToken(token)
    }
}