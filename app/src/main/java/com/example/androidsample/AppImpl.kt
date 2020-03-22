package com.example.androidsample

import android.app.Application
import com.example.androidsample.coredi.App
import com.example.androidsample.coredi.ApplicationProvider
import com.example.androidsample.di.ApplicationComponent

class AppImpl : Application(), App {

    private val appProvider: ApplicationProvider by lazy { ApplicationComponent.build(this) }

    override fun getApplicationProvider(): ApplicationProvider  = appProvider
}