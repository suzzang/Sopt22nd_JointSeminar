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
import com.sujeong.real2hapdongsemina.pizza.PizzaAdapter
import kotlinx.android.synthetic.main.category_pizza.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryPizza: Fragment() {
    lateinit var networkService: NetworkService
    lateinit var pizzaAdapter: PizzaAdapter
    lateinit var pizzaItems : ArrayList<GetMenuCategoryResponseData>
    lateinit var requestManager: RequestManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.category_pizza,container,false)
        networkService = ApplicationController.instance.networkService
        requestManager = Glide.with(this)

        v.rc_category_pizza.layoutManager = LinearLayoutManager(context)

        val getPizzaStore = networkService.getMenuList("pizza")
        getPizzaStore.enqueue(object : Callback<GetMenuCategoryResponse>{
            override fun onFailure(call: Call<GetMenuCategoryResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetMenuCategoryResponse>?, response: Response<GetMenuCategoryResponse>?) {
              if(response!!.isSuccessful){
                  pizzaItems = response.body().myPosts
                  pizzaAdapter = PizzaAdapter(pizzaItems,requestManager)
                  v.rc_category_pizza.adapter = pizzaAdapter
              }
            }

        })

        return v
    }
}