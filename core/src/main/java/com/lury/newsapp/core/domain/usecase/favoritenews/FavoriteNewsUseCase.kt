package com.lury.newsapp.core.domain.usecase.favoritenews

import com.lury.newsapp.core.domain.model.favoritenews.FavoriteNews
import kotlinx.coroutines.flow.Flow

interface FavoriteNewsUseCase {
    fun getFavoriteNews() : Flow<List<FavoriteNews>>
}