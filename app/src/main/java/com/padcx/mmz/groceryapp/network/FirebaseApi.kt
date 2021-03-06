package com.padcx.mmz.groceryapp.network

import android.graphics.Bitmap
import com.padcx.mmz.groceryapp.data.vos.GroceryVO


interface FirebaseApi {
    fun getGroceries(onSuccess: (groceries: List<GroceryVO>) -> Unit, onFialure: (String) -> Unit)
    fun addGrocery(name: String, description: String, amount: Int, image: String)
    fun deleteGrocery(name: String)
    fun uploadImageAndEditGrocery(image : Bitmap, grocery: GroceryVO)
}