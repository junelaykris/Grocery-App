package com.padcx.mmz.groceryapp.mvp.presenters

import android.graphics.Bitmap
import com.padcx.mmz.groceryapp.data.vos.GroceryVO
import com.padcx.mmz.groceryapp.delegates.GroceryViewItemActionDelegate
import com.padcx.mmz.groceryapp.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView>, GroceryViewItemActionDelegate {
    fun onTapAddGroceryWithoutImage(name: String, description: String, amount: Int,image:String)
    fun onTapAddGrocery(groceryVO: GroceryVO, bitmap: Bitmap)
    fun onPhotoTaken(bitmap : Bitmap)
}
