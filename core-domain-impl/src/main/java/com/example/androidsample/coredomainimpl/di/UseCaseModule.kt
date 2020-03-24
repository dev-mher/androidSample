package com.example.androidsample.coredomainimpl.di

import com.example.androidsample.coredomainapi.TranslateUseCase
import com.example.androidsample.coredomainimpl.TranslateUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface UseCaseModule {

    @Binds
    @Singleton
    fun bindsTranslateUseCase(impl: TranslateUseCaseImpl): TranslateUseCase
}