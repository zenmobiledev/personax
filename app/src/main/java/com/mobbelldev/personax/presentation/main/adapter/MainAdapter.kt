package com.mobbelldev.personax.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.ItemListUserBinding
import com.mobbelldev.personax.domain.model.UsersItem

class MainAdapter : ListAdapter<UsersItem, MainAdapter.MainViewHolder>(DIFF_UTIL) {
    inner class MainViewHolder(private val binding: ItemListUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(usersItem: UsersItem) {
            Glide.with(itemView.context)
                .load(usersItem.image)
                .placeholder(R.drawable.baseline_broken_image_24)
                .into(binding.ivUser)
            binding.tvNameUser.text = usersItem.username
            binding.tvEmailUser.text = usersItem.email
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MainViewHolder = MainViewHolder(
        ItemListUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: MainViewHolder,
        position: Int,
    ) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<UsersItem>() {
            override fun areItemsTheSame(
                oldItem: UsersItem,
                newItem: UsersItem,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: UsersItem,
                newItem: UsersItem,
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}