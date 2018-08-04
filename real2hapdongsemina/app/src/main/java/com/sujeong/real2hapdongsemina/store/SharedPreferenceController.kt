package com.sujeong.real2hapdongsemina.store

import android.content.Context

object SharedPreferenceController {
    private val STORE_IDX : String = "id"
    private val STORE_NAME : String = "name"

    fun setIdx(context : Context, idx : Int){
        val pref = context.getSharedPreferences("STORE", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putInt(STORE_IDX, idx)
        editor.apply()
    }

    fun getIdx(context : Context): Int{
        val pref = context.getSharedPreferences("STORE", Context.MODE_PRIVATE)
        return pref.getInt(STORE_IDX, 0)
    }

    fun setName(context : Context, name : String){
        val pref = context.getSharedPreferences("STORE", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString(STORE_NAME, name)
        editor.apply()
    }

    fun getName(context : Context) : String{
        val pref = context.getSharedPreferences("STORE", Context.MODE_PRIVATE)
        return pref.getString(STORE_NAME, "")
    }

    fun clearSPC(context : Context){
        val pref = context.getSharedPreferences("STORE", Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.apply()
        //SharedPreference에 저장된 데이터 정리
    }

}