package com.padcx.mmz.grocery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.grocery.mvp.views.BaseView

interface BasePresenter<V: BaseView> {
    fun onUiReady(owner: LifecycleOwner)
    fun initPresenter(view: V)
}