package com.lury.newsapp.core.domain.usecase.settings

import com.lury.newsapp.core.domain.repository.settings.ISettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsInteractor @Inject constructor(private val repository: ISettingsRepository) :
    SettingsUseCase {
    override fun getMode(): Flow<Boolean> {
        return repository.getMode()
    }

    override suspend fun saveMode(value: Boolean) {
        repository.saveMode(value)
    }
}