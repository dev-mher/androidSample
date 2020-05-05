package com.example.androidsample.coredataimpl.mappers

import com.example.androidsample.coreapiapi.dto.LanguagesResponse
import com.example.androidsample.coredomainapi.dto.LanguagesDomain

fun LanguagesResponse.mapToLanguagesDomain() = LanguagesDomain(
    dirs,
    langs.mapToLangsDomain()
)

fun LanguagesResponse.Langs.mapToLangsDomain() = LanguagesDomain.LangsDomain(am, de, en, es, ru)
