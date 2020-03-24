package com.example.base

import androidx.lifecycle.Lifecycle

interface BaseView : BaseViewState.ProgressState {

    fun getLifecycle(): Lifecycle
}