package com.vangelnum.pokemon_api

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vangelnum.pokemon_api.data.model.Article
import com.vangelnum.pokemon_api.databinding.ActivityMainBinding
import com.vangelnum.pokemon_api.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todoList: MutableList<Article> = mutableListOf()
        val adapter = TodoAdapter(todoList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val state = viewModel.items
            lifecycleScope.launch {
                state.collect { news ->
                    if (news.status == "ok") {
                        news.articles.forEachIndexed { index, it ->
                            todoList.add(it)
                            adapter.notifyItemChanged(index)
                        }
                    }
                }
            }
        }


    }
}