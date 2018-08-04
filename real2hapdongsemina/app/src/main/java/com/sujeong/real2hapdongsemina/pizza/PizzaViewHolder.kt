package com.sujeong.real2hapdongsemina.pizza

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.sujeong.real2hapdongsemina.R
import kotlinx.android.synthetic.main.item_category_pizza.view.*

class PizzaViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var pizza_store_name : TextView = itemView!!.findViewById(R.id.pizza_store_name) as TextView
    var pizza_store_review : TextView = itemView!!.findViewById(R.id.pizza_store_reviewnum) as TextView
    var pizza_store_img : ImageView = itemView!!.findViewById(R.id.pizza_store_img) as ImageView
}