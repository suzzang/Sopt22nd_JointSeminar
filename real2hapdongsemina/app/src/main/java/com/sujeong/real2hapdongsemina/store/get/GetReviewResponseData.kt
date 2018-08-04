package com.sujeong.real2hapdongsemina.store.get

data class GetReviewResponseData (
    var review_idx : Int,
    var store_idx : Int,
    var user_id : String?,
    var review_content : String?,
    var review_writetime : String?,
    var review_img : String?
)