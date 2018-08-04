package com.sujeong.real2hapdongsemina

import com.sujeong.real2hapdongsemina.get.GetBookmarklistResponse
import com.sujeong.real2hapdongsemina.get.GetMenuCategoryResponse
import com.sujeong.real2hapdongsemina.post.PostJoinResponse
import com.sujeong.real2hapdongsemina.post.PostJoinResponseData
import com.sujeong.real2hapdongsemina.post.PostLoginResponse
import com.sujeong.real2hapdongsemina.post.PostLoginResponseData
import com.sujeong.real2hapdongsemina.store.get.GetMenuResponse
import com.sujeong.real2hapdongsemina.store.get.GetReviewResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkService {
    @GET("main/list/{category}")
    fun getMenuList(@Path("category") category: String) : Call<GetMenuCategoryResponse>

    @GET("/bookmark/list/{user_id}")
    fun getBookmarklist(@Path("user_id") user_id: String) :Call<GetBookmarklistResponse>

    @POST("user/signin")
    fun postSignin(@Body login : PostLoginResponseData) :Call<PostLoginResponse>

    @GET("store/menulist/{store_idx}")
    fun getMenu(@Path("store_idx") idx : Int) : Call<GetMenuResponse>

    @GET("store/review/{store_idx}")
    fun getReview(@Path("store_idx") idx : Int) : Call<GetReviewResponse>

    @POST("user/signup")
    fun postJoin(@Body sign : PostJoinResponseData) :Call<PostJoinResponse>
}