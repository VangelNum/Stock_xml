package com.vangelnum.pokemon_api.data.api

import com.vangelnum.pokemon_api.common.Constants.API_KEY
import com.vangelnum.pokemon_api.data.model.News
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {
    @GET("/v2/top-headlines?country=ru&apiKey=$API_KEY")
    suspend fun getNews(): Response<News>


}