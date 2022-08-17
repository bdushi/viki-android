package al.viki.core.local

import al.viki.common.ACCESS_TOKEN
import al.viki.common.REFRESH_TOKEN
import al.viki.core.AuthDataSource
import al.viki.core.model.request.AuthRequest
import al.viki.core.model.response.AuthResponse
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(private val dataStore: DataStore<Preferences>) :
    AuthDataSource {
    override suspend fun auth(authRequest: AuthRequest): Response<AuthResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun token(): Flow<Preferences> {
        return dataStore.data
    }

    override suspend fun token(accessToken: String, refreshToken: String) {
        dataStore.edit {
            it[stringPreferencesKey(ACCESS_TOKEN)] = accessToken
            it[stringPreferencesKey(REFRESH_TOKEN)] = refreshToken
        }
    }

    override suspend fun clear() {
        dataStore.edit {
            it.clear()
        }
    }

    override suspend fun newPassword(password: String): Response<ResponseBody> {
        TODO("Not yet implemented")
    }

    override suspend fun changePassword(newPassword: String): Response<ResponseBody> {
        TODO("Not yet implemented")
    }
}