package com.padcx.mmz.groceryapp.data.models
import android.graphics.Bitmap
import com.padcx.mmz.groceryapp.data.vos.GroceryVO
import com.padcx.mmz.groceryapp.network.CloudFirestoreFirebaseApiImpl
import com.padcx.mmz.groceryapp.network.FirebaseApi
import com.padcx.mmz.groceryapp.network.remoteConfig.FirebaseRemoteConfigManager


object GroceryModelImpl : GroceryModel {
  /*  override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl*/

    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl
    override var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager


    override fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFaiure: (String) -> Unit) {
        mFirebaseApi.getGroceries(onSuccess, onFaiure)
    }

    override fun addGrocery(name: String, description: String, amount: Int, image: String) {
        mFirebaseApi.addGrocery(name, description, amount, image)
    }

    override fun removeGrocery(name: String) {
        mFirebaseApi.deleteGrocery(name)
    }

    override fun uploadImageAndUpdateGrocery(grocery: GroceryVO, image: Bitmap) {
        mFirebaseApi.uploadImageAndEditGrocery(image, grocery)
    }

    override fun setRemoteConfigWithDefaultValues() {
        mFirebaseRemoteConfigManager.setUpRemoteConfigWithDefaultValues()
    }

    override fun fetchRemoteConfig() {
        mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }

    override fun getAppNameFromRemoteConfig(): String {
        return mFirebaseRemoteConfigManager.getToolbarName()
    }

    override fun setRemoteConfigValueForRecyclerView() {
        mFirebaseRemoteConfigManager.setUpRecyclerLayoutValue()
    }

    override fun fetchRemoteConfigForRecyclerView() {
        mFirebaseRemoteConfigManager.fetchRemoteConfigForRecyclerValue()
    }

    override fun getRecyclerViewLayoutValue(): String {
        return  mFirebaseRemoteConfigManager.getRecyclerViewLayout()
    }

}
