package com.padcx.mmz.grocery.data.models
import com.padcx.mmz.grocery.data.vos.GroceryVO
import com.padcx.mmz.grocery.network.CloudFirestoreFirebaseApiImpl
import com.padcx.mmz.grocery.network.FirebaseApi
import com.padcx.mmz.grocery.network.RealtimeDatabaseFirebaseApiImpl


object GroceryModelImpl : GroceryModel {
   /* override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl*/

    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFaiure: (String) -> Unit) {
        mFirebaseApi.getGroceries(onSuccess, onFaiure)
    }

    override fun addGrocery(name: String, description: String, amount: Int) {
        mFirebaseApi.addGrocery(name, description, amount)
    }

    override fun removeGrocery(name: String) {
        mFirebaseApi.deleteGrocery(name)
    }

    override fun editGrocery(name: String, description: String, amount: Int) {

    }
}
