package al.viki.core.local

import al.viki.core.AuthDataSource
import al.viki.common.TOKEN
import al.viki.core.request.model.AuthRequest
import al.viki.core.response.model.AuthResponse
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class AuthLocalDataSource @Inject constructor(private val dataStore: DataStore<Preferences>) :
    AuthDataSource {
    override suspend fun auth(authRequest: AuthRequest): Response<AuthResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun verification(): Response<ResponseBody> {
        TODO("Not yet implemented")
    }

    override fun token(): Flow<String?> {
        return dataStore.data.map {
            it[stringPreferencesKey(TOKEN)]
        }
    }

    override suspend fun token(token: String) {
        dataStore.edit {
            it[stringPreferencesKey(TOKEN)] = token
        }
    }

    override suspend fun clear() {
        dataStore.edit {
            it.clear()
        }
    }
}