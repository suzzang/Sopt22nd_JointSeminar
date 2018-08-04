package com.sujeong.real2hapdongsemina.korean

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.sujeong.real2hapdongsemina.R

class KoreanfoodViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var c_koreanfood_img : ImageView =  itemView!!.findViewById(R.id.koreanfood_store_img) as ImageView
    var c_koreanfood_title : TextView = itemView!!.findViewById(R.id.koreanfood_store_name) as TextView
    var c_koreanfod_review : TextView = itemView!!.findViewById(R.id.koreanfood_store_reviewnum) as TextView
}