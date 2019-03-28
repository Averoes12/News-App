package com.averoes.daff.newsapp.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class ResponseNews(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: ArrayList<ArticlesItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)