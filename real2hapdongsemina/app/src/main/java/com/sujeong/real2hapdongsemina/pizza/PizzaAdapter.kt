package com.sujeong.real2hapdongsemina.pizza

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.sujeong.real2hapdongsemina.R
import com.sujeong.real2hapdongsemina.get.GetMenuCategoryResponseData

class PizzaAdapter(var pizzaItems : ArrayList<GetMenuCategoryResponseData>,var requestManager: RequestManager):RecyclerView.Adapter<PizzaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        var mainView = LayoutInflater.from(parent.context).inflate(R.layout.item_category_pizza,parent,false)
        return PizzaViewHolder(mainView)
    }

    override fun getItemCount(): Int = pizzaItems.size

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.pizza_store_name.text = pizzaItems[position].store_name
        holder.pizza_store_review.text = pizzaItems[position].review_cnt.toString()

        requestManager.load(pizzaItems[position].store_img).into(holder.pizza_store_img)
    }
}