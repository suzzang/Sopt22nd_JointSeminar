package com.sujeong.real2hapdongsemina.store.menu_rv

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sujeong.real2hapdongsemina.R
import com.sujeong.real2hapdongsemina.store.get.GetMenuResponseData

class MenuAdapter (var menuItems : ArrayList<GetMenuResponseData>) : RecyclerView.Adapter<MenuViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return MenuViewHolder(mainView)
    }

    override fun getItemCount(): Int = menuItems.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.menuName.text = menuItems[position].menu_name
        holder.menuPrice.text = menuItems[position].menu_info
    }
}