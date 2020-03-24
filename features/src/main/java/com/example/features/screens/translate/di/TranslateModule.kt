package com.example.features.screens.translate.di

import com.example.features.screens.translate.domain.TranslateInteractorImpl
import com.example.features.screens.translate.presentation.TranslateInteractor
import dagger.Binds
import dagger.Module

@Module
interface TranslateModule {

    @Binds
    fun bindsInteractor(impl: TranslateInteractorImpl): TranslateInteractor
}