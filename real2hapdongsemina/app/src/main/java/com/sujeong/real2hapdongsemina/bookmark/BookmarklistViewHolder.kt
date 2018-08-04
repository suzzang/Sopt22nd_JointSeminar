package com.sujeong.real2hapdongsemina.bookmark

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.sujeong.real2hapdongsemina.R
import kotlinx.android.synthetic.main.item_bookmark.*

class BookmarklistViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var bookmark_list_img : ImageView = itemView!!.findViewById(R.id.bookmark_list_img) as ImageView
    var bookmark_list_name : TextView = itemView!!.findViewById(R.id.bookmark_list_name) as TextView
    var bookmark_list_review : TextView = itemView!!.findViewById(R.id.bookmark_list_reviewnum) as TextView
}