package com.lury.newsapp.core.data.datasource.local.preference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.lury.newsapp.core.data.model.preferences.DataPreferences
import com.lury.newsapp.core.util.SettingsPreferencesSerializer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by dataStore(
    "settings-preferences",
    serializer = SettingsPreferencesSerializer
)

class SettingsPreference(private val dataStore: DataStore<DataPreferences>) {
    suspend fun saveSettings(value: Boolean) {
        dataStore.updateData {
            DataPreferences(value)
        }
    }

    fun getSettings(): Flow<Boolean> = dataStore.data.map { settingsPreference ->
        settingsPreference.isDark ?: false
    }

}