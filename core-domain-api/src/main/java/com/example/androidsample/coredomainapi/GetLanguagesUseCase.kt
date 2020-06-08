package com.example.androidsample.coredomainapi

import com.example.androidsample.coredomainapi.dto.LanguagesDomain
import io.reactivex.Single

interface GetLanguagesUseCase {

    fun getLanguages(): Single<LanguagesDomain>
}