package com.sujeong.real2hapdongsemina

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.sujeong.real2hapdongsemina.chicken.ChickenAdapter
import com.sujeong.real2hapdongsemina.chicken.ChickenViewHolder
import com.sujeong.real2hapdongsemina.get.GetMenuCategoryResponse
import com.sujeong.real2hapdongsemina.get.GetMenuCategoryResponseData
import com.sujeong.real2hapdongsemina.korean.KoreanfoodAdapter
import com.sujeong.real2hapdongsemina.store.StoreActivity
import kotlinx.android.synthetic.main.category_chicken.*
import kotlinx.android.synthetic.main.category_chicken.view.*
import kotlinx.android.synthetic.main.category_koreanfood.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class CategoryChicken: Fragment(), View.OnClickListener{
    ///////////////////////////////////////////<< 뷰 온클릭리쓰너 상속 >>/////////////////////////////////////////////////////////////////
    lateinit var networkService: NetworkService
    lateinit var chickenAdapter: ChickenAdapter

    lateinit var chickenItems : ArrayList<GetMenuCategoryResponseData>
    lateinit var  requestManager: RequestManager
    ///////////////////////////////////////////////////////여기부터////////////////////////////////////////////////////////////////////////////////
    override fun onClick(v: View?) {
        when(v){
            chickenItems-> {
                val intent = Intent(super.getContext(), StoreActivity::class.java)
                intent.putExtra("store_idx",chickenItems[rc_category_chicken.getChildAdapterPosition(v)].store_idx)
                intent.putExtra("store_name",chickenItems[rc_category_chicken.getChildAdapterPosition(v)].store_name)
                startActivity(intent)
            }
        }
    }
    ////////////////////////////////////////////////////////여기까지///////////////////////////////////////////////////////////////////////////////
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.category_chicken,container,false)

        networkService = ApplicationController.instance.networkService
        requestManager = Glide.with(this)

       v.rc_category_chicken.layoutManager = LinearLayoutManager(context)

        val getChickenStore = networkService.getMenuList("chicken")
        getChickenStore.enqueue(object : Callback<GetMenuCategoryResponse>{
            override fun onFailure(call: Call<GetMenuCategoryResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetMenuCategoryResponse>?, response: Response<GetMenuCategoryResponse>?) {
                if(response!!.isSuccessful){
                    chickenItems = response.body().myPosts
                    chickenAdapter = ChickenAdapter(chickenItems,requestManager)
                    ///////////////////////////////////////여기부터////////////////////////////////////////////////////////////////////////////////////////////////
                    chickenAdapter.setOnItemClickListener(this@CategoryChicken)
                    ///////////////////////////////////////여기까지////////////////////////////////////////////////////////////////////////////////////////////////
                    v.rc_category_chicken.adapter = chickenAdapter
                }
            }

        })

        return v
    }
}