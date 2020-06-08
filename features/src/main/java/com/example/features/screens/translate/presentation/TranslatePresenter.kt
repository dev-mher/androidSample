package com.example.features.screens.translate.presentation

import com.example.base.BasePresenter

interface TranslatePresenter : BasePresenter<TranslateView> {

    fun onTextChange(text: String)

    fun getLanguagesFrom()

    fun getLanguagesTo()
}