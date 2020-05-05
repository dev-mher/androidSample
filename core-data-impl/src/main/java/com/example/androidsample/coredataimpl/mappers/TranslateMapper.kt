package com.example.androidsample.coredataimpl.mappers

import com.example.androidsample.coreapiapi.dto.TranslateResponse
import com.example.androidsample.coredomainapi.dto.TranslateDomain

fun TranslateResponse.mapToTranslateDomain() = TranslateDomain(code, lang, text)