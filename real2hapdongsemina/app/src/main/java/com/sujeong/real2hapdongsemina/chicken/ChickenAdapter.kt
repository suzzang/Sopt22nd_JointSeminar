package com.sujeong.real2hapdongsemina.chicken

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.sujeong.real2hapdongsemina.R
import com.sujeong.real2hapdongsemina.get.GetMenuCategoryResponseData

class ChickenAdapter(var chickenItem : ArrayList<GetMenuCategoryResponseData>,var requestManager: RequestManager) : RecyclerView.Adapter<ChickenViewHolder>() {
    ////////////////////////////////////////////////////// 여기부터 /////////////////////////////////////////////////////////////////////////////////
    private lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(l:View.OnClickListener){
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChickenViewHolder {
        var mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_category_chicken,parent,false)

        mainView.setOnClickListener(onItemClick)

        return ChickenViewHolder(mainView)
    }
    //////////////////////////////////////////////////// 여기까지 ///////////////////////////////////////////////////////////////////////////////////

    override fun getItemCount(): Int = chickenItem.size

    override fun onBindViewHolder(holder: ChickenViewHolder, position: Int) {
        holder.chicken_store_name.text = chickenItem[position].store_name
        holder.chicken_store_review.text = chickenItem[position].review_cnt.toString()

        requestManager.load(chickenItem[position].store_img).into(holder.chicken_store_img)

    }
}