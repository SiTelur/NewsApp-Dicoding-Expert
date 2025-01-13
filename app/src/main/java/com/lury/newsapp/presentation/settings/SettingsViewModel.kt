package com.lury.newsapp.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.lury.newsapp.core.domain.usecase.settings.SettingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val useCase: SettingsUseCase) : ViewModel() {
    val isDarkMode = useCase.getMode().asLiveData()

    fun saveSettings(value: Boolean) {
        viewModelScope.launch {
            useCase.saveMode(value)
        }
    }
}