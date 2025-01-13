package com.lury.newsapp.core.domain.usecase.news

import com.lury.newsapp.core.data.model.response.Resource
import com.lury.newsapp.core.domain.model.news.News
import kotlinx.coroutines.flow.Flow

interface NewsUseCase {
    fun getNewsHeadline() : Flow<Resource<List<News>>>
    suspend fun saveFavoriteNews(news: News)
    fun isNewsFavorite(news: News) : Flow<Boolean>
    suspend fun deleteFavoriteNews(news: News)
}