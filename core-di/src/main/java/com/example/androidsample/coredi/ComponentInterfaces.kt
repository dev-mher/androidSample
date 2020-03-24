package com.example.androidsample.coredi

import android.content.Context
import com.example.androidsample.coreapiapi.TranslateApi
import com.example.androidsample.coredataapi.TranslateRepository
import com.example.androidsample.coredomainapi.TranslateUseCase
import com.example.androidsample.corenetworkapi.ApiClient

interface ApplicationProvider :
    AndroidProvider,
    NetworkProvider

interface AndroidProvider {

    fun provideContext(): Context

    fun provideConfiguration(): Configuration
}

interface NetworkProvider {

    fun provideHttpClient(): ApiClient
}

interface ApiProvider {

    fun provideTranslateApi(): TranslateApi
}

interface RepositoryProvider {

    fun provideTranslateRepository(): TranslateRepository
}

interface UseCaseProvider {

    fun provideTranslateUseCase(): TranslateUseCase
}