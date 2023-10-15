package com.example.onlineshop.main.bottomnav.home.data

data class ParentDataItems(val viewType: Int){
    var childRecyclerItemsList : List<ChildRecyclerItems>? = null
    var banner : Banner? = null

    constructor(viewType: Int, childRecyclerItemsList: List<ChildRecyclerItems>) : this(viewType){
        this.childRecyclerItemsList = childRecyclerItemsList
    }

    constructor(viewType: Int,banner: Banner) : this(viewType){
        this.banner = banner
    }
}

data class Banner(val bannerImage : Int)
data class ChildRecyclerItems(val image : Int , val offer : String)
