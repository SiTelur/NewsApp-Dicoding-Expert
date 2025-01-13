package com.lury.newsapp.core.domain.repository.settings

import kotlinx.coroutines.flow.Flow

interface ISettingsRepository {
    fun getMode() : Flow<Boolean>
    suspend fun saveMode(value : Boolean)
}