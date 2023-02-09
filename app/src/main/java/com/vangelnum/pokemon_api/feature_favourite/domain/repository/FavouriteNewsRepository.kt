package com.vangelnum.pokemon_api.feature_favourite.domain.repository

import com.vangelnum.pokemon_api.common.Resource
import com.vangelnum.pokemon_api.feature_favourite.domain.model.NewsEntity
import kotlinx.coroutines.flow.Flow

interface FavouriteNewsRepository {
    fun getAllFavouriteNews() : Flow<Resource<List<NewsEntity>>>

    suspend fun addFavouriteNews(news: NewsEntity)

    suspend fun deleteFavouriteNews(news: NewsEntity)
}