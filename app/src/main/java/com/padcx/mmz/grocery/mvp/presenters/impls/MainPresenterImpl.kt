package com.padcx.mmz.grocery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.grocery.data.models.GroceryModelImpl
import com.padcx.mmz.grocery.mvp.presenters.AbstractBasePresenter
import com.padcx.mmz.grocery.mvp.presenters.MainPresenter
import com.padcx.mmz.grocery.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mGroceryModel = GroceryModelImpl

    override fun onTapAddGrocery(name: String, description: String, amount: Int) {
        mGroceryModel.addGrocery(name,description,amount)
    }

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

    override fun onTapDeleteGrocery(name: String) {
        mGroceryModel.removeGrocery(name)
    }

    override fun onTapEditGrocery(name: String, description: String, amount: Int) {
        mView.showGroceryDialog(name, description, amount.toString())
    }


}
