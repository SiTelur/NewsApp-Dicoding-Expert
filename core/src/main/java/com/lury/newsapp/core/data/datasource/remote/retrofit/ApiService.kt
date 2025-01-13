package com.lury.newsapp.core.data.datasource.remote.retrofit

import com.lury.newsapp.core.BuildConfig
import com.lury.newsapp.core.data.model.response.NewsResponse
import retrofit2.http.GET

import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("q") query: String? = null
    ): NewsResponse
}