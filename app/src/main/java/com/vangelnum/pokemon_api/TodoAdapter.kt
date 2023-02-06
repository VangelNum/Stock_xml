package com.vangelnum.pokemon_api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vangelnum.pokemon_api.data.model.Article
import com.vangelnum.pokemon_api.databinding.ItemTodoBinding

class TodoAdapter(
    private val todos: List<Article>
) : RecyclerView.Adapter<TodoAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.binding.tvTitle.text = todos[position].title
        Glide.with(holder.binding.imageView.context)
            .load(todos[position].urlToImage)
            .into(holder.binding.imageView)
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}