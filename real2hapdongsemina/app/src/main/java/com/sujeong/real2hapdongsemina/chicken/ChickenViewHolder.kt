package com.sujeong.real2hapdongsemina.chicken

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.sujeong.real2hapdongsemina.R
import kotlinx.android.synthetic.main.item_category_chicken.view.*

class ChickenViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var chicken_store_img : ImageView = itemView!!.findViewById(R.id.chicken_store_img) as ImageView
    var chicken_store_name : TextView = itemView!!.findViewById(R.id.chicken_store_name) as TextView
    var chicken_store_review : TextView = itemView!!.findViewById(R.id.chicken_store_reviewnum) as TextView

}