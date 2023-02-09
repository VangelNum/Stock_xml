package com.vangelnum.pokemon_api.feature_favourite.di

import android.content.Context
import androidx.room.Room
import com.vangelnum.pokemon_api.feature_favourite.data.network.NewsDao
import com.vangelnum.pokemon_api.feature_favourite.data.network.NewsDatabase
import com.vangelnum.pokemon_api.feature_favourite.data.repository.FavouriteNewsRepositoryImpl
import com.vangelnum.pokemon_api.feature_favourite.domain.repository.FavouriteNewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavouriteModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NewsDatabase {
        synchronized(this) {
            return Room
                .databaseBuilder(context, NewsDatabase::class.java, "news_favourite_database")
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    @Provides
    @Singleton
    fun provideDao(database: NewsDatabase): NewsDao {
        return database.newsDao()
    }

    @Provides
    @Singleton
    fun provideFavouriteRepository(dao: NewsDao): FavouriteNewsRepository {
        return FavouriteNewsRepositoryImpl(dao)
    }

}