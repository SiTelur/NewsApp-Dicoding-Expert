package com.lury.newsapp.core.data.repository.settings

import com.lury.newsapp.core.data.datasource.local.LocalDataSource
import com.lury.newsapp.core.domain.repository.settings.ISettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepository @Inject constructor(private val localDataSource: LocalDataSource) : ISettingsRepository {
    override fun getMode(): Flow<Boolean> = localDataSource.isDarkMode()

    override suspend fun saveMode(value: Boolean) = localDataSource.changeMode(value)
}