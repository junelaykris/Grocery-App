package com.padcx.mmz.grocery.mvp.presenters

import com.padcx.mmz.grocery.mvp.views.LoginView


interface LoginPresenter : BasePresenter<LoginView>{
    fun onTapLogin(email: String, password: String)
    fun onTapRegister()
}