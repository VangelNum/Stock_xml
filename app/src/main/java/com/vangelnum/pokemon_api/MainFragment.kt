package com.vangelnum.pokemon_api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.vangelnum.pokemon_api.common.Resource
import com.vangelnum.pokemon_api.data.model.Article
import com.vangelnum.pokemon_api.databinding.FragmentMainBinding
import com.vangelnum.pokemon_api.feature_favourite.domain.model.NewsEntity
import com.vangelnum.pokemon_api.feature_favourite.presentation.FavouriteViewModel
import com.vangelnum.pokemon_api.presentation.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    private val favouriteViewModel: FavouriteViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenCreated {
            val state = viewModel.items
            state.collect { res ->
                when (res) {
                    is Resource.Success -> {
                        val adapter = NewsAdapter(
                            res.data!!.articles, object : NewsAdapter.OnItemClickListener {
                                override fun onItemClick(item: Article) {
                                    favouriteViewModel.addFavouriteNews(NewsEntity(item.urlToImage,"some time"))
                                }
                            }
                        )
                        binding.rvTodos.adapter = adapter
                        binding.rvTodos.layoutManager = LinearLayoutManager(view.context)
                        binding.pgMain.visibility = View.GONE
                    }
                    is Resource.Error -> {
                        binding.tvError.text = res.message.toString()
                        binding.pgMain.visibility = View.GONE
                        binding.tvError.visibility = View.VISIBLE
                    }
                    is Resource.Loading -> {
                        binding.pgMain.visibility = View.VISIBLE
                    }
                    else -> {}
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
