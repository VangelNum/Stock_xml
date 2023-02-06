package com.vangelnum.pokemon_api.data.model

data class News(
    var articles: MutableList<Article> = mutableListOf(),
    val status: String = "",
    var totalResults: Int = 0
)