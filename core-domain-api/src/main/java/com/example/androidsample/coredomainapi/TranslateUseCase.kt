package com.example.androidsample.coredomainapi

import com.example.androidsample.coredomainapi.dto.TranslateDomain
import io.reactivex.Single

interface TranslateUseCase {

    fun translate(language: String, text: String): Single<TranslateDomain>
}