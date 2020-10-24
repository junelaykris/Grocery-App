package com.padcx.mmz.groceryapp.data.models

import android.graphics.Bitmap
import com.padcx.mmz.groceryapp.data.vos.GroceryVO
import com.padcx.mmz.groceryapp.network.FirebaseApi
import com.padcx.mmz.groceryapp.network.remoteConfig.FirebaseRemoteConfigManager

interface GroceryModel {

    var mFirebaseApi : FirebaseApi
    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager

    fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFaiure: (String) -> Unit)

    fun addGrocery(name: String ,description : String, amount: Int, image: String)

    fun removeGrocery(name: String)

   /* fun editGrocery(name: String, description: String, amount: Int)*/

    fun uploadImageAndUpdateGrocery(grocery : GroceryVO, image : Bitmap)


    fun setRemoteConfigWithDefaultValues()

    fun fetchRemoteConfig()

    fun getAppNameFromRemoteConfig() : String

    fun setRemoteConfigValueForRecyclerView()

    fun fetchRemoteConfigForRecyclerView()

    fun getRecyclerViewLayoutValue() :String
}