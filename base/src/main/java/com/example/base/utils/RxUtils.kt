package com.example.base.utils

object RxUtils {

    fun <T> applySchedulers(): SchedulersTransformer<T> {
        return SchedulersTransformer()
    }
}