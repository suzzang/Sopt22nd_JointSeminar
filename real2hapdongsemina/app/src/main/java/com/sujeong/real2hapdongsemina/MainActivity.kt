package com.sujeong.real2hapdongsemina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val bundle = Bundle()
//    override fun onClick(p0: View?) {
//        when(p0){
//            btn_maintab_home->{
//                replaceFragment(MainHome())
//                bundle.putString("user_idx",user_idx.to)
//            }
//            btn_maintab_bookmark->{
//                replaceFragment(MainBookmark())
//            }
//
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(MainHome())


        var user_id = intent.getStringExtra("user_id")
       // Log.v("유저인덱스2",user_idx.toString())
        Log.v("메인으로넘겨진 유저아디",user_id)

        btn_maintab_home.setOnClickListener{

            replaceFragment(MainHome())
            //bundle.putString("user_idx",user_idx.toString())

        }
        btn_maintab_bookmark.setOnClickListener{

            bundle.putString("user_id",user_id)
           // MainBookmark().arguments = bundle

            replaceFragment(MainBookmark())


        }
    }

    fun addFragment(fragment: Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()

        transaction.add(R.id.main_frame,fragment)
        transaction.commit()

    }
    fun replaceFragment(fragment: android.support.v4.app.Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()


        fragment.arguments = bundle
        transaction.replace(R.id.main_frame,fragment)
        transaction.commit()
    }
}
