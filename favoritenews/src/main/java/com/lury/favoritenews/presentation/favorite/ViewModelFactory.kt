package com.lury.favoritenews.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lury.newsapp.core.domain.usecase.favoritenews.FavoriteNewsUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val favoriteNewsUseCase: FavoriteNewsUseCase) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(favoriteNewsUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}