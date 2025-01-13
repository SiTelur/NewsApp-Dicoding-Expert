package com.lury.newsapp.core.data.repository.favoritenews

import com.lury.newsapp.core.data.datasource.local.LocalDataSource
import com.lury.newsapp.core.data.model.DataMapper
import com.lury.newsapp.core.domain.model.favoritenews.FavoriteNews
import com.lury.newsapp.core.domain.repository.favoritenews.IFavoriteNewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteNewsRepository
@Inject constructor(private val localDataSource: LocalDataSource) : IFavoriteNewsRepository {
    override fun getAllFavoriteNews(): Flow<List<FavoriteNews>> {
        return localDataSource.getFavoriteNews()
            .map { newsEntity ->
                newsEntity.map { DataMapper.entityToNewsFavorite(it) }
            }
    }
}