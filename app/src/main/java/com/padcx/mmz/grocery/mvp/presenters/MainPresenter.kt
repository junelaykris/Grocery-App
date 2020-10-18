package com.padcx.mmz.grocery.mvp.presenters

import android.graphics.Bitmap
import com.padcx.mmz.grocery.data.vos.GroceryVO
import com.padcx.mmz.grocery.delegates.GroceryViewItemActionDelegate
import com.padcx.mmz.grocery.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView>, GroceryViewItemActionDelegate {
    fun onTapAddGroceryWithoutImage(name: String, description: String, amount: Int,image:String)
    fun onTapAddGrocery(groceryVO: GroceryVO, bitmap: Bitmap)
    fun onPhotoTaken(bitmap : Bitmap)
}
