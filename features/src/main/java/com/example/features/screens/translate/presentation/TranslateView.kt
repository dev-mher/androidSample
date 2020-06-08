package com.example.features.screens.translate.presentation

import com.example.base.BaseView

interface TranslateView : BaseView {

    fun setTranslatedText(text: String)

    fun showLanguagesFrom(vararg languages: String)

    fun showLanguagesTo(vararg languages: String)
}