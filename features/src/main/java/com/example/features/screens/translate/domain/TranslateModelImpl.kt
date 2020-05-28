package com.example.features.screens.translate.domain

import com.example.androidsample.coredomainapi.TranslateUseCase
import com.example.features.screens.translate.presentation.TranslateModel
import javax.inject.Inject

class TranslateModelImpl @Inject constructor(
    translateUseCase: TranslateUseCase
) : TranslateModel,
    TranslateUseCase by translateUseCase