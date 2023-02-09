package com.vangelnum.pokemon_api.feature_favourite.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.vangelnum.pokemon_api.feature_favourite.domain.model.NewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Query("SELECT * FROM newsTable")
    fun getAllFavouriteNews(): Flow<List<NewsEntity>>

    @Insert
    suspend fun addFavouriteNews(news: NewsEntity)

    @Delete
    suspend fun deleteFavouriteNews(news: NewsEntity)

}