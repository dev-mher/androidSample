package com.example.androidsample.coredomainimpl.di

import com.example.androidsample.coredomainapi.TranslateUseCase
import com.example.androidsample.coredomainimpl.TranslateUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun bindsTranslateUseCase(impl: TranslateUseCaseImpl): TranslateUseCase
}
