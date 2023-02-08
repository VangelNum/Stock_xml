package com.vangelnum.pokemon_api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vangelnum.pokemon_api.databinding.FragmentMainBinding
import com.vangelnum.pokemon_api.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment() : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            val state = viewModel.items
            state.collect {
                if (it.status == "ok") {
                    val adapter: TodoAdapter = TodoAdapter(it.articles)
                    binding.rvTodos.adapter = adapter
                    binding.rvTodos.layoutManager = LinearLayoutManager(view.context)
                }
            }
        }
    }

}
