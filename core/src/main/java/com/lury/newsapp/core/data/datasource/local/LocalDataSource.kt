package com.lury.newsapp.core.data.datasource.local

import com.lury.newsapp.core.data.datasource.local.database.entity.NewsEntity
import com.lury.newsapp.core.data.datasource.local.database.room.NewsDao
import com.lury.newsapp.core.data.datasource.local.preference.SettingsPreference
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val newsDao: NewsDao,private val settingsPreference: SettingsPreference) {
    suspend fun saveFavoriteNews(data : NewsEntity) = newsDao.insertFavoriteNews(data)
    suspend fun deleteFavoriteNews(data: NewsEntity) = newsDao.deleteFavoriteNews(data.title)
    fun isNewsExist(data: NewsEntity) : Flow<Boolean> = newsDao.isNewsExist(data.title)
    fun getFavoriteNews() : Flow<List<NewsEntity>> = newsDao.getFavoriteNews()

    fun isDarkMode() = settingsPreference.getSettings()
    suspend fun changeMode(value: Boolean) = settingsPreference.saveSettings(value)
}