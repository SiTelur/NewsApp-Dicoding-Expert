package com.lury.newsapp.core.data.datasource.local.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lury.newsapp.core.data.datasource.local.database.entity.NewsEntity

@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}