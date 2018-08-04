package com.sujeong.real2hapdongsemina.Splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.sujeong.real2hapdongsemina.LoginActivity
import com.sujeong.real2hapdongsemina.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }, 1000)
    }
}
