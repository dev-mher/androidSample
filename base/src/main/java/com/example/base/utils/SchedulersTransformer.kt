package com.example.base.utils

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher

class SchedulersTransformer<T> : ObservableTransformer<T, T>,
    FlowableTransformer<T, T>,
    SingleTransformer<T, T>,
    MaybeTransformer<T, T>,
    CompletableTransformer {

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun apply(upstream: Maybe<T>): MaybeSource<T> {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun apply(upstream: Completable): CompletableSource {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}