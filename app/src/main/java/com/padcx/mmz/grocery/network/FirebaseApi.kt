package com.padcx.mmz.grocery.network

import com.padcx.mmz.grocery.data.vos.GroceryVO


interface FirebaseApi {
    fun getGroceries(onSuccess: (groceries: List<GroceryVO>) -> Unit, onFialure: (String) -> Unit)
    fun addGrocery(name: String, description: String, amount: Int)
}