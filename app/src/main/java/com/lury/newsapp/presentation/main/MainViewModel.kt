package com.lury.newsapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.lury.newsapp.core.domain.usecase.settings.SettingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(settingsUseCase: SettingsUseCase) :
    ViewModel() {
    val isDarkMode = settingsUseCase.getMode().asLiveData()
}