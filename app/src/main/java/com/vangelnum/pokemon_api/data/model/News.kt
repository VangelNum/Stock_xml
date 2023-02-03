package com.vangelnum.pokemon_api.data.model

data class News(
    val articles: List<Article>,
    val status: String?,
    var totalResults: Int
)