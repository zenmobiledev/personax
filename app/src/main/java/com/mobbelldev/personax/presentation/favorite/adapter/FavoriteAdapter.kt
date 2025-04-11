package com.mobbelldev.personax.presentation.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.ItemListUserBinding
import com.mobbelldev.personax.domain.model.FavoriteUser

class FavoriteAdapter(val clickUnsaved: (FavoriteUser) -> Unit) :
    ListAdapter<FavoriteUser, FavoriteAdapter.FavoriteViewHolder>(DIFF_UTIL) {
    inner class FavoriteViewHolder(private val binding: ItemListUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: FavoriteUser) {
            val context = itemView.context
            Glide.with(itemView.context)
                .load(user.image)
                .placeholder(R.drawable.baseline_broken_image_24)
                .into(binding.ivUser)
            binding.tvNameUser.text = user.username
            binding.tvEmailUser.text = user.email

            // Favorite
            binding.ivFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.baseline_favorite_24
                )
            )
            binding.flFavorite.setOnClickListener {
                clickUnsaved(user).also {
                    Toast.makeText(context, "UNSAVED", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): FavoriteViewHolder {
        return FavoriteViewHolder(
            ItemListUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: FavoriteViewHolder,
        position: Int,
    ) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<FavoriteUser>() {
            override fun areItemsTheSame(
                oldItem: FavoriteUser,
                newItem: FavoriteUser,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: FavoriteUser,
                newItem: FavoriteUser,
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}