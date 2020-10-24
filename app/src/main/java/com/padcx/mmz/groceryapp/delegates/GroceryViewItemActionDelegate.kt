package com.padcx.mmz.groceryapp.delegates

import com.padcx.mmz.groceryapp.data.vos.GroceryVO

interface GroceryViewItemActionDelegate{
    fun onTapDeleteGrocery(name : String)
    fun onTapEditGrocery(name: String, description: String, amount: Int,image:String)
    fun onTapFileUpload(grocery: GroceryVO)
}