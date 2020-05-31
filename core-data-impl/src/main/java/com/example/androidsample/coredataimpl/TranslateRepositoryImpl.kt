package com.example.androidsample.coredataimpl

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
    private val preferenceManager: PreferenceManagerApi
) : TranslateRepository {

    override fun translate(language: String, text: String): Single<TranslateDomain> {
        return translateApi.translate(preferenceManager.apiKey.orEmpty(), language, text)
            .map { it.mapToTranslateDomain() }
    }
}