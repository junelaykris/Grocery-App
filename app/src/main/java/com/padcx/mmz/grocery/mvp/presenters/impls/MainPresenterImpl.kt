package com.padcx.mmz.grocery.mvp.presenters.impls

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import com.padcx.mmz.grocery.data.models.AuthenticationModel
import com.padcx.mmz.grocery.data.models.AuthenticationModelImpl
import com.padcx.mmz.grocery.data.models.GroceryModelImpl
import com.padcx.mmz.grocery.data.vos.GroceryVO
import com.padcx.mmz.grocery.mvp.presenters.AbstractBasePresenter
import com.padcx.mmz.grocery.mvp.presenters.MainPresenter
import com.padcx.mmz.grocery.mvp.views.MainView

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private val mGroceryModel = GroceryModelImpl

    private var mChosenGroceryForFileUpload: GroceryVO? = null

    private val mAuthenticatioModel: AuthenticationModel = AuthenticationModelImpl

      override fun onTapAddGroceryWithoutImage(name: String, description: String, amount: Int,image:String) {
          mGroceryModel.addGrocery(name, description, amount, image)
      }

    override fun onTapAddGrocery(groceryVO: GroceryVO, bitmap: Bitmap) {
        mGroceryModel.uploadImageAndUpdateGrocery(groceryVO,bitmap)
    }

    override fun onPhotoTaken(bitmap: Bitmap) {
        mChosenGroceryForFileUpload?.let {
            mGroceryModel.uploadImageAndUpdateGrocery(it, bitmap)
        }
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
        mView.showUserName(mAuthenticatioModel.getUserName())
    }

    override fun onTapDeleteGrocery(name: String) {
        mGroceryModel.removeGrocery(name)
    }

    override fun onTapEditGrocery(name: String, description: String, amount: Int,image:String) {
        mView.showGroceryDialog(name, description, amount.toString(),image)
    }

    override fun onTapFileUpload(grocery: GroceryVO) {
        mChosenGroceryForFileUpload = grocery
        mView.openGallery();
    }


}
