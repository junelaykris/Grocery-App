package com.padcx.mmz.grocery.viewholders

import android.view.View
import com.padcx.mmz.grocery.data.vos.GroceryVO
import kotlinx.android.synthetic.main.view_holder_grocery_item.view.*

class GroceryViewHolder(itemView: View) : BaseViewHolder<GroceryVO>(itemView) {

    override fun bindData(data: GroceryVO) {
        itemView.tvTitle.text = data.name
        itemView.tvDescription.text = data.description
        itemView.tvCount.text = "x ${data.amount.toString()}"
    }
}