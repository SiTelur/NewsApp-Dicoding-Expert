package com.lury.newsapp.core.domain.usecase.news

import com.lury.newsapp.core.data.model.response.Resource
import com.lury.newsapp.core.domain.model.news.News
import com.lury.newsapp.core.domain.repository.news.INewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsInteractor @Inject constructor(private val newsRepository: INewsRepository): NewsUseCase {
    override fun getNewsHeadline(): Flow<Resource<List<News>>> = newsRepository.getNews()
    override suspend fun saveFavoriteNews(news: News) = newsRepository.saveFavoriteNews(news)
    override fun isNewsFavorite(news: News): Flow<Boolean> = newsRepository.isNewsFavorite(news)
    override suspend fun deleteFavoriteNews(news: News) = newsRepository.deleteFavoriteNews(news)

}