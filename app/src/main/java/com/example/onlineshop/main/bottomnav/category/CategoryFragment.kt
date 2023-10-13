package com.example.onlineshop.main.bottomnav.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentCategoryBinding
import com.example.onlineshop.main.bottomnav.category.adapter.CategoryParentAdapter
import com.example.onlineshop.main.bottomnav.category.data.CategoryChildRvItems
import com.example.onlineshop.main.bottomnav.category.data.CategoryParentRvItem

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private val parentRvList = ArrayList<CategoryParentRvItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Parent RV Code....
        binding.parentRV.setHasFixedSize(true)
        addDataToParentRv()
        val parentAdapter = CategoryParentAdapter(parentRvList)
        binding.parentRV.adapter = parentAdapter

    }


    private fun addDataToParentRv() {

        // List For Child Rv
        val childItemMenList = ArrayList<CategoryChildRvItems>()
        childItemMenList.add(CategoryChildRvItems("Shirt", R.drawable.man_shirt))
        childItemMenList.add(CategoryChildRvItems("T-Shirt", R.drawable.man_tshirt))
        childItemMenList.add(CategoryChildRvItems("Shoes", R.drawable.man_shoe))
        childItemMenList.add(CategoryChildRvItems("Pants", R.drawable.men_pants))

        val childItemWomenList = ArrayList<CategoryChildRvItems>()
        childItemWomenList.add(CategoryChildRvItems("Dress", R.drawable.women_dress))
        childItemWomenList.add(CategoryChildRvItems("T-Shirt", R.drawable.women_tshirt))
        childItemWomenList.add(CategoryChildRvItems("High Heals", R.drawable.high_heals))
        childItemWomenList.add(CategoryChildRvItems("Pants", R.drawable.women_pants))
        childItemWomenList.add(CategoryChildRvItems("Bags", R.drawable.women_bag))

        val childItemHomeDecList = ArrayList<CategoryChildRvItems>()
        childItemHomeDecList.add(CategoryChildRvItems("Curtains", R.drawable.curtains))
        childItemHomeDecList.add(CategoryChildRvItems("Lights", R.drawable.lights))
        childItemHomeDecList.add(CategoryChildRvItems("Lamps", R.drawable.lamp))

        //List for Parent RV
        parentRvList.add(CategoryParentRvItem("Men", childItemMenList))
        parentRvList.add(CategoryParentRvItem("Women",childItemWomenList))
        parentRvList.add(CategoryParentRvItem("Home Decorations",childItemHomeDecList))
        parentRvList.add(CategoryParentRvItem("Groceries",childItemWomenList))

    }
}