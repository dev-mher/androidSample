package com.example.features.screens.chooselanguage.presentation

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.androidsample.coredi.App
import com.example.androidsample.coredomainapi.dto.LanguagesDomain
import com.example.base.BaseFragment
import com.example.features.R
import com.example.features.screens.chooselanguage.di.ChooseLanguageComponent
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import javax.inject.Inject

class ChooseLanguageFragment : BaseFragment<ChooseLanguagePresenter>(), ChooseLanguageView {

    override var layoutResource: Int = R.layout.fragment_choose_language

    override var presenter: ChooseLanguagePresenter? = null
        @Inject set

    override fun injectDependencies() {
        val applicationProvider = ((requireActivity().application) as App).getApplicationProvider()
        ChooseLanguageComponent.build(applicationProvider).inject(this)
        presenter?.attachView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.getLanguages()
    }

    override fun showLanguages(languages: LanguagesDomain.LangsDomain) {
        val langs = arrayOf(
            languages.am,
            languages.de,
            languages.en,
            languages.es,
            languages.ru
        )
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle(R.string.title_choose_language)
            .setSingleChoiceItems(langs, 0) { _, _ ->  }
            .setPositiveButton("Выбрать") { _, which ->
                Log.d("===>", which.toString())
            }
            .show()
    }
}