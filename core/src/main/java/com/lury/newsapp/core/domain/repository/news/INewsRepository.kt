package com.lury.newsapp.core.domain.repository.news

import com.lury.newsapp.core.data.model.response.Resource
import com.lury.newsapp.core.domain.model.news.News
import kotlinx.coroutines.flow.Flow

interface INewsRepository {
    fun getNews() : Flow<Resource<List<News>>>
    suspend fun saveFavoriteNews(news: News)
    suspend fun deleteFavoriteNews(news: News)
    fun isNewsFavorite(news: News) : Flow<Boolean>
}