package com.example.androidsample.coreapiapi.dto

data class LanguagesResponse(
    val dirs: List<String>,
    val langs: Langs
) {
    data class Langs(
        val am: String,
        val de: String,
        val en: String,
        val es: String,
        val ru: String
    )
}