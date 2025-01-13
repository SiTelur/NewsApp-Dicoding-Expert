package com.lury.newsapp.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.lury.newsapp.core.domain.usecase.news.NewsUseCase
import com.lury.newsapp.presentation.model.NewsUi
import com.lury.newsapp.presentation.model.toNews
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val useCase: NewsUseCase) : ViewModel() {
    fun isNewsFavorite(newsUi: NewsUi) = useCase.isNewsFavorite(newsUi.toNews()).asLiveData()

    fun saveFavoriteNews(newsUi: NewsUi) {
        viewModelScope.launch {
            useCase.saveFavoriteNews(newsUi.toNews())
        }
    }

    fun deleteFavoriteNews(newsUi: NewsUi) {
        viewModelScope.launch {
            useCase.deleteFavoriteNews(newsUi.toNews())
        }
    }
}