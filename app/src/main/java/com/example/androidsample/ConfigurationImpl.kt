package com.example.androidsample

import android.content.Context
import android.os.Build
import com.example.androidsample.coredi.Configuration
import java.util.*

class ConfigurationImpl(private val context: Context) : Configuration {

    override fun getAppLocale(): Locale {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            context.resources.configuration.locales.get(0)
        else
            context.resources.configuration.locale
    }
}