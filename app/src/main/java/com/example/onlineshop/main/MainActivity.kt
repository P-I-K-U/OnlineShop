package com.example.onlineshop.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivityMainBinding
import com.example.onlineshop.main.bottomnav.cart.CartFragment
import com.example.onlineshop.main.bottomnav.category.CategoryFragment
import com.example.onlineshop.main.bottomnav.home.HomeFragment
import com.example.onlineshop.main.bottomnav.profilemanage.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //default open home fragment
        replaceFragment(HomeFragment())
        /*   binding.toolBar.title = "Shop Now"
           binding.toolBar.menu
           binding.toolBar.titleMarginStart = 30*/


        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home ->
                    replaceFragment(HomeFragment())

                R.id.category ->
                    replaceFragment(CategoryFragment())

                R.id.cart ->
                    replaceFragment(CartFragment())

                R.id.account ->
                    replaceFragment(ProfileFragment())

            }
            true
        }


    }


    // For Replacing the Fragment
    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }
}