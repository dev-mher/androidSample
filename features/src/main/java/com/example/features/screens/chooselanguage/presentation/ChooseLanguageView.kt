package com.example.features.screens.chooselanguage.presentation

import com.example.androidsample.coredomainapi.dto.LanguagesDomain
import com.example.base.BaseView

interface ChooseLanguageView : BaseView {

    fun showLanguages(languages: LanguagesDomain.LangsDomain)
}