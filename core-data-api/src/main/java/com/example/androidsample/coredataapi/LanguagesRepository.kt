package com.example.androidsample.coredataapi

import com.example.androidsample.coredomainapi.dto.LanguagesDomain
import io.reactivex.Single

interface LanguagesRepository {

    fun getLanguages(): Single<LanguagesDomain>
}