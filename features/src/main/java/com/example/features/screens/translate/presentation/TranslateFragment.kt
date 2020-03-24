package com.example.features.screens.translate.presentation

import com.example.base.BaseFragment
import com.example.features.R

class TranslateFragment : BaseFragment<TranslatePresenter>(), TranslateView {

    override var layoutResource: Int = R.layout.fragment_translate

    override val presenter: TranslatePresenter? = null

}