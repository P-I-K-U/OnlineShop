package com.example.onlineshop.main.bottomnav.category.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.main.bottomnav.category.CategoryChildRvItems

class CategoryChildAdapter(private val childList: List<CategoryChildRvItems>) :
    RecyclerView.Adapter<CategoryChildAdapter.ChildViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryChildAdapter.ChildViewHolder {
        return ChildViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_child_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryChildAdapter.ChildViewHolder, position: Int) {
        val childItem = childList[position]

        holder.childImage.setImageResource(childItem.childLogo)
        holder.childTitle.text = childItem.childTitle
    }

    override fun getItemCount(): Int {
        return childList.size
    }

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val childImage: ImageView = itemView.findViewById(R.id.childImageLogo)
        val childTitle: TextView = itemView.findViewById(R.id.childTitle)

    }
}