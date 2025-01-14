package com.lury.newsapp.di

import com.lury.newsapp.core.domain.usecase.favoritenews.FavoriteNewsInteractor
import com.lury.newsapp.core.domain.usecase.favoritenews.FavoriteNewsUseCase
import com.lury.newsapp.core.domain.usecase.news.NewsInteractor
import com.lury.newsapp.core.domain.usecase.news.NewsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideNewsUseCase(newsInteractor: NewsInteractor): NewsUseCase

    @Binds
    @Singleton
    abstract fun provideFavoriteNewsUseCase(favoriteInteractor: FavoriteNewsInteractor): FavoriteNewsUseCase

}