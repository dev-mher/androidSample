package com.example.features.screens.translate.di

import com.example.androidsample.coredi.ApplicationProvider
import com.example.androidsample.coredi.FragmentScope
import com.example.features.screens.translate.presentation.TranslateFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationProvider::class],
    modules = [TranslateModule::class]
)
interface TranslateComponent {

    fun inject(fragment: TranslateFragment)

    companion object {
        fun build(applicationProvider: ApplicationProvider): TranslateComponent {
            return DaggerTranslateComponent.builder()
                .applicationProvider(applicationProvider)
                .build()
        }

    }
}