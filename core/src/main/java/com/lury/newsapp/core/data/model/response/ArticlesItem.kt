package com.lury.newsapp.core.data.model.response

import com.google.gson.annotations.SerializedName

data class ArticlesItem(

    @field:SerializedName("publishedAt")
	val publishedAt: String,

    @field:SerializedName("author")
	val author: String?,

    @field:SerializedName("urlToImage")
	val urlToImage: String? = null,

    @field:SerializedName("description")
	val description: String? = null,

    @field:SerializedName("source")
	val source: Source,

    @field:SerializedName("title")
	val title: String,

    @field:SerializedName("url")
	val url: String,

    @field:SerializedName("content")
	val content: String? = null
)