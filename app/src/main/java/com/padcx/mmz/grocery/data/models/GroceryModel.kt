package com.padcx.mmz.grocery.data.models

import android.graphics.Bitmap
import com.padcx.mmz.grocery.data.vos.GroceryVO
import com.padcx.mmz.grocery.network.FirebaseApi

interface GroceryModel {

    var mFirebaseApi : FirebaseApi

    fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFaiure: (String) -> Unit)

    fun addGrocery(name: String ,description : String, amount: Int, image: String)

    fun removeGrocery(name: String)

   /* fun editGrocery(name: String, description: String, amount: Int)*/

    fun uploadImageAndUpdateGrocery(grocery : GroceryVO, image : Bitmap)
}