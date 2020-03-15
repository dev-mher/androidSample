package com.example.androidsample.corenetworkapi

interface ApiClient {

    fun <S> createApi(apiClass: Class<S>): S
}