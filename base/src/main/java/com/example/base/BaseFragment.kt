package com.example.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseFragment<PRESENTER : BasePresenter<*>> : Fragment(), BaseView {

    @get: LayoutRes
    abstract var layoutResource: Int

    protected  abstract val presenter: PRESENTER?

    private val mCompositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutResource, container, false)
    }

    override fun onDestroyView() {
        presenter?.detachView()
        mCompositeDisposable.clear()
        super.onDestroyView()
    }

    protected fun addToDispose(disposable: Disposable){
        mCompositeDisposable.add(disposable)
    }

    override fun showBlockingLoadingProgress() {
        TODO("Not yet implemented")
    }

    override fun hideBlockingLoadingProgress() {
        TODO("Not yet implemented")
    }
}