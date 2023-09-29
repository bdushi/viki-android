package al.bruno.core.data.source.local

import al.bruno.common.CONSENT
import al.bruno.core.data.source.SettingsDataSource
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsLocalDataSource @Inject constructor(private val dataStore: DataStore<Preferences>) : SettingsDataSource {
    override suspend fun consent(): Flow<Boolean?> {
        return dataStore.data.map {
            it[booleanPreferencesKey(CONSENT)]
        }
    }

    override suspend fun consent(consent: Boolean) {
        dataStore.edit {
            it[booleanPreferencesKey(CONSENT)] = consent
        }
    }
}