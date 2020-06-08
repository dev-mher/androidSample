package com.example.features.screens.chooselanguage.domain

import com.example.androidsample.coredomainapi.GetLanguagesUseCase
import com.example.features.screens.chooselanguage.presentation.ChooseLanguageModel
import javax.inject.Inject

class ChooseLanguageModelImpl @Inject constructor(
    private val getLanguagesUseCase: GetLanguagesUseCase
) : ChooseLanguageModel,
    GetLanguagesUseCase by getLanguagesUseCase