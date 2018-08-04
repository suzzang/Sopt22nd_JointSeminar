package com.sujeong.real2hapdongsemina.bookmark

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.bumptech.glide.RequestManager
import com.sujeong.real2hapdongsemina.R
import com.sujeong.real2hapdongsemina.get.GetBookmarklistResponseData
import kotlinx.android.synthetic.main.main_bookmark.view.*

class BookmarklistAdapter(var bookmarklistItems : ArrayList<GetBookmarklistResponseData>,var requestManager: RequestManager) : RecyclerView.Adapter<BookmarklistViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarklistViewHolder {
        var mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_bookmark,parent,false)

        return BookmarklistViewHolder(mainView)
    }

    override fun getItemCount(): Int = bookmarklistItems.size
    override fun onBindViewHolder(holder: BookmarklistViewHolder, position: Int) {
        holder.bookmark_list_name.text = bookmarklistItems[position].store_name
        holder.bookmark_list_review.text = bookmarklistItems[position].reviewCnt.toString()

        requestManager.load(bookmarklistItems[position].store_img).into(holder.bookmark_list_img)
    }
}