package com.example.base

interface BaseViewState {


    interface ProgressState {

        fun showBlockingLoadingProgress()

        fun hideBlockingLoadingProgress()
    }

}