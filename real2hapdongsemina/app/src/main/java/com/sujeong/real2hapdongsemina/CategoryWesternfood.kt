package com.sujeong.real2hapdongsemina

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.sujeong.real2hapdongsemina.get.GetMenuCategoryResponse
import com.sujeong.real2hapdongsemina.get.GetMenuCategoryResponseData
import com.sujeong.real2hapdongsemina.westernfood.WesternfoodAdapter
import kotlinx.android.synthetic.main.category_westernfood.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryWesternfood : Fragment() {
    lateinit var networkService: NetworkService
    lateinit var westernfoodAdapter: WesternfoodAdapter
    lateinit var westerItems : ArrayList<GetMenuCategoryResponseData>
    lateinit var requestManager: RequestManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.category_westernfood,container,false)

        networkService = ApplicationController.instance.networkService
        requestManager = Glide.with(this)

        v.rc_category_westernfood.layoutManager = LinearLayoutManager(context)

        val getWesternStore = networkService.getMenuList("night")
        getWesternStore.enqueue(object:Callback<GetMenuCategoryResponse>{
            override fun onFailure(call: Call<GetMenuCategoryResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetMenuCategoryResponse>?, response: Response<GetMenuCategoryResponse>?) {
                if(response!!.isSuccessful){
                    westerItems = response.body().myPosts
                    Log.v("ss",westerItems.size.toString())
                    westernfoodAdapter = WesternfoodAdapter(westerItems,requestManager)
                    v.rc_category_westernfood.adapter = westernfoodAdapter
                }
            }

        })
        return v
    }
}