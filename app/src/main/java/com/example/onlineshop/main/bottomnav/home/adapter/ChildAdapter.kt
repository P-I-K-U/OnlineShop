package com.example.onlineshop.main.bottomnav.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.databinding.HomeBestSellerItemBinding
import com.example.onlineshop.databinding.HomeDailySaleItemBinding
import com.example.onlineshop.main.bottomnav.home.data.ChildRecyclerItems
import com.example.onlineshop.main.bottomnav.home.data.DataItemType

class ChildAdapter(
    private val viewType: Int,
    private val childRvItemList: List<ChildRecyclerItems>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class BestSellerViewHolder(private val binding: HomeBestSellerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindBestSellerView(childRecyclerItems: ChildRecyclerItems) {
            binding.saleImage.setImageResource(childRecyclerItems.image)
            binding.offer.text = childRecyclerItems.offer
        }
    }

    inner class DailySellerViewHolder(private val binding: HomeDailySaleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindDailySellerView(childRecyclerItems: ChildRecyclerItems) {
            binding.saleImage.setImageResource(childRecyclerItems.image)
            binding.offer.text = childRecyclerItems.offer
        }
    }


    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            DataItemType.BEST_SELLER -> {
                val binding = HomeBestSellerItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BestSellerViewHolder(binding)
            }

            else -> {
                val binding = HomeDailySaleItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return DailySellerViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return childRvItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BestSellerViewHolder -> {
                holder.bindBestSellerView(childRvItemList[position])
            }

            is DailySellerViewHolder -> {
                holder.bindDailySellerView(childRvItemList[position])
            }
        }
    }
}