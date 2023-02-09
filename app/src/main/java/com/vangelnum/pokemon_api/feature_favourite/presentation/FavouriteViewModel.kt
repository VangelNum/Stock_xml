package com.vangelnum.pokemon_api.feature_favourite.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vangelnum.pokemon_api.common.Resource
import com.vangelnum.pokemon_api.feature_favourite.domain.model.NewsEntity
import com.vangelnum.pokemon_api.feature_favourite.domain.repository.FavouriteNewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val repository: FavouriteNewsRepository
) : ViewModel() {

    private var _state =
        MutableStateFlow<Resource<List<NewsEntity>>>(Resource.Loading(isLoading = true))
    val state: StateFlow<Resource<List<NewsEntity>>> = _state.asStateFlow()


    init {
        getFavouriteNews()
    }

    private fun getFavouriteNews() {
        repository.getAllFavouriteNews().onEach { status ->
            when (status) {
                is Resource.Error -> {
                    _state.value = Resource.Error(status.message.toString())
                }
                is Resource.Loading -> {
                    _state.value = Resource.Loading(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = Resource.Success(status.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun addFavouriteNews(news: NewsEntity) {
        viewModelScope.launch {
            repository.addFavouriteNews(news)
        }
    }

    fun deleteFavouriteNews(news: NewsEntity) {
        viewModelScope.launch {
            repository.deleteFavouriteNews(news)
        }
    }
}