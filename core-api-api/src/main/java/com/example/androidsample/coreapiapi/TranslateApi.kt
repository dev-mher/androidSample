package com.example.androidsample.coreapiapi

import com.example.androidsample.coreapiapi.dto.LanguagesResponse
import com.example.androidsample.coreapiapi.dto.TranslateResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TranslateApi {

    @GET("https://translate.yandex.net/api/v1.5/tr.json/detect")
    fun getLanguages(): Single<LanguagesResponse>

    @POST("https://translate.yandex.net/api/v1.5/tr.json/translate")
    fun translate(
        @Query("key") key: String,
        @Query("lang") lang: String,
        @Query("text") text: String
    ): Single<TranslateResponse>
}