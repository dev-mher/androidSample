package com.example.androidsample.corenetworkimpl

import com.example.androidsample.corenetworkapi.ApiClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class ApiClientImpl : ApiClient {

    val okBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

    val adapterBuilder: Retrofit.Builder = Retrofit.Builder()

    override fun <S> createApi(apiClass: Class<S>): S {
        return adapterBuilder
            .client(okBuilder.build())
            .build()
            .create(apiClass)
    }
}