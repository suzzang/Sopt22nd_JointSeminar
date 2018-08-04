package com.sujeong.real2hapdongsemina

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.sujeong.real2hapdongsemina.post.PostLoginResponse
import com.sujeong.real2hapdongsemina.post.PostLoginResponseData
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var networkService: NetworkService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        networkService = ApplicationController.instance.networkService

        login_login_btn.setOnClickListener {
            postLogin()

             startActivity(Intent(applicationContext,MainActivity::class.java))
        }

        login_sign_btn.setOnClickListener {
            var intent = Intent(applicationContext, JoinActivity::class.java)
            startActivity(intent)
        }
    }

    fun postLogin(){

        var login_id = login_id_edit.text.toString()
        var login_passwd = login_pwd_edit.text.toString()

        var logindata = PostLoginResponseData(login_id,login_passwd)

        var postLoginResponse = networkService.postSignin(logindata)
        postLoginResponse.enqueue(object : Callback<PostLoginResponse> {
            override fun onFailure(call: Call<PostLoginResponse>?, t: Throwable?) {
                Toast.makeText(applicationContext,"ss",Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<PostLoginResponse>?, response: Response<PostLoginResponse>?) {
                if(response!!.isSuccessful){

                    //var idx : Int = response.body().user_idx
                    var idx : String? = login_id_edit.text.toString() //user_idx값을 안넘겨줘서 그냥 edittext값을 넘겨줌->로그인 아이디
                    var intent : Intent = Intent(applicationContext,MainActivity::class.java)
                    //Log.v("유저인덱스", idx.toString())
                    Log.v("유저아이디", idx)
                    intent.putExtra("user_id",idx)
                    startActivity(intent)//값을 넣어준 intent를 스타트해라!
                    finish()
                }

            }

        })
    }

}