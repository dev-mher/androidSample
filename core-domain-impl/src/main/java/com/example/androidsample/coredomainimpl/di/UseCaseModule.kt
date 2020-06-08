package com.example.androidsample.coredomainimpl.di

import com.example.androidsample.coredomainapi.GetLanguagesUseCase
import com.example.androidsample.coredomainapi.TranslateUseCase
import com.example.androidsample.coredomainimpl.GetLanguagesUseCaseImpl
import com.example.androidsample.coredomainimpl.TranslateUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun bindsTranslateUseCase(impl: TranslateUseCaseImpl): TranslateUseCase

    @Binds
    fun bindsGetLanguagesUseCase(impl: GetLanguagesUseCaseImpl): GetLanguagesUseCase
}
