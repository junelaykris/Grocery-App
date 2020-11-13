package com.padcx.mmz.groceryapp.mvp.presenters.impls

import android.content.Context
import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.groceryapp.analytics.SCREEN_HOME
import com.padcx.mmz.groceryapp.data.models.AuthenticationModel
import com.padcx.mmz.groceryapp.data.models.AuthenticationModelImpl
import com.padcx.mmz.groceryapp.data.models.GroceryModelImpl
import com.padcx.mmz.groceryapp.data.vos.GroceryVO
import com.padcx.mmz.groceryapp.mvp.presenters.AbstractBasePresenter
import com.padcx.mmz.groceryapp.mvp.presenters.MainPresenter
import com.padcx.mmz.groceryapp.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mGroceryModel = GroceryModelImpl

    private var mChosenGroceryForFileUpload: GroceryVO? = null

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapAddGroceryWithoutImage(
        name: String,
        description: String,
        amount: Int,
        image: String
    ) {
        mGroceryModel.addGrocery(name, description, amount, image)
    }

    override fun onTapAddGrocery(groceryVO: GroceryVO, bitmap: Bitmap) {
        mGroceryModel.uploadImageAndUpdateGrocery(groceryVO, bitmap)
    }

    override fun onPhotoTaken(bitmap: Bitmap) {
        mChosenGroceryForFileUpload?.let {
            mGroceryModel.uploadImageAndUpdateGrocery(it, bitmap)
        }
    }

    override fun onUiReady(context: Context, owner: LifecycleOwner) {

        sendEventsToFirebaseAnalytics(context, SCREEN_HOME)
        mView.showUserName(mAuthenticationModel.getUserName())

        mView.displayToolbarTitle(mGroceryModel.getAppNameFromRemoteConfig())

        val layoutType = mGroceryModel.getRecyclerViewLayoutValue()
        mView.showRecyclerTypeLayout(layoutType)

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

    override fun onTapEditGrocery(name: String, description: String, amount: Int, image: String) {
        mView.showGroceryDialog(name, description, amount.toString(), image)
    }

    override fun onTapFileUpload(grocery: GroceryVO) {
        mChosenGroceryForFileUpload = grocery
        mView.openGallery()
    }
    
}
