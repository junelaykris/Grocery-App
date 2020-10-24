package com.padcx.mmz.groceryapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mmz.groceryapp.R
import com.padcx.mmz.groceryapp.data.vos.GroceryVO
import com.padcx.mmz.groceryapp.delegates.GroceryViewItemActionDelegate
import com.padcx.mmz.groceryapp.viewholders.GroceryViewHolder

class GroceryAdapter(private val mDelegate: GroceryViewItemActionDelegate, private val viewTypes: Int) : BaseRecyclerAdapter<GroceryViewHolder, GroceryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        when (viewTypes) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_grocery_item, parent, false)
                return GroceryViewHolder(view, mDelegate)
            }
            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.viewholder_grocery_item_grid, parent, false)
                return GroceryViewHolder(view, mDelegate)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.viewholder_grocery_item_grid, parent, false)
                return GroceryViewHolder(view, mDelegate)
            }
        }
    }
}