package com.example.features.screens.translate.presentation

import android.util.Log
import com.example.base.BasePresenterImpl
import javax.inject.Inject

class TranslatePresenterImpl @Inject constructor(
    private val translateModel: TranslateModel
) : BasePresenterImpl<TranslateView>(), TranslatePresenter {

    override fun onTextChange(text: String) {
        Log.d("===>", text)
    }

}