package com.padcx.mmz.grocery.network

import com.padcx.mmz.grocery.data.vos.GroceryVO

/**
 * Created by Myint Myint Zaw on 9/24/2020.
 */
class CloudFirestoreFirebaseApiImpl : FirebaseApi {
    override fun getGroceries(
        onSuccess: (groceries: List<GroceryVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {

    }

    override fun addGrocery(name: String, description: String, amount: Int) {

    }

    override fun deleteGrocery(name: String) {

    }

}