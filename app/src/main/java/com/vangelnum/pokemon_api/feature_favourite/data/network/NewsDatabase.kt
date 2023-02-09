package com.vangelnum.pokemon_api.feature_favourite.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vangelnum.pokemon_api.feature_favourite.domain.model.NewsEntity

@Database(version = 1, entities = [NewsEntity::class])
abstract class NewsDatabase: RoomDatabase() {
    abstract fun newsDao(): NewsDao
}