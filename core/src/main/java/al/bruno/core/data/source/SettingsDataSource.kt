package al.bruno.core.data.source

import kotlinx.coroutines.flow.Flow

interface SettingsDataSource {
    suspend fun consent(): Flow<Boolean?>
    suspend fun consent(consent: Boolean)
}