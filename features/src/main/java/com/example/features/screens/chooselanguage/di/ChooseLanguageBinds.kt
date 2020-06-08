package com.example.features.screens.chooselanguage.di

import com.example.androidsample.coredi.FragmentScope
import com.example.features.screens.chooselanguage.domain.ChooseLanguageModelImpl
import com.example.features.screens.chooselanguage.presentation.ChooseLanguageModel
import com.example.features.screens.chooselanguage.presentation.ChooseLanguagePresenter
import com.example.features.screens.chooselanguage.presentation.ChooseLanguagePresenterImpl
import dagger.Binds
import dagger.Module

@Module
interface ChooseLanguageBinds {

    @FragmentScope
    @Binds
    fun bindsChooseLanguageModel(impl: ChooseLanguageModelImpl): ChooseLanguageModel

    @FragmentScope
    @Binds
    fun bindsChooseLanguagePresenter(impl: ChooseLanguagePresenterImpl): ChooseLanguagePresenter
}