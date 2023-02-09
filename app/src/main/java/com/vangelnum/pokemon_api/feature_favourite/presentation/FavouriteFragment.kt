package com.vangelnum.pokemon_api.feature_favourite.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vangelnum.pokemon_api.common.Resource
import com.vangelnum.pokemon_api.databinding.FragmentFavouriteBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavouriteFragment : Fragment() {
    private var _binding: FragmentFavouriteBinding? = null
    private val binding get() = _binding!!
    private val favouriteViewModel: FavouriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenStarted {
            val favouriteState = favouriteViewModel.state
            favouriteState.collect { state ->
                when (state) {
                    is Resource.Loading -> {
                        Log.d("tag", "loading")
                    }
                    is Resource.Error -> {
                        Log.d("tag", state.message.toString())
                    }
                    is Resource.Success -> {
                        val adapter = FavouriteAdapter(state.data!!)
                        binding.rvFavourite.adapter = adapter
                        binding.rvFavourite.layoutManager = LinearLayoutManager(view.context)
                    }
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}