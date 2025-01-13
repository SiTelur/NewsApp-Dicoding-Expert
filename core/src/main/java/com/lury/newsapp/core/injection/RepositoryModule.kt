package com.lury.newsapp.core.injection

import com.lury.newsapp.core.data.datasource.local.LocalDataSource
import com.lury.newsapp.core.data.datasource.remote.RemoteDataSource
import com.lury.newsapp.core.data.repository.favoritenews.FavoriteNewsRepository
import com.lury.newsapp.core.data.repository.news.NewsRepository
import com.lury.newsapp.core.data.repository.settings.SettingsRepository
import com.lury.newsapp.core.domain.repository.favoritenews.IFavoriteNewsRepository
import com.lury.newsapp.core.domain.repository.news.INewsRepository
import com.lury.newsapp.core.domain.repository.settings.ISettingsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideNewsRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): INewsRepository = NewsRepository(remoteDataSource, localDataSource)

    @Singleton
    @Provides
    fun provideFavoriteNewsRepository(localDataSource: LocalDataSource) : IFavoriteNewsRepository = FavoriteNewsRepository(localDataSource)

    @Singleton
    @Provides
    fun provideSettingsRepository(localDataSource: LocalDataSource) : ISettingsRepository = SettingsRepository(localDataSource)
}