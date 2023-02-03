package com.vangelnum.pokemon_api.domain.repository

import com.vangelnum.pokemon_api.data.model.News
import retrofit2.Response

interface NewsRepository {
    suspend fun getNews(): Response<News>
}