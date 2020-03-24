package com.example.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseActivity<PRESENTER : BasePresenter<*>> : AppCompatActivity(), BaseView {

    @get:LayoutRes
    abstract val layoutResource: Int

    protected abstract val presenter: PRESENTER?

    private val mCompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        presenter?.detachView()
        mCompositeDisposable.clear()
        super.onDestroy()
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