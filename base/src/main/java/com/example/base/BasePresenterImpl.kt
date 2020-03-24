package com.example.base

import androidx.lifecycle.LifecycleObserver
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenterImpl<VIEW : BaseView> : BasePresenter<VIEW>, LifecycleObserver {

    private val mCompositeDisposable = CompositeDisposable()

    private var mView: VIEW? = null

    override fun attachView(view: VIEW) {
        mView = view
        view.getLifecycle().addObserver(this)
    }

    override fun detachView() {
        mView?.getLifecycle()?.removeObserver(this)
        mView = null
        mCompositeDisposable.clear()
    }

    override fun getView(): VIEW? {
        return mView
    }
}