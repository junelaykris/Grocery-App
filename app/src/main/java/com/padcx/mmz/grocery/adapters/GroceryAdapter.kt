package com.padcx.mmz.grocery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.grocery.R
import com.padcx.mmz.grocery.viewholders.GroceryViewHolder
import com.padcx.mmz.grocery.vos.GroceryVO

class GroceryAdapter() : BaseRecyclerAdapter<GroceryViewHolder, GroceryVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_grocery_item,parent,false)
        return GroceryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {

    }
}