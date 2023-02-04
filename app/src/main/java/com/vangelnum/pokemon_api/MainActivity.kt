package com.vangelnum.pokemon_api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vangelnum.pokemon_api.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf(
            Todo("Follow Android", false),
            Todo("ANother Android", false),
            Todo("Follow Android", false),
            Todo("Follow Valueid", false),
            Todo("Follow cHECK", false)
        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)
        }
    }
}