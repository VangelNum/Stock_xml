package com.vangelnum.pokemon_api.domain.repository

import com.vangelnum.pokemon_api.common.Resource
import com.vangelnum.pokemon_api.data.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(): Flow<Resource<News>>
}