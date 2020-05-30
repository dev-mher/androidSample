package com.example.androidsample.coredataimpl

import com.example.androidsample.coreapiapi.TranslateApi
import com.example.androidsample.coredataapi.TranslateRepository
import javax.inject.Inject

class TranslateRepositoryImpl @Inject constructor(
    private val translateApi: TranslateApi
) : TranslateRepository {

    //TODO
    override fun translate() {
        translateApi.getLanguages()
    }
}