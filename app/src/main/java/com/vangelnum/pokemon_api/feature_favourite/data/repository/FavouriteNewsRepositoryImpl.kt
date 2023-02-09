package com.vangelnum.pokemon_api.feature_favourite.data.repository

import com.vangelnum.pokemon_api.common.Resource
import com.vangelnum.pokemon_api.feature_favourite.data.network.NewsDao
import com.vangelnum.pokemon_api.feature_favourite.domain.model.NewsEntity
import com.vangelnum.pokemon_api.feature_favourite.domain.repository.FavouriteNewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FavouriteNewsRepositoryImpl @Inject constructor(
    private var dao: NewsDao
) : FavouriteNewsRepository {
    override fun getAllFavouriteNews(): Flow<Resource<List<NewsEntity>>> = flow {
        try {
            val response = dao.getAllFavouriteNews()
            response.collect {
                emit(Resource.Success(it))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }

    override suspend fun addFavouriteNews(news: NewsEntity) {
        return dao.addFavouriteNews(news)
    }

    override suspend fun deleteFavouriteNews(news: NewsEntity) {
        return dao.deleteFavouriteNews(news)
    }
}