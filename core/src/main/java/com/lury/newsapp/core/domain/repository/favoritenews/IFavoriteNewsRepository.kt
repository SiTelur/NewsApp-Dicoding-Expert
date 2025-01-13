package com.lury.newsapp.core.domain.repository.favoritenews

import com.lury.newsapp.core.domain.model.favoritenews.FavoriteNews
import kotlinx.coroutines.flow.Flow

interface IFavoriteNewsRepository {
    fun getAllFavoriteNews() : Flow<List<FavoriteNews>>
}