package com.vangelnum.pokemon_api.feature_favourite.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vangelnum.pokemon_api.databinding.FavouriteItemBinding
import com.vangelnum.pokemon_api.feature_favourite.domain.model.NewsEntity

class FavouriteAdapter(
    private val favouriteItems: List<NewsEntity>
) : RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>() {
    class FavouriteViewHolder(val binding: FavouriteItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val view = FavouriteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavouriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        Glide.with(holder.binding.photoNews.context).load(
            favouriteItems[position].url
        ).into(holder.binding.photoNews)
    }

    override fun getItemCount(): Int {
        return favouriteItems.size
    }
}