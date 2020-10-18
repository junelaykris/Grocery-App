package com.padcx.mmz.grocery.data.models
import android.graphics.Bitmap
import com.padcx.mmz.grocery.data.vos.GroceryVO
import com.padcx.mmz.grocery.network.CloudFirestoreFirebaseApiImpl
import com.padcx.mmz.grocery.network.FirebaseApi
import com.padcx.mmz.grocery.network.RealtimeDatabaseFirebaseApiImpl


object GroceryModelImpl : GroceryModel {
  /*  override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl*/

    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

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

}
