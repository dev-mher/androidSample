package com.example.androidsample.coredi

import android.content.Context
import com.example.androidsample.coreapiapi.TranslateApi
import com.example.androidsample.coredataapi.TranslateRepository
import com.example.androidsample.coredomainapi.TranslateUseCase
import com.example.androidsample.corenetworkapi.ApiClient
import com.example.androidsample.corepersistenceapi.database.DatabaseManagerApi
import com.example.androidsample.corepersistenceapi.preference.PreferenceManagerApi

interface ApplicationProvider :
    AndroidProvider,
    NetworkProvider,
    ApiProvider,
    PersistenceProvider,
    RepositoryProvider,
    UseCaseProvider

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

interface PersistenceProvider {

    fun providePreferenceManager(): PreferenceManagerApi

    fun provideDatabaseManager(): DatabaseManagerApi
}