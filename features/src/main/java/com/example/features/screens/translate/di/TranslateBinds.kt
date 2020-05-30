package com.example.features.screens.translate.di

import com.example.androidsample.coredi.FragmentScope
import com.example.features.screens.translate.domain.TranslateModelImpl
import com.example.features.screens.translate.presentation.TranslateModel
import com.example.features.screens.translate.presentation.TranslatePresenter
import com.example.features.screens.translate.presentation.TranslatePresenterImpl
import dagger.Binds
import dagger.Module

@Module
interface TranslateBinds {

    @FragmentScope
    @Binds
    fun bindsTranslateModel(impl: TranslateModelImpl): TranslateModel

    @FragmentScope
    @Binds
    fun bindsTranslatePresenter(impl: TranslatePresenterImpl): TranslatePresenter
}