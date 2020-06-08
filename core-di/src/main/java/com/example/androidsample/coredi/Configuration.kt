package com.example.androidsample.coredi

import java.util.*

interface Configuration {

    fun getAppLocale(): Locale

    fun getApiKey(): String
}