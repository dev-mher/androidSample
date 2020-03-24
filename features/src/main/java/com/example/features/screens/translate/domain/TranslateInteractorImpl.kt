package com.example.features.screens.translate.domain

import com.example.androidsample.coredomainapi.TranslateUseCase
import com.example.features.screens.translate.presentation.TranslateInteractor
import javax.inject.Inject

class TranslateInteractorImpl @Inject constructor(
    translateUseCase: TranslateUseCase
) : TranslateInteractor,
    TranslateUseCase by translateUseCase