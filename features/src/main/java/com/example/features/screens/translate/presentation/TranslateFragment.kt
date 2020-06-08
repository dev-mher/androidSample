package com.example.features.screens.translate.presentation

import android.os.Bundle
import android.view.View
import com.example.androidsample.coredi.App
import com.example.androidsample.coredomainapi.dto.LanguagesDomain
import com.example.base.BaseFragment
import com.example.features.R
import com.example.features.screens.translate.di.TranslateComponent
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.fragment_translate.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class TranslateFragment : BaseFragment<TranslatePresenter>(), TranslateView {

    override var layoutResource: Int = R.layout.fragment_translate

    override var presenter: TranslatePresenter? = null
        @Inject set

    override fun injectDependencies() {
        val applicationProvider = (requireActivity().application as App).getApplicationProvider()
        TranslateComponent.build(applicationProvider).inject(this)
        presenter?.attachView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addToDispose(RxTextView.afterTextChangeEvents(etInputText)
            .throttleFirst(THROTTLE_FIRST_TEXT, TimeUnit.MILLISECONDS)
            .subscribe {
                presenter?.onTextChange(it.editable().toString())
            })

        tvLanguageFrom.setOnClickListener {
            presenter?.getLanguagesFrom()
        }

        tvLanguageTo.setOnClickListener {
            presenter?.getLanguagesTo()
        }

    }

    //TODO link to  http://translate.yandex.ru

    companion object {
        const val THROTTLE_FIRST_TEXT = 1000L
        private const val CURRENT_LANGUAGE_INDEX = 0
    }

    override fun setTranslatedText(text: String) {
        tvTranslatedText.text = text
    }

    override fun showLanguagesFrom(vararg languages: String) {
        var currentLang = CURRENT_LANGUAGE_INDEX
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle(R.string.choose_language)
            .setSingleChoiceItems(languages, currentLang) { _, which -> currentLang = which }
            .setPositiveButton(R.string.choose) { _, _ ->
                tvLanguageFrom.text = languages[currentLang]
            }
            .show()
    }

    override fun showLanguagesTo(vararg languages: String) {
        var currentLang = CURRENT_LANGUAGE_INDEX
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle(R.string.choose_language)
            .setSingleChoiceItems(languages, currentLang) { _, which -> currentLang = which }
            .setPositiveButton(R.string.choose) { _, _ ->
                tvLanguageTo.text = languages[currentLang]
            }
            .show()
    }
}