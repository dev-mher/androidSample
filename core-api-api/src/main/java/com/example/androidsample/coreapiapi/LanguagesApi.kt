package com.example.androidsample.coreapiapi

import com.example.androidsample.coreapiapi.dto.LanguagesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface LanguagesApi {

    @GET("getLangs")
    fun getLanguages(
        @Query("key") key: String,
        @Query("ui") lang: String
    ): Single<LanguagesResponse>
}