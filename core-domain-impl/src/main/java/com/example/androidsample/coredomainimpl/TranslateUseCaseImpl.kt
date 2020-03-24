package com.example.androidsample.coredomainimpl

import com.example.androidsample.coredataapi.TranslateRepository
import com.example.androidsample.coredomainapi.TranslateUseCase
import javax.inject.Inject

class TranslateUseCaseImpl @Inject constructor(
    private val translateRepository: TranslateRepository
) : TranslateUseCase {

    override fun translate() {
        //TODO
    }
}