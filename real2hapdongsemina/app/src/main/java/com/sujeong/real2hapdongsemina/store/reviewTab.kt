package com.sujeong.real2hapdongsemina.store

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.sujeong.real2hapdongsemina.ApplicationController
import com.sujeong.real2hapdongsemina.NetworkService
import com.sujeong.real2hapdongsemina.R
import com.sujeong.real2hapdongsemina.store.get.GetReviewResponse
import com.sujeong.real2hapdongsemina.store.get.GetReviewResponseData
import com.sujeong.real2hapdongsemina.store.review_rv.ReviewAdapter
import kotlinx.android.synthetic.main.fragment_review.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class reviewTab : Fragment() {
    lateinit var networkService : NetworkService
    lateinit var reviewAdapter : ReviewAdapter
    lateinit var reviewItems : ArrayList<GetReviewResponseData>
    lateinit var requestManager : RequestManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_review, container, false)
        return v
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        getContext()
    }

    override fun onStart() {
        super.onStart()
        networkService = ApplicationController.instance.networkService
        requestManager = Glide.with(this)
        review_rv.layoutManager = LinearLayoutManager(context)
        val getReviewResponse = networkService.getReview(SharedPreferenceController.getIdx(requireContext()))
        getReviewResponse.enqueue(object : Callback<GetReviewResponse> {
            override fun onFailure(call: Call<GetReviewResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetReviewResponse>?, response: Response<GetReviewResponse>?) {
                if(response!!.isSuccessful){
                    reviewItems = response.body().result
                    reviewAdapter = ReviewAdapter(reviewItems, requestManager)
                    review_rv.adapter = reviewAdapter
                }
            }

        })
    }
}