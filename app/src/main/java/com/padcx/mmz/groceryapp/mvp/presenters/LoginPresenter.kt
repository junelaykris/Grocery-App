package com.padcx.mmz.groceryapp.mvp.presenters

import com.padcx.mmz.groceryapp.mvp.views.LoginView


interface LoginPresenter : BasePresenter<LoginView>{
    fun onTapLogin(email: String, password: String)
    fun onTapRegister()
}