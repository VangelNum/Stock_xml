package com.vangelnum.pokemon_api.data.repository

import com.vangelnum.pokemon_api.common.Resource
import com.vangelnum.pokemon_api.data.api.NewsApi
import com.vangelnum.pokemon_api.data.model.News
import com.vangelnum.pokemon_api.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepositoryImpl(
    private val api: NewsApi,
) : NewsRepository {
    override fun getNews(): Flow<Resource<News>> = flow {
        emit(Resource.Loading(isLoading = true))
        try {
            val response = api.getNews()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}