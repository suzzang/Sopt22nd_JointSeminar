package com.sujeong.real2hapdongsemina

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.sujeong.real2hapdongsemina.bookmark.BookmarklistAdapter
import com.sujeong.real2hapdongsemina.bookmark.BookmarklistViewHolder
import com.sujeong.real2hapdongsemina.get.GetBookmarklistResponse
import com.sujeong.real2hapdongsemina.get.GetBookmarklistResponseData
import kotlinx.android.synthetic.main.main_bookmark.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainBookmark: Fragment() {
    lateinit var networkService: NetworkService
    lateinit var bookmarklistAdapter: BookmarklistAdapter
    lateinit var bookmarklistViewHolder: BookmarklistViewHolder
    lateinit var bookmarklistItems : ArrayList<GetBookmarklistResponseData>
    lateinit var  requestManager: RequestManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.main_bookmark,container,false)

        var user_id : String = arguments!!.getString("user_id")
        Log.v("뜨냐,",user_id)
        networkService = ApplicationController.instance.networkService
        requestManager = Glide.with(this)
        v.rc_bookmarklist.layoutManager = LinearLayoutManager(context)


        val getBookmarklist = networkService.getBookmarklist(user_id)
        getBookmarklist.enqueue(object : Callback<GetBookmarklistResponse>{
            override fun onFailure(call: Call<GetBookmarklistResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetBookmarklistResponse>?, response: Response<GetBookmarklistResponse>?) {

                if(response!!.isSuccessful){
                   // Log.v("유저인덱스",arg.getString("user_idx"))
                    bookmarklistItems = response.body().list
                    bookmarklistAdapter = BookmarklistAdapter(bookmarklistItems,requestManager)
                    v.rc_bookmarklist.adapter = bookmarklistAdapter

                }
            }

        })
        return v
    }
}