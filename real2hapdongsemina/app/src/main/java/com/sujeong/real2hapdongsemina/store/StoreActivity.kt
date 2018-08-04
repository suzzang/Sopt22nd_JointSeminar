package com.sujeong.real2hapdongsemina.store

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.sujeong.real2hapdongsemina.R
import kotlinx.android.synthetic.main.activity_store.*

class StoreActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        addFragment(menuTab())
        main_btn_menu.isSelected = true
        main_btn_menu.setOnClickListener(this)
        main_btn_info.setOnClickListener(this)
        main_btn_review.setOnClickListener(this)
        main_btn_bookmark.setOnClickListener(this)

        SharedPreferenceController.setIdx(this, intent.getIntExtra("store_idx",0))
        SharedPreferenceController.setName(this, intent.getStringExtra("store_name"))
        main_tv_title.text = SharedPreferenceController.getName(this)
    }
    override fun onClick(v: View?) {
        when(v){
            main_btn_menu -> {
                replaceFragment(menuTab())
                main_btn_menu.isSelected = true
                main_btn_info.isSelected = false
                main_btn_review.isSelected = false
            }
            main_btn_info -> {
                replaceFragment(infoTab())
                main_btn_menu.isSelected = false
                main_btn_info.isSelected = true
                main_btn_review.isSelected = false
            }
            main_btn_review -> {
                replaceFragment(reviewTab())
                main_btn_menu.isSelected = false
                main_btn_info.isSelected = false
                main_btn_review.isSelected = true
            }
            main_btn_bookmark -> {
                if(main_btn_bookmark.isSelected) {
                    main_btn_bookmark.isSelected = false
                }else {
                    main_btn_bookmark.isSelected = true
                }
            }
        }
    }

    fun addFragment(fragment: Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_frame, fragment)
        transaction.commit()
    }
    fun replaceFragment(fragment: Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
