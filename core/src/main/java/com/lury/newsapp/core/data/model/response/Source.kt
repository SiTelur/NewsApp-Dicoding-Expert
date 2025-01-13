package com.lury.newsapp.core.data.model.response

import com.google.gson.annotations.SerializedName

data class Source(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String? = null
)