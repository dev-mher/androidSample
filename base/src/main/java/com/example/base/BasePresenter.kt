package com.example.base

interface BasePresenter<VIEW> where VIEW : BaseView {

    fun attachView(view: VIEW)

    fun detachView()

    fun getView(): VIEW?
}