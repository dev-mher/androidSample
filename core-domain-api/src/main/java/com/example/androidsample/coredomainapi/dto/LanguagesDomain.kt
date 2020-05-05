package com.example.androidsample.coredomainapi.dto

data class LanguagesDomain(
    val dirs: List<String>,
    val langs: LangsDomain
) {
    data class LangsDomain(
        val am: String,
        val de: String,
        val en: String,
        val es: String,
        val ru: String
    )
}