package com.sujeong.real2hapdongsemina.store

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sujeong.real2hapdongsemina.ApplicationController
import com.sujeong.real2hapdongsemina.NetworkService
import com.sujeong.real2hapdongsemina.R
import com.sujeong.real2hapdongsemina.store.get.GetMenuResponse
import com.sujeong.real2hapdongsemina.store.get.GetMenuResponseData
import com.sujeong.real2hapdongsemina.store.menu_rv.MenuAdapter
import kotlinx.android.synthetic.main.fragment_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class menuTab : Fragment(){
    lateinit var networkService : NetworkService
    lateinit var  menuAdapter : MenuAdapter
    lateinit var menuItems : ArrayList<GetMenuResponseData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_menu, container, false)
        return v
    }
    override fun onStart() {
        super.onStart()
        networkService = ApplicationController.instance.networkService
        menu_rv.layoutManager = LinearLayoutManager(context)
        val getMenuResponse = networkService.getMenu(SharedPreferenceController.getIdx(requireContext()))
        getMenuResponse.enqueue(object : Callback<GetMenuResponse> {
            override fun onFailure(call: Call<GetMenuResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetMenuResponse>?, response: Response<GetMenuResponse>?) {
                if(response!!.isSuccessful){
                    menuItems = response.body().result
                    menuAdapter = MenuAdapter(menuItems)
                    menu_rv.adapter = menuAdapter
                }
            }

        })
    }
}