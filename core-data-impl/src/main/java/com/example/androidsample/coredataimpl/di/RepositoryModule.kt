package com.example.androidsample.coredataimpl.di

import com.example.androidsample.coredataapi.TranslateRepository
import com.example.androidsample.coredataimpl.TranslateRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsTranslateRepository(impl: TranslateRepositoryImpl): TranslateRepository
}