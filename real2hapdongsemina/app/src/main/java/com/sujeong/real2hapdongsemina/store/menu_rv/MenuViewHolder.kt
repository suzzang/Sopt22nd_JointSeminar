package com.sujeong.real2hapdongsemina.store.menu_rv

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.sujeong.real2hapdongsemina.R

class MenuViewHolder(itemView : View?) : RecyclerView.ViewHolder(itemView){
    var menuName : TextView = itemView!!.findViewById(R.id.item_tv_name) as TextView
    var menuPrice : TextView = itemView!!.findViewById(R.id.item_tv_price) as TextView
}