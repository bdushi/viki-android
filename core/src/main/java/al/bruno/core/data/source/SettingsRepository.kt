package al.bruno.core.data.source

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepository @Inject constructor(private val settingsDataSource: SettingsDataSource) {
    suspend fun consent(): Flow<Boolean?> {
        return settingsDataSource.consent()
    }
    suspend fun consent(consent: Boolean) {
        settingsDataSource.consent(consent)
    }
}