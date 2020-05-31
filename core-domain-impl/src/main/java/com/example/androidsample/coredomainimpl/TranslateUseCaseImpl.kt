package com.example.androidsample.coredomainimpl

import com.example.androidsample.coredataapi.TranslateRepository
import com.example.androidsample.coredomainapi.TranslateUseCase
import com.example.androidsample.coredomainapi.dto.TranslateDomain
import io.reactivex.Single
import javax.inject.Inject

class TranslateUseCaseImpl @Inject constructor(
    private val translateRepository: TranslateRepository
) : TranslateUseCase {

    override fun translate(language: String, text: String): Single<TranslateDomain> {
        return translateRepository.translate(language, text)
    }
}