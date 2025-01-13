package com.lury.newsapp.core.domain.usecase.settings

import kotlinx.coroutines.flow.Flow

interface SettingsUseCase {
    fun getMode() : Flow<Boolean>
    suspend fun saveMode(value : Boolean)
}