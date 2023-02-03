package com.vangelnum.pokemon_api.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vangelnum.pokemon_api.data.model.News
import com.vangelnum.pokemon_api.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: NewsRepository,
) : ViewModel() {

    private val _items = MutableStateFlow(News(emptyList(), "", 0))
    var items: StateFlow<News> = _items

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            val response = repository.getNews()
            if (response.isSuccessful) {
                _items.value = response.body()!!
            }
        }
    }

}