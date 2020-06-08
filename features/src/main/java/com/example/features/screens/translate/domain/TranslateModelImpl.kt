package com.example.features.screens.translate.domain

import com.example.androidsample.coredomainapi.GetLanguagesUseCase
import com.example.androidsample.coredomainapi.TranslateUseCase
import com.example.features.screens.translate.presentation.TranslateModel
import javax.inject.Inject

class TranslateModelImpl @Inject constructor(
    translateUseCase: TranslateUseCase,
    getLanguagesUSeCase: GetLanguagesUseCase
) : TranslateModel,
    TranslateUseCase by translateUseCase,
        GetLanguagesUseCase by getLanguagesUSeCase