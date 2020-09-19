package com.padcx.mmz.grocery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.grocery.data.models.GroceryModelImpl
import com.padcx.mmz.grocery.mvp.presenters.AbstractBasePresenter
import com.padcx.mmz.grocery.mvp.presenters.MainPresenter
import com.padcx.mmz.grocery.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

 val mGroceryModel = GroceryModelImpl

    override fun onUiReady(owner: LifecycleOwner) {
        mGroceryModel.getGroceries(
            onSuccess = {
                mView.showGroceryData(it)
            },
            onFaiure = {
                mView.showErrorMessage(it)
            }
        )
    }

}
