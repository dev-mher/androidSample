package com.example.androidsample.coredi

import android.content.Context
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