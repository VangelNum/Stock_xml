package com.vangelnum.pokemon_api.di

import com.vangelnum.pokemon_api.common.Constants.BASE_URL
import com.vangelnum.pokemon_api.data.api.NewsApi
import com.vangelnum.pokemon_api.data.repository.NewsRepositoryImpl
import com.vangelnum.pokemon_api.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {

    @Singleton
    @Provides
    fun provideMyApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideMyRepository(api: NewsApi): NewsRepository {
        return NewsRepositoryImpl(api)
    }
}