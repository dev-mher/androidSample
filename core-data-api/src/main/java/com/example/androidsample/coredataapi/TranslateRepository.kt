package com.example.androidsample.coredataapi

import com.example.androidsample.coredomainapi.dto.TranslateDomain
import io.reactivex.Single

interface TranslateRepository {

    fun translate(language: String, text: String): Single<TranslateDomain>
}