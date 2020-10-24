package com.padcx.mmz.groceryapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.groceryapp.mvp.views.BaseView

interface BasePresenter<V: BaseView> {
    fun onUiReady(owner: LifecycleOwner)
    fun initPresenter(view: V)
}