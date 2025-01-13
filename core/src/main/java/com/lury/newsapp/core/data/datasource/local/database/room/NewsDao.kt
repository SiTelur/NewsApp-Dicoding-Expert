package com.lury.newsapp.core.data.datasource.local.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lury.newsapp.core.data.datasource.local.database.entity.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM news")
    fun getFavoriteNews(): Flow<List<NewsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteNews(data: NewsEntity)

    @Query("DELETE FROM news WHERE title LIKE :selectedTitle")
    suspend fun deleteFavoriteNews(selectedTitle: String)

    @Query("SELECT EXISTS(SELECT 1 FROM news WHERE title = :selectedTitle)")
    fun isNewsExist(selectedTitle: String): Flow<Boolean>
}