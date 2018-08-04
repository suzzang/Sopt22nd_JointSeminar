package com.sujeong.real2hapdongsemina.westernfood

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.sujeong.real2hapdongsemina.R
import com.sujeong.real2hapdongsemina.get.GetMenuCategoryResponseData

class WesternfoodAdapter(var westernfoodItems : ArrayList<GetMenuCategoryResponseData>,var requestManager: RequestManager):RecyclerView.Adapter<WesternfoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WesternfoodViewHolder {
        var mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_category_westernfood,parent,false)
        return WesternfoodViewHolder(mainView)
    }

    override fun getItemCount(): Int = westernfoodItems.size

    override fun onBindViewHolder(holder: WesternfoodViewHolder, position: Int) {
        holder.westernfood_store_name.text = westernfoodItems[position].store_name
        holder.westernfood_store_review.text = westernfoodItems[position].review_cnt.toString()

        requestManager.load(westernfoodItems[position].store_img).into(holder.westerfood_store_img)
    }
}