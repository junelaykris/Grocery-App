package com.padcx.mmz.grocery.network

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.padcx.mmz.grocery.data.vos.GroceryVO

/**
 * Created by Myint Myint Zaw on 9/24/2020.
 */
object CloudFirestoreFirebaseApiImpl : FirebaseApi {

    val db = Firebase.firestore
    override fun getGroceries(
        onSuccess: (groceries: List<GroceryVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        db.collection("groceries")
            .get()
            .addOnSuccessListener { result ->
                val groceriesList: MutableList<GroceryVO> = arrayListOf()
                for (document in result) {
                    val data = document.data
                    var grocery = GroceryVO()
                    grocery.name = data["name"] as String
                    grocery.description = data["description"] as String
                    grocery.amount = (data["amount"] as Long).toInt()
                    groceriesList.add(grocery)
                }
                onSuccess(groceriesList)
            }
            .addOnFailureListener { exception ->
                onFialure(exception.message ?: "Please check connection")
            }

    }

    override fun addGrocery(name: String, description: String, amount: Int) {

    }

    override fun deleteGrocery(name: String) {

    }

}