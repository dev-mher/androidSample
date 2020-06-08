package com.example.androidsample.coreapiimpl

import com.example.androidsample.coreapiapi.LanguagesApi
import com.example.androidsample.coreapiapi.TranslateApi
import com.example.androidsample.corenetworkapi.ApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun provideTranslateApi(apiClient: ApiClient) : TranslateApi = apiClient.createApi(TranslateApi::class.java)

    @Singleton
    @Provides
    fun provideLanguagesApi(apiClient: ApiClient) : LanguagesApi = apiClient.createApi(LanguagesApi::class.java)
}