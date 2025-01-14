package com.lury.newsapp.core.domain.usecase.favoritenews

import com.lury.newsapp.core.domain.model.favoritenews.FavoriteNews
import com.lury.newsapp.core.domain.repository.favoritenews.IFavoriteNewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteNewsInteractor @Inject constructor(private val favoriteNewsRepository: IFavoriteNewsRepository) :
    FavoriteNewsUseCase {
    override fun getFavoriteNews(): Flow<List<FavoriteNews>> {
        return favoriteNewsRepository.getAllFavoriteNews()
    }

}