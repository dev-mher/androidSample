package com.example.androidsample.coredomainapi.dto

data class TranslateDomain(
    val code: Int,
    val lang: String,
    val text: List<String>
)