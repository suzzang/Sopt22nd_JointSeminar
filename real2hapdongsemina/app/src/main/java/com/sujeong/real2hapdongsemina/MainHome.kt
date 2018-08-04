package com.sujeong.real2hapdongsemina

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_home.*
import kotlinx.android.synthetic.main.main_home.view.*

class MainHome : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0) {
            btn_main_koreanfood -> {
                replaceFragment(CategoryKorean())
            }
            btn_main_chicken -> {
                replaceFragment(CategoryChicken())
            }
            btn_main_pizza -> {
                replaceFragment(CategoryPizza())
            }
            btn_main_westernfood -> {
                replaceFragment(CategoryWesternfood())
            }

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.main_home, container, false)
        v.btn_main_koreanfood.setOnClickListener(this)
        v.btn_main_chicken.setOnClickListener(this)
        v.btn_main_pizza.setOnClickListener(this)
        v.btn_main_westernfood.setOnClickListener(this)
        return v
    }

    fun replaceFragment(fragment: Fragment) {
        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()

        transaction.addToBackStack(null)//백버튼 눌렀을때 전에 방문했던 프래그먼트들이 지워지지않고 그 프래그먼트로 돌아가게됨.
        transaction.replace(R.id.main_frame, fragment)
        transaction.commit()
    }
}