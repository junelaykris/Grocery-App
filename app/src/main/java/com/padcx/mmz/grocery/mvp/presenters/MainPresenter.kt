package com.padcx.mmz.grocery.mvp.presenters

import android.graphics.Bitmap
import com.padcx.mmz.grocery.delegates.GroceryViewItemActionDelegate
import com.padcx.mmz.grocery.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView>, GroceryViewItemActionDelegate {
    fun onTapAddGrocery(name: String, description: String, amount: Int)
    fun onPhotoTaken(bitmap : Bitmap)
}
