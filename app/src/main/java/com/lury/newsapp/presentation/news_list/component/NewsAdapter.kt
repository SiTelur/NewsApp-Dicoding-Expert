package com.lury.newsapp.newslist.presentation.news_list.component

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lury.newsapp.databinding.ItemNewsBinding
import com.lury.newsapp.presentation.model.NewsUi

class NewsAdapter(private val listener : OnItemClickListener) : ListAdapter<NewsUi, NewsAdapter.NewsViewHolder>(
    DIFF_CALLBACK
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: NewsUi) {
            // Load image using Glide
            Glide.with(itemView.context)
                .load(data.urlToImage)
                .into(binding.imageView)

            // Set text values
            binding.textViewTitle.text = data.title
            binding.textViewDate.text = data.publishedAt.formatedDate

            // Set click listener

            binding.root.setOnClickListener{
                listener.onItemClicked(data)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NewsUi>() {
            override fun areItemsTheSame(oldItem: NewsUi, newItem: NewsUi): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: NewsUi, newItem: NewsUi): Boolean {
                return oldItem == newItem
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClicked(newsUi: NewsUi)
    }
}
