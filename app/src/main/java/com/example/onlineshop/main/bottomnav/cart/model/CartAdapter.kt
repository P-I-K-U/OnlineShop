package com.example.onlineshop.main.bottomnav.cart.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.main.bottomnav.cart.data.CartRvItem

class CartAdapter (val cartList: List<CartRvItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.CartViewHolder {
        return CartViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cart_item,parent,false))
    }

    override fun onBindViewHolder(holder: CartAdapter.CartViewHolder, position: Int) {
        val cartItem = cartList[position]
        holder.productImage.setImageResource(cartItem.productImage)
        holder.productName.text = cartItem.productName
        holder.productPrice.text = cartItem.productPrice
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val productImage : ImageView = itemView.findViewById(R.id.cartProductImage)
        val productName : TextView = itemView.findViewById(R.id.cartProductName)
        val  productPrice : TextView = itemView.findViewById(R.id.cartProductPrice)

    }
}