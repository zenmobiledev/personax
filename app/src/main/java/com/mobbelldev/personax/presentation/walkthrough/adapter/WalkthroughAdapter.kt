package com.mobbelldev.personax.presentation.walkthrough.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobbelldev.personax.R
import com.mobbelldev.personax.databinding.ItemWalkthroughBinding
import com.mobbelldev.personax.presentation.walkthrough.WalkthroughActivity

class WalkthroughAdapter : RecyclerView.Adapter<WalkthroughAdapter.WalkthroughViewHolder>() {
    inner class WalkthroughViewHolder(val binding: ItemWalkthroughBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): WalkthroughViewHolder = WalkthroughViewHolder(
        ItemWalkthroughBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun onBindViewHolder(
        holder: WalkthroughViewHolder,
        position: Int,
    ) = holder.itemView.run {
        with(holder) {
            if (position == 0) {
                with(binding) {
                    ivImage.setImageResource(R.drawable.illustration_1)
                    tvTitle.text = context.getString(R.string.text_title_illustration_1)
                    tvSubTitle.text = context.getString(R.string.text_sub_title_illustration_1)
                }
            }
            if (position == 1) {
                with(binding) {
                    ivImage.setImageResource(R.drawable.illustration_2)
                    tvTitle.text = context.getString(R.string.text_title_illustration_2)
                    tvSubTitle.text = context.getString(R.string.text_sub_title_illustration_2)
                }
            }
            if (position == 2) {
                with(binding) {
                    ivImage.setImageResource(R.drawable.illustration_3)
                    tvTitle.text = context.getString(R.string.text_title_illustration_3)
                    tvSubTitle.text = context.getString(R.string.text_sub_title_illustration_3)
                }
            }
            if (position == 3) {
                with(binding) {
                    ivImage.setImageResource(R.drawable.illustration_4)
                    tvTitle.text = context.getString(R.string.text_title_illustration_4)
                    tvSubTitle.text = context.getString(R.string.text_sub_title_illustration_4)
                }
            }
            if (position == 4) {
                with(binding) {
                    ivImage.setImageResource(R.drawable.illustration_5)
                    tvTitle.text = context.getString(R.string.text_title_illustration_5)
                    tvSubTitle.text = context.getString(R.string.text_sub_title_illustration_5)
                }
            }
        }
    }

    override fun getItemCount(): Int = WalkthroughActivity.MAX_STEP
}