package com.lury.newsapp.core.data.repository.news

import com.lury.newsapp.core.data.datasource.local.LocalDataSource
import com.lury.newsapp.core.data.datasource.remote.RemoteDataSource
import com.lury.newsapp.core.data.datasource.remote.retrofit.ApiResponse
import com.lury.newsapp.core.data.model.DataMapper
import com.lury.newsapp.core.data.model.response.Resource
import com.lury.newsapp.core.domain.model.news.News
import com.lury.newsapp.core.domain.repository.news.INewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : INewsRepository {
    override fun getNews(): Flow<Resource<List<News>>> = flow {
        emit(Resource.Loading())
        try {
            when (val data = remoteDataSource.getNewsHeadline().first()) {
                ApiResponse.Empty -> emit(Resource.Success(emptyList()))
                is ApiResponse.Error -> emit(Resource.Error(data.errorMessage))
                is ApiResponse.Success -> emit(Resource.Success(data.data.map { DataMapper.toNews(it) }))
                else -> emit(Resource.Error("Error unexpected"))
            }
        } catch (e: HttpException) {
            emit(Resource.Error(e.message()))
        }
    }

    override suspend fun saveFavoriteNews(news: News) {
        localDataSource.saveFavoriteNews(DataMapper.toEntity(news))
    }

    override suspend fun deleteFavoriteNews(news: News) {
        localDataSource.deleteFavoriteNews(DataMapper.toEntity(news))
    }

    override fun isNewsFavorite(news: News): Flow<Boolean> =
        localDataSource.isNewsExist(DataMapper.toEntity(news))


}