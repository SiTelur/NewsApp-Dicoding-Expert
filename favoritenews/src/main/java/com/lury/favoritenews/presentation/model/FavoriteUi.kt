package com.lury.favoritenews.presentation.model

import com.lury.newsapp.core.domain.model.favoritenews.FavoriteNews
import com.lury.newsapp.presentation.model.DisplayableDate
import com.lury.newsapp.presentation.model.NewsUi

data class FavoriteUi(
    val publishedAt: String,
    val author: String,
    val urlToImage: String,
    val description: String,
    val source: String,
    val title: String,
    val url: String,
    val content: String
)

fun FavoriteNews.toFavoriteUi(): FavoriteUi = FavoriteUi(
    title = title,
    url = url,
    source = source,
    author = author,
    content = content,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    description = description
)

fun FavoriteUi.favoriteUiToNewsUi(): NewsUi {
    return NewsUi(
        title = title,
        url = url,
        source = source,
        author = author,
        content = content,
        urlToImage = urlToImage,
        publishedAt = DisplayableDate(publishedAt, publishedAt),
        description = description
    )
}