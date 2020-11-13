package com.padcx.mmz.groceryapp.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.groceryapp.analytics.PARAMETER_EMAIL
import com.padcx.mmz.groceryapp.analytics.SCREEN_LOGIN
import com.padcx.mmz.groceryapp.analytics.TAP_LOGIN
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

    override fun onUiReady(context: Context, owner: LifecycleOwner) {
        sendEventsToFirebaseAnalytics(context, SCREEN_LOGIN)
        mGroceryModel.setRemoteConfigWithDefaultValues()
        mGroceryModel.fetchRemoteConfig()
        mGroceryModel.setRemoteConfigValueForRecyclerView()
        mGroceryModel.fetchRemoteConfigForRecyclerView()
    }

    override fun onTapLogin(context: Context,email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            mView.showError("Please enter all the fields")
        } else {
            sendEventsToFirebaseAnalytics(context, TAP_LOGIN, PARAMETER_EMAIL, email)
            mAuthenticationModel.login(email, password, onSuccess = {
                mView.navigateToHomeScreen()
            }, onFailure = {
                mView.showError(it)
            })
        }
    }

    override fun onTapRegister() {
        mView.navigateToRegisterScreen()
    }
}