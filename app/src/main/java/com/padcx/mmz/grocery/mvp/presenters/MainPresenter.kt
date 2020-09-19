package com.padcx.mmz.grocery.mvp.presenters

import com.padcx.mmz.grocery.delegates.GroceryViewItemActionDelegate
import com.padcx.mmz.grocery.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView>, GroceryViewItemActionDelegate {
    fun onTapAddGrocery(name: String, description: String, amount: Int)
}
