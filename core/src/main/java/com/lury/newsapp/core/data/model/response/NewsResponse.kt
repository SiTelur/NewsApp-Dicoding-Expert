package com.lury.newsapp.core.data.model.response

import com.google.gson.annotations.SerializedName

data class NewsResponse(

    @field:SerializedName("totalResults")
	val totalResults: Int,

    @field:SerializedName("articles")
	val articles: List<ArticlesItem>,

    @field:SerializedName("status")
	val status: String
)