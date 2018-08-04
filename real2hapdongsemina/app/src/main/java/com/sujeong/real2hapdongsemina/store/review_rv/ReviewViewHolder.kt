package com.sujeong.real2hapdongsemina.store.review_rv

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.sujeong.real2hapdongsemina.R

class ReviewViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView){
    var reviewId : TextView = itemView!!.findViewById(R.id.item_tv_id) as TextView
    var reviewDate : TextView = itemView!!.findViewById(R.id.item_tv_date) as TextView
    var reviewImg : ImageView = itemView!!.findViewById(R.id.item_iv_img) as ImageView
    var reviewDescr : TextView = itemView!!.findViewById(R.id.item_tv_descr) as TextView
}