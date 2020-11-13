package com.padcx.mmz.groceryapp.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.groceryapp.analytics.PARAMETER_EMAIL
import com.padcx.mmz.groceryapp.analytics.SCREEN_REGISTER
import com.padcx.mmz.groceryapp.analytics.TAP_REGISTER
import com.padcx.mmz.groceryapp.data.models.AuthenticationModel
import com.padcx.mmz.groceryapp.data.models.AuthenticationModelImpl
import com.padcx.mmz.groceryapp.mvp.presenters.AbstractBasePresenter
import com.padcx.mmz.groceryapp.mvp.presenters.RegisterPresenter
import com.padcx.mmz.groceryapp.mvp.views.RegisterView

class RegisterPresenterImpl : RegisterPresenter, AbstractBasePresenter<RegisterView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapRegister(context : Context, email: String, password: String, userName: String) {
        if (email.isEmpty() || password.isEmpty() || userName.isEmpty()) {
            mView.showError("Please enter all fields")
        } else {
            sendEventsToFirebaseAnalytics(context, TAP_REGISTER, PARAMETER_EMAIL, email)
            mAuthenticationModel.register(email, password, userName, onSuccess = {
                mView.navigateToToLoginScreen()
            }, onFailure = {
                mView.showError(it)
            })
        }
    }

    override fun onUiReady(
        context: Context,
        owner: LifecycleOwner
    ) {
        sendEventsToFirebaseAnalytics(context, SCREEN_REGISTER)
    }
}