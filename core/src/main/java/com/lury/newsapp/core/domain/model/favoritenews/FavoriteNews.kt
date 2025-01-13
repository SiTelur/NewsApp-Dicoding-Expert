package com.lury.newsapp.core.domain.model.favoritenews

data class FavoriteNews(
    val publishedAt: String,
    val author: String,
    val urlToImage: String,
    val description: String,
    val source: String,
    val title: String,
    val url: String,
    val content: String
)