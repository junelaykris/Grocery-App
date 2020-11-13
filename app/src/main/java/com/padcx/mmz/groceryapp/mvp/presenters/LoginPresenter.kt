package com.padcx.mmz.groceryapp.mvp.presenters

import android.content.Context
import com.padcx.mmz.groceryapp.mvp.views.LoginView


interface LoginPresenter : BasePresenter<LoginView>{
    fun onTapLogin(context : Context, email: String, password: String)
    fun onTapRegister()
}