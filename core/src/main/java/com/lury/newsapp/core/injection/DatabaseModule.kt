package com.lury.newsapp.core.injection

import android.content.Context
import androidx.room.Room
import com.lury.newsapp.core.data.datasource.local.database.room.NewsDao
import com.lury.newsapp.core.data.datasource.local.database.room.NewsDatabase
import com.lury.newsapp.core.data.datasource.local.preference.SettingsPreference
import com.lury.newsapp.core.data.datasource.local.preference.dataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context :Context): SettingsPreference = SettingsPreference(context.dataStore)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NewsDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)

        return Room.databaseBuilder(context, NewsDatabase::class.java, "News.db")
            .openHelperFactory(factory)
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideDao(database: NewsDatabase) : NewsDao = database.newsDao()
}