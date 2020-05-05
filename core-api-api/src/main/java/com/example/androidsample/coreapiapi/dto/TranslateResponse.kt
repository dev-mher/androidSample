package com.example.androidsample.coreapiapi.dto

data class TranslateResponse(
    val code: Int,
    val lang: String,
    val text: List<String>
)