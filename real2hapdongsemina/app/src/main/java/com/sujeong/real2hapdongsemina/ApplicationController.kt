package com.sujeong.real2hapdongsemina

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationController :Application() {
    lateinit var networkService: NetworkService
    private val baseUrl = "http://13.124.11.199:3000/"
    companion object {
        lateinit var instance : ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwourk()
    }
    fun buildNetwourk(){
        val builder = Retrofit.Builder()
        var retrofit = builder.baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        networkService = retrofit.create(NetworkService::class.java)
    }
}