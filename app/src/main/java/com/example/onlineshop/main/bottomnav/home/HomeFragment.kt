package com.example.onlineshop.main.bottomnav.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlineshop.R
import com.example.onlineshop.databinding.FragmentHomeBinding
import com.example.onlineshop.main.bottomnav.home.adapter.ParentAdapter
import com.example.onlineshop.main.bottomnav.home.data.Banner
import com.example.onlineshop.main.bottomnav.home.data.ChildRecyclerItems
import com.example.onlineshop.main.bottomnav.home.data.DataItemType
import com.example.onlineshop.main.bottomnav.home.data.ParentDataItems

class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    private lateinit var mList: ArrayList<ParentDataItems>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Home Rv Code....
        binding.parentRV.setHasFixedSize(true)
        binding.parentRV.layoutManager = LinearLayoutManager(binding.root.context)
        mList = ArrayList()
        addDataToHome()
        val adapter = ParentAdapter(mList)
        binding.parentRV.adapter = adapter


    }

    private fun addDataToHome() {

        //List for Best Sele
        val bestSellerList = ArrayList<ChildRecyclerItems>()
        bestSellerList.add(ChildRecyclerItems(R.drawable.best_sale1, "Up To 20% Off"))
        bestSellerList.add(ChildRecyclerItems(R.drawable.best_sale2, "Up To 50% Off"))
        bestSellerList.add(ChildRecyclerItems(R.drawable.best_sale3, "Up To 70% Off"))
        bestSellerList.add(ChildRecyclerItems(R.drawable.img3, "Up To 15% Off"))
        bestSellerList.add(ChildRecyclerItems(R.drawable.img1, "Up To 10% Off"))
        bestSellerList.add(ChildRecyclerItems(R.drawable.img5, "Up To 20% Off"))

        //List For Daily Sale

        val dailySaleList = ArrayList<ChildRecyclerItems>()
        dailySaleList.add(ChildRecyclerItems(R.drawable.img4, "Up To 60% Off"))
        dailySaleList.add(ChildRecyclerItems(R.drawable.img1, "Up To 60% Off"))
        dailySaleList.add(ChildRecyclerItems(R.drawable.img2, "Up To 60% Off"))
        dailySaleList.add(ChildRecyclerItems(R.drawable.img3, "Up To 60% Off"))



        mList.add(ParentDataItems(DataItemType.BEST_SELLER, bestSellerList))
        mList.add((ParentDataItems(DataItemType.BANNER, Banner(R.drawable.sale_img1))))
        mList.add(ParentDataItems(DataItemType.DAILY_SELLER, dailySaleList))
        mList.add((ParentDataItems(DataItemType.BANNER, Banner(R.drawable.offer_sale))))
        mList.add(ParentDataItems(DataItemType.BEST_SELLER, bestSellerList.reversed()))
        mList.add((ParentDataItems(DataItemType.BANNER, Banner(R.drawable.offer_sale))))




    }
}