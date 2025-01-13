package com.lury.newsapp.presentation.model

import android.os.Parcelable
import com.lury.newsapp.core.domain.model.news.News
import kotlinx.parcelize.Parcelize
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

@Parcelize
data class NewsUi(
    val publishedAt: DisplayableDate,
    val author: String,
    val urlToImage: String,
    val description: String,
    val source: String,
    val title: String,
    val url: String,
    val content: String
) : Parcelable

fun News.toNewsUi(): NewsUi {
    return NewsUi(
        title = this.title,
        description = this.description,
        publishedAt = this.publishedAt.toDisplayableDate(),
        author = this.author,
        urlToImage = this.urlToImage,
        url = this.url,
        source = this.source,
        content = this.content
    )
}

fun NewsUi.toNews(): News {
    return News(
        title = this.title,
        description = this.description,
        publishedAt = this.publishedAt.formatedDate,
        author = this.author,
        urlToImage = this.urlToImage,
        url = this.url,
        source = this.source,
        content = this.content
    )
}


@Parcelize
data class DisplayableDate(
    val value: String, val formatedDate: String
) : Parcelable

fun String.toDisplayableDate(): DisplayableDate {
    val dateTimeString = this
    val zonedDateTime = ZonedDateTime.parse(dateTimeString)
    val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
        .withLocale(Locale.getDefault())
    return DisplayableDate(value = this, formatedDate = zonedDateTime.format(formatter))
}
