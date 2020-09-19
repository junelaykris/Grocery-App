package com.padcx.mmz.grocery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.grocery.R
import com.padcx.mmz.grocery.data.vos.GroceryVO
import com.padcx.mmz.grocery.delegates.GroceryViewItemActionDelegate
import com.padcx.mmz.grocery.viewholders.GroceryViewHolder

class GroceryAdapter(private val mDelegate: GroceryViewItemActionDelegate) : BaseRecyclerAdapter<GroceryViewHolder, GroceryVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_grocery_item,parent,false)
        return GroceryViewHolder(view,mDelegate)
    }
}