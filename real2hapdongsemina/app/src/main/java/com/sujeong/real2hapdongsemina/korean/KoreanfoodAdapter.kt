package com.sujeong.real2hapdongsemina.korean

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.sujeong.real2hapdongsemina.R
import com.sujeong.real2hapdongsemina.get.GetMenuCategoryResponseData

class KoreanfoodAdapter(var menuCategoryItems : ArrayList<GetMenuCategoryResponseData>, var requestManager: RequestManager) : RecyclerView.Adapter<KoreanfoodViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KoreanfoodViewHolder {
        var mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_category_koreanfood,parent,false)

        //mainView.setOnClickListener()
        return KoreanfoodViewHolder(mainView)
    }

    override fun getItemCount(): Int =menuCategoryItems.size

    override fun onBindViewHolder(holder: KoreanfoodViewHolder, position: Int) {
        holder.c_koreanfood_title.text = menuCategoryItems[position].store_name
        holder.c_koreanfod_review.text = menuCategoryItems[position].review_cnt.toString()

        requestManager.load(menuCategoryItems[position].store_img)
                .into(holder.c_koreanfood_img)


    }
}