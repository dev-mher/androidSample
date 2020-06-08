package com.example.androidsample.coredataimpl

import com.example.androidsample.coreapiapi.LanguagesApi
import com.example.androidsample.coredataapi.LanguagesRepository
import com.example.androidsample.coredataimpl.mappers.mapToLanguagesDomain
import com.example.androidsample.coredomainapi.dto.LanguagesDomain
import com.example.androidsample.corepersistenceapi.preference.PreferenceManagerApi
import io.reactivex.Single
import javax.inject.Inject

class LanguagesRepositoryImpl @Inject constructor(
    private val languagesApi: LanguagesApi,
    private val preferenceManager: PreferenceManagerApi,
    private val configuration: com.example.androidsample.coredi.Configuration
) : LanguagesRepository {
    override fun getLanguages(): Single<LanguagesDomain> {
        return languagesApi.getLanguages(configuration.getApiKey(), "ru").map { it.mapToLanguagesDomain() }
    }
}