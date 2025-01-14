package com.lury.newsapp.core.data.model

import com.lury.newsapp.core.data.datasource.local.database.entity.NewsEntity
import com.lury.newsapp.core.data.model.response.ArticlesItem
import com.lury.newsapp.core.domain.model.favoritenews.FavoriteNews
import com.lury.newsapp.core.domain.model.news.News

object DataMapper {
    fun entityToNewsFavorite(entity: NewsEntity) : FavoriteNews {
        return FavoriteNews(
            publishedAt = entity.publishedAt,
            author = entity.author,
            urlToImage = entity.urlToImage,
            description = entity.description,
            source = entity.source,
            title = entity.title,
            url =  entity.url,
            content = entity.content
        )
    }

    fun toNews( item: ArticlesItem): News {
        return News(
            title = item.title,
            description = item.description ?: "No Description",
            publishedAt = item.publishedAt,
            author = item.author ?: "No Author",
            urlToImage = item.urlToImage ?: "No Image",
            url = item.url,
            source = item.source.name,
            content = item.content ?: "No Content"
        )
    }

    fun toEntity(news: News) : NewsEntity {
        return NewsEntity(
            title = news.title,
            description = news.description,
            publishedAt = news.publishedAt,
            author = news.author,
            urlToImage = news.urlToImage,
            url = news.url,
            source = news.source,
            content = news.content
        )
    }

}