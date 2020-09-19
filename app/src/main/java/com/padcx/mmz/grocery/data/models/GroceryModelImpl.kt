package com.padcx.mmz.grocery.data.models
import com.padcx.mmz.grocery.data.vos.GroceryVO
import com.padcx.mmz.grocery.network.FirebaseApi
import com.padcx.mmz.grocery.network.RealtimeDatabaseFirebaseApiImpl


object GroceryModelImpl : GroceryModel {
    override var mFirebaseApi: FirebaseApi = RealtimeDatabaseFirebaseApiImpl

    override fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFaiure: (String) -> Unit) {
        mFirebaseApi.getGroceries(onSuccess, onFaiure)
    }
}
