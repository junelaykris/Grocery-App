package com.padcx.mmz.grocery.data.models

import com.padcx.mmz.grocery.data.vos.GroceryVO
import com.padcx.mmz.grocery.network.FirebaseApi

interface GroceryModel {

    var mFirebaseApi : FirebaseApi

    fun getGroceries(onSuccess: (List<GroceryVO>) -> Unit, onFaiure: (String) -> Unit)
}