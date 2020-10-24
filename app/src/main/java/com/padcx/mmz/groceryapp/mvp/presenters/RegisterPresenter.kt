package com.padcx.mmz.groceryapp.mvp.presenters
import com.padcx.mmz.groceryapp.mvp.views.RegisterView

interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onTapRegister(email: String, password: String, userName: String)
}