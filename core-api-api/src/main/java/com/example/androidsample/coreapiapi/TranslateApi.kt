package com.example.androidsample.coreapiapi

import com.example.androidsample.coreapiapi.dto.TranslateResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TranslateApi {

    @FormUrlEncoded
    @POST("translate")
    fun translate(
        @Field("key") key: String,
        @Field("lang") lang: String,
        @Field("text") text: String
    ): Single<TranslateResponse>
}