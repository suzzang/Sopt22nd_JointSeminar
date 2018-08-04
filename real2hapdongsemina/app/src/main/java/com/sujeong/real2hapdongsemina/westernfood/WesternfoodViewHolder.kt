package com.sujeong.real2hapdongsemina.westernfood

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.sujeong.real2hapdongsemina.R
import kotlinx.android.synthetic.main.item_category_westernfood.view.*

class WesternfoodViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var westernfood_store_name : TextView = itemView!!.findViewById(R.id.westernfood_store_name) as TextView
    var westernfood_store_review : TextView = itemView!!.findViewById(R.id.westernfood_store_reviewnum) as TextView
    var westerfood_store_img : ImageView = itemView!!.findViewById(R.id.westernfood_store_img) as ImageView
}