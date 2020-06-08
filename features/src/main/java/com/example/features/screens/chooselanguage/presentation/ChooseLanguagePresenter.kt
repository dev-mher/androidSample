package com.example.features.screens.chooselanguage.presentation

import com.example.base.BasePresenter

interface ChooseLanguagePresenter : BasePresenter<ChooseLanguageView> {

    fun getLanguages()
}