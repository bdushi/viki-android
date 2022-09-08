package al.bruno.core.di

import al.viki.UserPreferencesSerializer
import al.viki.common.VIKI_DATA_STORE_PREFERENCES
import al.viki.common.VIKI_PREFERENCES
import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.codelab.android.datastore.User
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
    fun providesDataStore(@ApplicationContext app: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            app.preferencesDataStoreFile(VIKI_PREFERENCES)
        }
    }

    @Singleton
    @Provides
    fun userPreferencesStore(@ApplicationContext app: Context): DataStore<User> {
        return DataStoreFactory.create(
            serializer = UserPreferencesSerializer(),
            produceFile = { app.dataStoreFile(VIKI_DATA_STORE_PREFERENCES) },
            corruptionHandler = null,
            migrations = listOf(),
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        )
    }
}