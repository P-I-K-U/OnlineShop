package com.example.onlineshop.main.bottomnav.category.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.main.bottomnav.category.data.CategoryParentRvItem

class CategoryParentAdapter(private val parentList: List<CategoryParentRvItem>) :
    RecyclerView.Adapter<CategoryParentAdapter.ParentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return ParentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_parent_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return parentList.size
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val parentItem = parentList[position]

        // parent RV code
        holder.parentTitle.text = parentItem.parentTitle

        //child Rv Code here
        val adapter = CategoryChildAdapter(parentItem.mList)
        holder.childRv.setHasFixedSize(true)
        holder.childRv.adapter = adapter

    }

    inner class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parentTitle: TextView = itemView.findViewById(R.id.parentTitle)
        val childRv: RecyclerView = itemView.findViewById(R.id.childRv)

    }

}