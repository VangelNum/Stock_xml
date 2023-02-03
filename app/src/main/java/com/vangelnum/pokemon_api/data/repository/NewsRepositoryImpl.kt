package com.vangelnum.pokemon_api.data.repository

import com.vangelnum.pokemon_api.data.api.NewsApi
import com.vangelnum.pokemon_api.data.model.News
import com.vangelnum.pokemon_api.domain.repository.NewsRepository
import retrofit2.Response

class NewsRepositoryImpl(
    private val api: NewsApi,
) : NewsRepository {
    override suspend fun getNews(): Response<News> {
        return api.getNews()
    }
}