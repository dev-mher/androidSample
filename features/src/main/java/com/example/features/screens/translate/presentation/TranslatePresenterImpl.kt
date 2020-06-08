package com.example.features.screens.translate.presentation

import com.example.base.BasePresenterImpl
import com.example.base.utils.RxUtils
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class TranslatePresenterImpl @Inject constructor(
    private val translateModel: TranslateModel
) : BasePresenterImpl<TranslateView>(), TranslatePresenter {

    override fun onTextChange(text: String) {
        addDispose(translateModel.translate("en-ru", text)
            .compose(RxUtils.applySchedulers())
            .subscribeBy(
                onSuccess = {
                    getView()?.setTranslatedText(it.text[0])
                },
                onError = {

                }
            ))
    }

    override fun getLanguagesFrom() {
        addDispose(translateModel.getLanguages()
            .compose(RxUtils.applySchedulers())
            .subscribeBy(
                onSuccess = {
                    val languages = arrayOf(
                        it.langs.am,
                        it.langs.ru,
                        it.langs.en,
                        it.langs.es,
                        it.langs.de
                        )
                    getView()?.showLanguagesFrom(*languages)
                },
                onError = {

                }
            ))
    }

    override fun getLanguagesTo() {
        addDispose(translateModel.getLanguages()
            .compose(RxUtils.applySchedulers())
            .subscribeBy(
                onSuccess = {
                    val languages = arrayOf(
                        it.langs.am,
                        it.langs.ru,
                        it.langs.en,
                        it.langs.es,
                        it.langs.de
                    )
                    getView()?.showLanguagesTo(*languages)
                },
                onError = {

                }
            ))
    }

}