package com.example.base

import androidx.lifecycle.LifecycleObserver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

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

    fun addDispose(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    override fun getView(): VIEW? {
        return mView
    }
}