package com.example.androidsample.coredataimpl

import android.content.res.Configuration
import android.util.Log
import com.example.androidsample.coreapiapi.TranslateApi
import com.example.androidsample.coredataapi.TranslateRepository
import com.example.androidsample.coredataimpl.mappers.mapToTranslateDomain
import com.example.androidsample.coredomainapi.dto.TranslateDomain
import com.example.androidsample.corepersistenceapi.preference.PreferenceManagerApi
import io.reactivex.Single
import javax.inject.Inject

class TranslateRepositoryImpl @Inject constructor(
    private val translateApi: TranslateApi,
    private val preferenceManager: PreferenceManagerApi,
    private val configuration: com.example.androidsample.coredi.Configuration
) : TranslateRepository {

    override fun translate(language: String, text: String): Single<TranslateDomain> {
        return translateApi.translate(configuration.getApiKey(), language, text)
            .map { it.mapToTranslateDomain() }
    }
}