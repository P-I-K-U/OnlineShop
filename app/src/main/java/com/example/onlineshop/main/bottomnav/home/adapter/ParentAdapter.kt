package com.example.onlineshop.main.bottomnav.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.databinding.HomeBannerItemBinding
import com.example.onlineshop.databinding.HomeSaleItemsChildRvBinding
import com.example.onlineshop.main.bottomnav.home.data.Banner
import com.example.onlineshop.main.bottomnav.home.data.ChildRecyclerItems
import com.example.onlineshop.main.bottomnav.home.data.DataItemType
import com.example.onlineshop.main.bottomnav.home.data.ParentDataItems

class ParentAdapter(private val dataItemList: List<ParentDataItems>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    // Inner Class for Banner
    inner class BannerItemViewHolder(private val binding: HomeBannerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindBannerView(banner: Banner) {
            binding.bannerImage.setImageResource(banner.bannerImage)
        }
    }


    // Inner Class For Child Recycler View
    inner class ChildRvItemViewHolder(private val binding: HomeSaleItemsChildRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
      /*  init {
            binding.homeChildRv.setHasFixedSize(true)
        }*/

        fun bestSaleRvView(childRecyclerItemsList: List<ChildRecyclerItems>) {
            binding.homeChildRv.setHasFixedSize(true)
            binding.homeChildRv.layoutManager = LinearLayoutManager(
                binding.root.context, RecyclerView.HORIZONTAL, false
            )

            val snapHelper = PagerSnapHelper()
            snapHelper.attachToRecyclerView(binding.homeChildRv)
            val adapter = ChildAdapter(DataItemType.BEST_SELLER, childRecyclerItemsList)
            binding.homeChildRv.adapter = adapter
        }

        fun dailySaleRvView(childRecyclerItemsList: List<ChildRecyclerItems>) {
            binding.homeChildRv.setHasFixedSize(true)
            binding.homeChildRv.layoutManager = GridLayoutManager(binding.root.context, 2)
            val adapter = ChildAdapter(DataItemType.DAILY_SELLER, childRecyclerItemsList)
            binding.homeChildRv.adapter = adapter
        }

    }

    // Item type for Layout
    override fun getItemViewType(position: Int): Int {
        return when (dataItemList[position].viewType) {
            DataItemType.BANNER ->
                R.layout.home_banner_item

            else ->
                R.layout.home_sale_items_child_rv
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
         when (viewType) {
            R.layout.home_banner_item -> {
                val binding = HomeBannerItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BannerItemViewHolder(binding)
            }

            else -> {
                val binding = HomeSaleItemsChildRvBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ChildRvItemViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is BannerItemViewHolder -> {
                dataItemList[position].banner?.let { holder.bindBannerView(it) }
            }

            else -> {
                when (dataItemList[position].viewType) {
                    DataItemType.BEST_SELLER -> {
                        dataItemList[position].childRecyclerItemsList?.let {
                            (holder as ChildRvItemViewHolder).bestSaleRvView(
                                it
                            )
                        }
                    }

                    else -> {
                        dataItemList[position].childRecyclerItemsList?.let {
                            (holder as ChildRvItemViewHolder).dailySaleRvView(
                                it
                            )
                        }

                    }
                }
            }

        }
    }
}