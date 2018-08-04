package com.sujeong.real2hapdongsemina

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.sujeong.real2hapdongsemina.get.GetMenuCategoryResponse
import com.sujeong.real2hapdongsemina.get.GetMenuCategoryResponseData
import com.sujeong.real2hapdongsemina.korean.KoreanfoodAdapter
import kotlinx.android.synthetic.main.category_koreanfood.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryKorean:Fragment() {
    lateinit var networkService: NetworkService
    lateinit var koreanfoodAdapter: KoreanfoodAdapter
    lateinit var menuCategoryItems :ArrayList<GetMenuCategoryResponseData>
    lateinit var  requestManager: RequestManager


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.category_koreanfood,container,false)

        networkService = ApplicationController.instance.networkService
        requestManager = Glide.with(this)



        v.rc_category_koreanfood.layoutManager = LinearLayoutManager(context)//java에선 getContext였는데 kotlin에서는 그냥 context!,게다가 프래그먼트니까 v붙이는거 잊지말기!

        val getKoreanFoodStore = networkService.getMenuList("korean")
        getKoreanFoodStore.enqueue(object : Callback<GetMenuCategoryResponse> {
            override fun onFailure(call: Call<GetMenuCategoryResponse>?, t: Throwable?) {

            }
            override fun onResponse(call: Call<GetMenuCategoryResponse>?, response: Response<GetMenuCategoryResponse>?) {
                if(response!!.isSuccessful){
                    //Toast.makeText(context,"dd",Toast.LENGTH_SHORT).show()
                    menuCategoryItems = response.body().myPosts
                    koreanfoodAdapter = KoreanfoodAdapter(menuCategoryItems,requestManager)
                    v.rc_category_koreanfood.adapter = koreanfoodAdapter//얘도 프래그먼트니까 v.붙이는거 잊지말기!

                }

            }

        })

        return v


    }
}