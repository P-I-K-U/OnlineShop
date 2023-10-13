package com.example.onlineshop.main.bottomnav.cart

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentCartBinding
import com.example.onlineshop.main.bottomnav.cart.data.CartRvItem
import com.example.onlineshop.main.bottomnav.cart.model.CartAdapter

class CartFragment : Fragment() {


    private lateinit var binding: FragmentCartBinding
    private val cartRvList = ArrayList<CartRvItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentCartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cartRv.setHasFixedSize(true)
        addItemOnCartList()
        val cartAdapter = CartAdapter(cartRvList)
        binding.cartRv.adapter = cartAdapter
    }

    private fun addItemOnCartList() {

        cartRvList.add(CartRvItem(R.drawable.img1,"Black Shoe","700"))
        cartRvList.add(CartRvItem(R.drawable.img2,"High Heals Blue","900"))
        cartRvList.add(CartRvItem(R.drawable.img3,"Red Shoe","500"))
        cartRvList.add(CartRvItem(R.drawable.img4,"T-Shirt Grey","300"))
        cartRvList.add(CartRvItem(R.drawable.img5,"Dress Green","700"))
    }
}