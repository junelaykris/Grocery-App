package com.padcx.mmz.groceryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.groceryapp.data.models.AuthenticationModel
import com.padcx.mmz.groceryapp.data.models.AuthenticationModelImpl
import com.padcx.mmz.groceryapp.data.models.GroceryModel
import com.padcx.mmz.groceryapp.data.models.GroceryModelImpl
import com.padcx.mmz.groceryapp.mvp.presenters.AbstractBasePresenter
import com.padcx.mmz.groceryapp.mvp.presenters.LoginPresenter
import com.padcx.mmz.groceryapp.mvp.views.LoginView

class LoginPresenterImpl : LoginPresenter, AbstractBasePresenter<LoginView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    private val mGroceryModel: GroceryModel = GroceryModelImpl

    override fun onUiReady(owner: LifecycleOwner) {
        mGroceryModel.setRemoteConfigWithDefaultValues()
        mGroceryModel.fetchRemoteConfig()
        mGroceryModel.setRemoteConfigValueForRecyclerView()
        mGroceryModel.fetchRemoteConfigForRecyclerView()
    }

    override fun onTapLogin(email: String, password: String) {
        mAuthenticationModel.login(email, password, onSuccess = {
            mView.navigateToHomeScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapRegister() {
        mView.navigateToRegisterScreen()
    }
}