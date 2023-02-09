package com.vangelnum.pokemon_api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vangelnum.pokemon_api.data.model.Article
import com.vangelnum.pokemon_api.databinding.NewsItemBinding

class NewsAdapter(
    private val todos: List<Article>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Article, listener: OnItemClickListener) {
            binding.root.setOnClickListener {
                listener.onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(todos[position], listener)

        holder.binding.tvTitle.text = todos[position].title
        Glide.with(holder.binding.imageView.context)
            .load(todos[position].urlToImage)
            .into(holder.binding.imageView)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    interface OnItemClickListener {
        fun onItemClick(item: Article)
    }
}