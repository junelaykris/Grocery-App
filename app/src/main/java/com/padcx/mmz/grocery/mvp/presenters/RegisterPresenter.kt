package com.padcx.mmz.grocery.mvp.presenters
import com.padcx.mmz.grocery.mvp.views.RegisterView

interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onTapRegister(email: String, password: String, userName: String)
}