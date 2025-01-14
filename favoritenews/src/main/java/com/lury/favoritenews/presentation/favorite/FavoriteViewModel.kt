package com.lury.favoritenews.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import com.lury.favoritenews.presentation.model.toFavoriteUi
import com.lury.newsapp.core.domain.usecase.favoritenews.FavoriteNewsUseCase


class FavoriteViewModel(useCase: FavoriteNewsUseCase) : ViewModel() {
    val getFavoriteName = useCase.getFavoriteNews().asLiveData().map { list-> list.map { it.toFavoriteUi() } }
}

