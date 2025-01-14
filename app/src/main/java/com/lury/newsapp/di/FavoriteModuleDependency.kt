package com.lury.newsapp.di

import com.lury.newsapp.core.domain.usecase.favoritenews.FavoriteNewsUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependency {
    fun favoriteNewsUseCase() : FavoriteNewsUseCase
}
