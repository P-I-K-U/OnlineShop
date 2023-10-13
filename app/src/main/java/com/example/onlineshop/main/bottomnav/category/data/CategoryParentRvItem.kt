package com.example.onlineshop.main.bottomnav.category.data

import com.example.onlineshop.main.bottomnav.category.data.CategoryChildRvItems

data class CategoryParentRvItem(
    val parentTitle: String,
    val mList: List<CategoryChildRvItems>
)
