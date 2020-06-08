package com.example.features.screens.chooselanguage.di

import com.example.androidsample.coredi.ApplicationProvider
import com.example.androidsample.coredi.FragmentScope
import com.example.features.screens.chooselanguage.presentation.ChooseLanguageFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationProvider::class],
    modules = [ChooseLanguageBinds::class]
)
interface ChooseLanguageComponent {

    fun inject(chooseLanguageFragment: ChooseLanguageFragment)

    companion object {
        fun build(applicationProvider: ApplicationProvider): ChooseLanguageComponent {
            return DaggerChooseLanguageComponent.builder()
                .applicationProvider(applicationProvider)
                .build()
        }
    }
}