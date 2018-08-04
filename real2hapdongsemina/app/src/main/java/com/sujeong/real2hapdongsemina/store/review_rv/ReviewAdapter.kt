package com.sujeong.real2hapdongsemina.store.review_rv

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.sujeong.real2hapdongsemina.R
import com.sujeong.real2hapdongsemina.store.get.GetReviewResponseData

class ReviewAdapter (var reviewItems : ArrayList<GetReviewResponseData>, var requestManager: RequestManager) : RecyclerView.Adapter<ReviewViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.review_item, parent, false)
        return ReviewViewHolder(mainView)
    }

    override fun getItemCount(): Int = reviewItems.size

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.reviewId.text = reviewItems[position].user_id
        holder.reviewDate.text = reviewItems[position].review_writetime
        requestManager.load(reviewItems[position].review_img).into(holder.reviewImg)
        holder.reviewDescr.text = reviewItems[position].review_content
    }
}