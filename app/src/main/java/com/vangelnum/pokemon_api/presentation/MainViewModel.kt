package com.vangelnum.pokemon_api.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vangelnum.pokemon_api.common.Resource
import com.vangelnum.pokemon_api.data.model.News
import com.vangelnum.pokemon_api.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NewsRepository,
) : ViewModel() {

    private val _items = MutableStateFlow<Resource<News>?>(null)
    var items: StateFlow<Resource<News>?> = _items.asStateFlow()

    init {
        getNews()
    }

    private fun getNews() {
        repository.getNews().onEach { state ->
            when (state) {
                is Resource.Loading -> {
                    _items.value = Resource.Loading(isLoading = true)
                }
                is Resource.Error -> {
                    _items.value = Resource.Error(state.message.toString())
                }
                is Resource.Success -> {
                    _items.value = Resource.Success(state.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}