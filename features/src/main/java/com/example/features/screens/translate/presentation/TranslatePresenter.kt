package com.example.features.screens.translate.presentation

import com.example.base.BasePresenterImpl
import javax.inject.Inject

class TranslatePresenter @Inject constructor(
    private val interactor: TranslateInteractor
) : BasePresenterImpl<TranslateView>() {
}