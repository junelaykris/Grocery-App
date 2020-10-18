package com.padcx.mmz.grocery.delegates

import com.padcx.mmz.grocery.data.vos.GroceryVO

interface GroceryViewItemActionDelegate{
    fun onTapDeleteGrocery(name : String)
    fun onTapEditGrocery(name: String, description: String, amount: Int,image:String)
    fun onTapFileUpload(grocery: GroceryVO)
}