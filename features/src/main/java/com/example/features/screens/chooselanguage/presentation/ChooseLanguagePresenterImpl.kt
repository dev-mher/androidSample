package com.example.features.screens.chooselanguage.presentation

import com.example.base.BasePresenterImpl
import com.example.base.utils.RxUtils
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class ChooseLanguagePresenterImpl @Inject constructor(
    private val chooseLanguageModel: ChooseLanguageModel
): BasePresenterImpl<ChooseLanguageView>(), ChooseLanguagePresenter {
    override fun getLanguages() {
        addDispose(chooseLanguageModel.getLanguages()
            .compose(RxUtils.applySchedulers())
            .subscribeBy(
                onSuccess = {
                    getView()?.showLanguages(it.langs)
                },
                onError = {

                }
            ))
    }
}