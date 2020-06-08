package com.example.androidsample.coredataimpl.di

import com.example.androidsample.coredataapi.LanguagesRepository
import com.example.androidsample.coredataapi.TranslateRepository
import com.example.androidsample.coredataimpl.LanguagesRepositoryImpl
import com.example.androidsample.coredataimpl.TranslateRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsTranslateRepository(impl: TranslateRepositoryImpl): TranslateRepository

    @Binds
    @Singleton
    fun bindsLanguagesRepository(impl: LanguagesRepositoryImpl): LanguagesRepository
}