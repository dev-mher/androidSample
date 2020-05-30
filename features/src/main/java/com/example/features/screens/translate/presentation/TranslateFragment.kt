package com.example.features.screens.translate.presentation

import android.os.Bundle
import android.view.View
import com.example.androidsample.coredi.App
import com.example.base.BaseFragment
import com.example.features.R
import com.example.features.screens.translate.di.TranslateComponent
import com.jakewharton.rxbinding2.widget.RxTextView
import kotlinx.android.synthetic.main.fragment_translate.*
import javax.inject.Inject

class TranslateFragment : BaseFragment<TranslatePresenter>(), TranslateView {

    override var layoutResource: Int = R.layout.fragment_translate

    override var presenter: TranslatePresenter? = null
    @Inject set

    override fun injectDependencies() {
        val applicationProvider = (requireActivity() as App).getApplicationProvider()
        TranslateComponent.build(applicationProvider).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addToDispose(RxTextView.afterTextChangeEvents(etInputText)
            .subscribe {
                presenter?.onTextChange(it.editable().toString())
            })
    }

    //TODO link to  http://translate.yandex.ru

}