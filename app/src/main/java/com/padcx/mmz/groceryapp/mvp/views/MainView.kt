package com.padcx.mmz.groceryapp.mvp.views
import com.padcx.mmz.groceryapp.data.vos.GroceryVO

interface MainView : BaseView {
    fun showGroceryData(groceryList : List<GroceryVO>)
    fun showErrorMessage(message : String)
    fun showGroceryDialog(name: String, description: String, amount: String,foodImage:String)
    fun openGallery()
    fun showUserName(username:String)

    fun displayToolbarTitle(title:String)
    fun showRecyclerTypeLayout(viewType : String)
}