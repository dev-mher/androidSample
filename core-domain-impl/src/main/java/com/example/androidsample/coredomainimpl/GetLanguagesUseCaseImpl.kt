package com.example.androidsample.coredomainimpl

import com.example.androidsample.coredataapi.LanguagesRepository
import com.example.androidsample.coredomainapi.GetLanguagesUseCase
import com.example.androidsample.coredomainapi.dto.LanguagesDomain
import io.reactivex.Single
import javax.inject.Inject

class GetLanguagesUseCaseImpl @Inject constructor(
    private val languagesRepository: LanguagesRepository
) : GetLanguagesUseCase {
    override fun getLanguages(): Single<LanguagesDomain> {
        return languagesRepository.getLanguages()
    }
}