package al.bruno.core.di

import al.bruno.common.VIKI_PREFERENCES
import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CoreModule {
    @Singleton
    @Provides
    fun providesDataStore(@ApplicationContext app: Context) = PreferenceDataStoreFactory.create(
        corruptionHandler = null,
        migrations = listOf(),
        scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
        produceFile = { app.preferencesDataStoreFile(VIKI_PREFERENCES) }
    )


//    @Singleton
//    @Provides
//    fun userPreferencesStore(@ApplicationContext app: Context) = DataStoreFactory.create(
//        serializer = UserPreferencesSerializer(),
//        produceFile = { app.dataStoreFile(VIKI_DATA_STORE_PREFERENCES) },
//        corruptionHandler = null,
//        migrations = listOf(),
//        scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
//    )
}